package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>ItemTypes</b>
 * <p>
 * This is a named Map of all {@link IItemTypes ItemTypes}s, where the name of each entry in the Map is the Id of the corresponding ItemType.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IItemTypes extends IMap<String,IItemType>, ISoliloquyClass {
}
