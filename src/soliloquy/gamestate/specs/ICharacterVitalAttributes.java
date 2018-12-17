package soliloquy.gamestate.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>CharacterVitalAttributes</b>
 * <p>
 * It is a named set of Vital Attributes for a Character, where the index for the set is the Vital Attribute Type Id.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterVitalAttributes extends IMap<String,ICharacterVitalAttribute>, ISoliloquyClass {
}
