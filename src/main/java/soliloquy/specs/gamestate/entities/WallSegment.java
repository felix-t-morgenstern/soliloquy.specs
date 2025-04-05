package soliloquy.specs.gamestate.entities;

import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.gamestate.entities.shared.GameZoneTerrain;
import soliloquy.specs.ruleset.entities.WallSegmentType;

/**
 * <b>TileWallSegment</b>
 * <p>
 * This is a WallSegment between Tiles.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface WallSegment extends GameEventTargetEntity, GameZoneTerrain {
    /**
     * @return The WallSegmentType of this TileWallSegment
     * @throws EntityDeletedException If this TileWallSegment has been deleted
     */
    WallSegmentType getType() throws EntityDeletedException;

    /**
     * @param wallSegmentType The WallSegmentType to set for this TileWallSegment
     * @throws IllegalArgumentException If and only if wallSegmentType is null
     * @throws EntityDeletedException   If this TileWallSegment has been deleted
     */
    void setType(WallSegmentType wallSegmentType)
            throws IllegalArgumentException, EntityDeletedException;


}
