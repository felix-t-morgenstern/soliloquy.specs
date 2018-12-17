package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>IEquipmentTypes</b>
 * <p>
 * This is a named Map of all EquipmentTypes, where every name in the Map corresponds to an {@link IEquipmentType} with the corresponding Id.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IEquipmentTypes extends IMap<String,IEquipmentType>, ISoliloquyClass {
}
