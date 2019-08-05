package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Collection;
import soliloquy.specs.common.infrastructure.GenericParamsSet;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>Party</b>
 * <p>
 * The Party stores a Collection of the player-controlled Characters; and attributes of the Party,
 * e.g. gold, military rank, group combat blessings
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Party extends SoliloquyClass {
	/**
	 * @return A Collection of all player-controlled Characters
	 */
	Collection<Character> playerCharacters();
	
	/**
	 * @return A set of attributes of the Party, e.g. gold, military rank, group combat blessings
	 */
	GenericParamsSet partyAttributes();
}