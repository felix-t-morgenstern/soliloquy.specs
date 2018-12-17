package soliloquy.gamestate.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>CharacterAptitudes</b>
 * <p>
 * This is a Map of a Character's Aptitudes, e.g. Chance to Dodge, Initiative, Polemics
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterAptitudes extends IMap<String,ICharacterValueFromModifiers>, ISoliloquyClass {
}
