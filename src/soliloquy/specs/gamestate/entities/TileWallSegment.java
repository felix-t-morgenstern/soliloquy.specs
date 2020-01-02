package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.ruleset.entities.WallSegmentType;

/**
 * <b>TileWallSegment</b>
 * <p>
 * This is a WallSegment in a Tile. It has a WallSegmentType, and a height.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface TileWallSegment extends TileEntity, HasName {
	/**
	 * @return The WallSegmentType of this TileWallSegment
	 * @throws IllegalStateException If this TileWallSegment has no type, or has been deleted
	 */
	WallSegmentType getType() throws IllegalStateException;
	
	/**
	 * @param wallSegmentType - The WallSegmentType to set for this TileWallSegment
	 * @throws IllegalStateException If this TileWallSegment has no type, or has been deleted
	 */
	void setType(WallSegmentType wallSegmentType) throws IllegalStateException;
}
