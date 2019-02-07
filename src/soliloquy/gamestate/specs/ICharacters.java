package soliloquy.gamestate.specs;

import soliloquy.common.specs.IEntityUuid;
import soliloquy.common.specs.IMap;

/**
 * <b>Characters</b>
 * <p>
 * This is a Set of all Characters which exist in this GameZone. The index of this Set is the Character's Uuid.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacters extends IMap<IEntityUuid,ICharacter> {
}
