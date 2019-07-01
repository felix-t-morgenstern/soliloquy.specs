package soliloquy.specs.gamestate.valueobjects;

import soliloquy.specs.common.infrastructure.IMap;
import soliloquy.specs.common.infrastructure.IPersistentVariableCache;
import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.gamestate.entities.IGameZone;
import soliloquy.specs.gamestate.entities.IParty;
import soliloquy.specs.gamestate.entities.IRoundManager;
import soliloquy.specs.ruleset.IRuleset;
import soliloquy.specs.ruleset.entities.ICharacterAIType;
import soliloquy.specs.gamestate.entities.IKeyBindingContext;

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
public interface IGameState extends ISoliloquyClass {
	/**
	 * If the Party object has not yet been initialized, 
	 * @return The Party (i.e. the player's Characters)
	 */
	IParty party() throws IllegalStateException;
	
	/**
	 * @return The caches of persistent variables for the Game (i.e. variables keeping track of
	 * in-Game events, e.g. quests, party choices, etc.)
	 */
	IPersistentVariableCache persistentVariables();
	
	/**
	 * @return A Map of AIs which can be assigned to various characters
	 */
	IMap<String, ICharacterAIType> characterAIs();
	
	/**
	 * @return A repository which can retrieve GameZones
	 */
	IGameZonesRepo gameZonesRepo();
	
	/**
	 * @return The current GameZone. (It is allowed to be null.)
	 */
	IGameZone getCurrentGameZone();
	
	/**
	 * @param gameZone - The new current GameZone. (It is allowed to be null.)
	 */
	void setCurrentGameZone(IGameZone gameZone);
	
	/**
	 * @return The RoundManager, i.e. the class which handles Characters' turns, Timers, and the
	 * advancement of rounds
	 */
	IRoundManager roundManager();
	
	/**
	 * @return The current KeyBindingContexts (i.e. the Actions which take place when various keys
	 * are pressed)
	 * @throws IllegalStateException If KeyBindingContexts is undefined.
	 */
	IMap<Integer, IKeyBindingContext> keyBindingContexts() throws IllegalStateException;

	/**
	 * @return The Ruleset
	 */
	IRuleset ruleset();
}
