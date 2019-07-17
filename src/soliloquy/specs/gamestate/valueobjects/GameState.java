package soliloquy.specs.gamestate.valueobjects;

import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.common.infrastructure.PersistentVariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.GameZone;
import soliloquy.specs.gamestate.entities.Party;
import soliloquy.specs.gamestate.entities.RoundManager;
import soliloquy.specs.ruleset.Ruleset;
import soliloquy.specs.ruleset.entities.CharacterAIType;
import soliloquy.specs.gamestate.entities.KeyBindingContext;

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
	 * @return The Party (i.e. the player's Characters)
	 */
	Party party() throws IllegalStateException;
	
	/**
	 * @return The caches of persistent variables for the Game (i.e. variables keeping track of
	 * in-Game events, e.g. quests, party choices, etc.)
	 */
	PersistentVariableCache persistentVariables();
	
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
	 * @return The RoundManager, i.e. the class which handles Characters' turns, Timers, and the
	 * advancement of rounds
	 */
	RoundManager roundManager();
	
	/**
	 * @return The current KeyBindingContexts (i.e. the Actions which take place when various keys
	 * are pressed)
	 * @throws IllegalStateException If KeyBindingContexts is undefined.
	 */
	Map<Integer, KeyBindingContext> keyBindingContexts() throws IllegalStateException;

	/**
	 * @return The Ruleset
	 */
	Ruleset ruleset();
}
