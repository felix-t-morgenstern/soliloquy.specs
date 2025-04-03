package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.gamestate.entities.shared.HasData;
import soliloquy.specs.ruleset.entities.WallSegmentType;

/**
 * <b>TileWallSegment</b>
 * <p>
 * This is a WallSegment between Tiles. It has a WallSegmentType, and a height.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface WallSegment extends GameEventTargetEntity, HasName, HasData {
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
