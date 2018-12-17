package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>VitalAttributes</b>
 * <p>
 * It is a named set of VitalAttribute entities, where the set’s index values are VitalAttribute type Ids
 * 
 * @author felix.t.moregenstern
 * @version 0.0.1
 *
 */
public interface IVitalAttributes extends IMap<String,IVitalAttribute>, ISoliloquyClass {
}
