package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.valueobjects.ICollection;
import soliloquy.specs.common.valueobjects.IGenericParamsSet;
import soliloquy.specs.common.shared.ISoliloquyClass;

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
public interface IParty extends ISoliloquyClass {
	/**
	 * @return A Collection of all player-controlled Characters
	 */
	ICollection<ICharacter> playerCharacters();
	
	/**
	 * @return A set of attributes of the Party, e.g. gold, military rank, group combat blessings
	 */
	IGenericParamsSet partyAttributes();
}
