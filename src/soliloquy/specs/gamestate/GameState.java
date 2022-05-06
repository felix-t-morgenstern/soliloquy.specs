package soliloquy.specs.gamestate;

import soliloquy.specs.common.infrastructure.Registry;
import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.*;
import soliloquy.specs.gamestate.entities.gameevents.GameAbilityEvent;
import soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent;
import soliloquy.specs.gamestate.entities.timers.RoundBasedTimerManager;
import soliloquy.specs.gamestate.factories.*;
import soliloquy.specs.ruleset.entities.CharacterAIType;

import java.util.Map;

/**
 * <b>GameState</b>
 * <p>
 * This is a representation of the GameState.
 * <p>
 * The GameState includes the Party, PersistentVariables, the current GameZone, round management,
 * and key bindings.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface GameState extends SoliloquyClass {
	/**
	 * If the Party object has not yet been initialized, 
	 * @return The Party (i.e., the player's Characters)
	 */
	Party party() throws IllegalStateException;
	
	/**
	 * @return The caches of persistent variables for the Game (i.e., variables keeping track of
	 * in-Game movementEvents, e.g. quests, party choices, etc.)
	 */
	VariableCache variableCache();
	
	/**
	 * @return A Map of AIs which can be assigned to various characters
	 */
	Map<String, CharacterAIType> characterAIs();
	
	/**
	 * @return A repository which can retrieve GameZones
	 */
	GameZonesRepo gameZonesRepo();
	
	/**
	 * @return The current GameZone. (It is allowed to be null.)
	 */
	GameZone getCurrentGameZone();
	
	/**
	 * @param gameZone - The new current GameZone. (It is allowed to be null.)
	 */
	void setCurrentGameZone(GameZone gameZone);

	/**
	 * @return The Camera
	 */
	Camera camera();

	/**
	 * @return A Registry of game events triggered by a Character moving onto a Tile
	 */
	Registry<GameMovementEvent> movementEvents();

	/**
	 * @return A Registry of game events triggered by a Character's or Item's Ability being used on
	 * a Tile
	 */
	Registry<GameAbilityEvent> abilityEvents();
	
	/**
	 * @return The RoundManager, i.e., the class which handles Characters' turns, Timers, and the
	 * advancement of rounds
	 */
	RoundManager roundManager();

	/**
	 * @return The RoundBasedTimerManager, i.e., the class which tracks
	 * {@link soliloquy.specs.gamestate.entities.timers.RoundBasedTimer}, and fires them when
	 * specified.
	 */
	RoundBasedTimerManager roundBasedTimerManager();
	
	/**
	 * @return The current KeyBindingContexts (i.e., the Actions which take place when various keys
	 * are pressed)
	 * @throws IllegalStateException If KeyBindingContexts is undefined.
	 */
	Map<Integer, KeyBindingContext> keyBindingContexts() throws IllegalStateException;

	/**
	 */
	ItemFactory itemFactory();

	/**
	 */
	CharacterFactory characterFactory();

	/**
	 */
	RoundBasedTimerFactory roundBasedTimerFactory();

	/**
	 */
	KeyBindingFactory keyBindingFactory();

	/**
	 */
	KeyBindingContextFactory keyBindingContextFactory();

	/**
	 */
	KeyEventListener keyEventListener();
}
