package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>TileWallSegmentDimensions</b>
 * <p>
 * This is the dimensions of a {@link TileWallSegment}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileWallSegmentDimensions extends SoliloquyClass {
    /**
     * @return The z index of the TileWallSegment
     */
    int getZIndex();

    /**
     * @return The height of the TileWallSegment
     */
    int getHeight();
}
