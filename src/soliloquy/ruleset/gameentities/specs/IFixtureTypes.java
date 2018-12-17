package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>FixtureTypes</b>
 * <p>
 * This is a named Map of all {@link IFixtureType FixtureType}s, where the name of each entry in the Map is the Id of the corresponding FixtureType.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IFixtureTypes extends IMap<String,IFixtureType>, ISoliloquyClass {
}
