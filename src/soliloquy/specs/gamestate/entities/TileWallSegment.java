package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Pair;
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
public interface TileWallSegment extends GameEntity, HasName {
	/**
	 * @return The WallSegmentType of this TileWallSegment
	 * @throws IllegalStateException If this TileWallSegment has no type, or has been deleted
	 */
	WallSegmentType getWallSegmentType() throws IllegalStateException;
	
	/**
	 * @param wallSegmentType - The WallSegmentType to set for this TileWallSegment
	 * @throws IllegalStateException If this TileWallSegment has no type, or has been deleted
	 */
	void setWallSegmentType(WallSegmentType wallSegmentType) throws IllegalStateException;
	
	/**
	 * @return The height of this TileWallSegment
	 * @throws IllegalStateException If this TileWallSegment has no type, or has been deleted
	 */
	int getHeight() throws IllegalStateException;
	
	/**
	 * @param height - The height to set for this TileWallSegment
	 * @throws IllegalArgumentException If you want to enforce any minimum or maximum height
	 * values, enforce that invariant here, and throw this exception
	 * @throws IllegalStateException If this TileWallSegment has no type, or has been deleted
	 */
	void setHeight(int height) throws IllegalArgumentException, IllegalStateException;

	/**
	 * @return The z-index of this TileWallSegment
	 * @throws IllegalStateException If this TileWallSegment has no type, or has been deleted
	 */
	int getZIndex() throws IllegalStateException;

	/**
	 * @param zIndex - The z-index to set for this TileWallSegment
	 * @throws IllegalStateException If this TileWallSegment has no type, or has been deleted
	 */
	void setZIndex(int zIndex) throws IllegalStateException;

    /**
     * @return A {@link soliloquy.specs.common.infrastructure.Pair} containing both the
     * {@link TileWallSegmentDirection} and {@Tile} of this TileWallSegment. If this
     * TileWallSegment is not contained in a Tile, this method returns null.
     */
	Pair<TileWallSegmentDirection,Tile> getTile();

    /**
     * @param tileWallSegmentDirection - The {@link TileWallSegmentDirection} this TileWallSegment
     *                                 will face
     * @param tile - The {@link Tile} to assign to this TileWallSegment
     * @throws IllegalArgumentException If and only if tileWallSegmentDirection is null, or
     * unknown, or not found; or if wallSegments is null
     * @throws IllegalStateException
     */
    void assignTileWallSegmentsToTileAfterAddingToTileWallSegments
            (TileWallSegmentDirection tileWallSegmentDirection, Tile tile)
        throws IllegalArgumentException, IllegalStateException;
}
