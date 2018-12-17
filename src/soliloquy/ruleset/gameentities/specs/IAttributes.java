package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IEntityGroup;
import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>Attributes</b>
 * <p>
 * A Collection of Attribute Ids.
 * <p>
 * (CharacterAttributes are either calculated algorithmically in a single instance, or are stored statically. See {@link soliloquy.gamestate.specs.ICharacterAttributes} for more information.
 * 
 * @author felix.t.morgenstern
 *
 */
public interface IAttributes extends IMap<String,IAttribute>, IEntityGroup<IAttribute>, ISoliloquyClass {
}
