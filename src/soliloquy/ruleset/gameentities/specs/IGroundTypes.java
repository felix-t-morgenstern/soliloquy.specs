package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>GroundTypes</b>
 * <p>
 * This is a named Map of all {@link IGroundTypes GroundTypes}s, where the name of each entry in the Map is the Id of the corresponding GroundType.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IGroundTypes extends IMap<String,IGroundType>, ISoliloquyClass {
}
