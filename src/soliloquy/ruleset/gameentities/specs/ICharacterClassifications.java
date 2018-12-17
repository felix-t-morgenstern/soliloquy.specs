package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>CharacterClassifications</b>
 * <p>
 * A Collection of CharacterClassifications
 * <p>
 * All members of the Collection must have the same Id as their key in this Collection, otherwise an IllegalStateException should be thrown. 
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterClassifications extends IMap<String,ICharacterClassification>, ISoliloquyClass {
}
