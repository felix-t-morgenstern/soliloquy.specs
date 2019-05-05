package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IHasId;

/**
 * <b>CharacterEventType</b>
 * <p>
 * This interface exists because CharacterEvents must be identified by name, and they must have
 * the exact same behavior, so they can be successfully saved to files and read from files without
 * losing any information about them.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterEventType extends IHasId {
	/**
	 * The function which is executed when a CharacterEvent of this type is fired
	 * @param params - Parameters specifying how this CharacterEvent will behave, e.g. which
	 * Character killed this Character, which Tile's trap went off to kill this Character, the Tile
	 * this Character will turn to face, etc.
	 */
	void onFire(IGenericParamsSet params);
}
