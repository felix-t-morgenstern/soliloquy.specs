package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.infrastructure.IGenericParamsSet;
import soliloquy.specs.common.shared.IHasId;
import soliloquy.specs.common.shared.IHasPluralName;
import soliloquy.specs.gamestate.entities.ICharacter;
import soliloquy.specs.gamestate.entities.ITile;

/**
 * <b>CharacterType</b>
 * <p>
 * It has an Id, and it can generate a {@link ICharacter Character} of
 * this CharacterType on a Tile. It may generate this new Character's Id automatically, or it can
 * be fed an Id.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterType extends IHasPluralName, IHasId {
	/**
	 * Generates a Character of this CharacterType
	 * @param tile - The Tile in which to place the new Character; can be null
	 * @param params - Parameters specifying how this Character is to be created (e.g. whether it
	 * is hidden, parameters adjusting dynamic attribute generation, etc.); can be null
	 * @return The newly-created Character
	 */
	ICharacter generate(ITile tile, IGenericParamsSet params);
}
