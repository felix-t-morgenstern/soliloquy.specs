package soliloquy.gamestate.specs;

import soliloquy.common.specs.IMap;

/**
 * <b>CharacterAttributes</b>
 * <p>
 * This is a Set of a Character's Attributes, e.g. Strength, Earth Magic, Soothing, Knowledge: Theology
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterAttributes extends IMap<String,ICharacterValueFromModifiers> {
}
