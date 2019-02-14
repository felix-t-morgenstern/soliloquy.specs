package soliloquy.gamestate.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.IPersistentVariableCache;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>GameState</b>
 * <p>
 * This is a representation of the GameState.
 * <p>
 * The GameState includes the Party, PersistentVariables, the current GameZone, round management, and key bindings.
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
	 * @return The caches of persistent variables for the Game (i.e. variables keeping track of in-Game events, e.g. quests, party choices, etc.)
	 */
	IPersistentVariableCache gameStatePVars();
	
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
	 * @return The RoundManager, i.e. the class which handles Characters' turns, Timers, and the advancement of rounds
	 */
	IRoundManager roundManager();
	
	/**
	 * @return The current KeyBindingContexts (i.e. the Actions which take place when various keys are pressed)
	 * @throws IllegalStateException If KeyBindingContexts is undefined.
	 */
	IMap<Integer,IKeyBindingContext> keyBindingContexts() throws IllegalStateException;
}
