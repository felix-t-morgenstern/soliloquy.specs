package soliloquy.specs.gamestate.entities;

import soliloquy.specs.ruleset.entities.IWallSegmentType;

/**
 * <b>TileWallSegment</b>
 * <p>
 * This is a WallSegment in a Tile. It has a WallSegmentType, and a height.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ITileWallSegment extends IGameEntity {
	/**
	 * @return The WallSegmentType of this TileWallSegment
	 * @throws IllegalStateException If this TileWallSegment has no type, or has been deleted
	 */
	IWallSegmentType getWallSegmentType() throws IllegalStateException;
	
	/**
	 * @param wallSegmentType - The WallSegmentType to set for this TileWallSegment
	 * @throws IllegalStateException If this TileWallSegment has no type, or has been deleted
	 */
	void setWallSegmentType(IWallSegmentType wallSegmentType) throws IllegalStateException;
	
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
}
