package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.TileWallSegment;

/**
 * <b>TileFactory</b>
 * <p>
 * This class creates TileWallSegments
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileWallSegmentFactory extends SoliloquyClass {
    /**
     * @return A newly-created TileWallSegment
     */
    TileWallSegment make();

    /**
     * @param data The data to assign to the newly-created TileWallSegment
     * @return A newly-created TileWallSegment with the provided data
     */
    TileWallSegment make(VariableCache data);
}
