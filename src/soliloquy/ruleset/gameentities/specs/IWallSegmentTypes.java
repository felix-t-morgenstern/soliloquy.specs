package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IMap;

/**
 * <b>WallSegmentTypes</b>
 * <p>
 * This is a named Map of all {@link IWallSegmentType WallSegmentType}s, where the name of each entry in the Map is the Id of the corresponding WallSegmentType.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IWallSegmentTypes extends IMap<String,IWallSegmentType> {
}
