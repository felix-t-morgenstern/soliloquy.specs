package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>StatusEffectTypes</b>
 * <p>
 * It is a named set of VitalAttribute entities, where the set’s index values are StatusEffect type Ids
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IStatusEffectTypes extends IMap<String,IStatusEffectType>, ISoliloquyClass {
}
