package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IHasId;
import soliloquy.common.specs.IHasPluralName;
import soliloquy.gamestate.specs.ICharacter;
import soliloquy.gamestate.specs.ITile;

/**
 * <b>CharacterType</b>
 * <p>
 * It has an Id, and it can generate a {@link soliloquy.gamestate.specs.ICharacter Character} of this CharacterType on a Tile. It may generate this new Character's Id automatically, or it can be fed an Id.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterType extends IGameEntity, IHasPluralName, IHasId {
	/**
	 * Generates a Character of this CharacterType
	 * @param tile - The Tile in which to place the new Character 
	 * @param params - Parameters specifying how this Character is to be created (e.g. whether it is hidden, parameters adjusting dynamic attribute creation, etc.), can be null
	 * @return The newly-created Character
	 * @throws IllegalArgumentException If tile is null, or does not have a GameZone
	 */
	ICharacter generate(ITile tile, IGenericParamsSet params) throws IllegalArgumentException;
}
