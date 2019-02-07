package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IReads;
import soliloquy.common.specs.IWrites;

/**
 * <b>Party</b>
 * <p>
 * The Party stores a Collection of the player-controlled Characters; and attributes of the Party, e.g. gold, military rank, group combat blessings
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IParty extends IReads, IWrites {
	/**
	 * @return A Collection of all player-controlled Characters
	 */
	ICollection<ICharacter> playerCharacters();
	
	/**
	 * @return A set of attributes of the Party, e.g. gold, military rank, group combat blessings
	 */
	IGenericParamsSet partyAttributes();
}
