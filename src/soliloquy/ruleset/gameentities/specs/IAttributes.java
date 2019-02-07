package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IEntityGroup;

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
public interface IAttributes extends IEntityGroup<IAttribute> {
}
