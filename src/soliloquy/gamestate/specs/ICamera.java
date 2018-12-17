package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ICoordinate;

/**
 * <b>Camera</b>
 * <p>
 * Camera is used to describe what the player sees, i.e. the center of their view in the GameWorld, and which Tiles are rendered.
 * <p>
 * The Camera is fed into the GameWorldView, which takes snapshots from the Camera, which are then rendered by WindowRenderer.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICamera {
	/**
	 * @return The Tile on which the Camera is centered
	 */
	ICoordinate getTileLocation();
	
	/**
	 * @param loc - The Tile on which to center the Camera
	 * @throws IllegalArgumentException If the loc is illegal, e.g. if it is null, if it points to a nonexistent Tile, etc.
	 */
	void setTileLocation(ICoordinate loc) throws IllegalArgumentException;
	
	/**
	 * @return The offset of the Camera in pixels from the Tile on which it is centered
	 * <p>
	 * (Intended use is for things like shaking the Camera, smooth transitions across the GameWorld, etc.)
	 */
	ICoordinate getPixelOffset();
	
	/**
	 * @param offset - The pixel offset to set for the Camera which will determine its distance in pixels from the center of its current Tile
	 * @throws IllegalArgumentException If the offset is illegal, i.e. if it is null
	 */
	void setPixelOffset(ICoordinate offset) throws IllegalArgumentException;
	
	/**
	 * This function sets visibilityPoints to return the Coordinates of Tiles which are visible to Characters controlled by the player (as specified by {@link soliloquy.ruleset.gameconcepts.specs.ITileVisibility}).
	 */
	void calculateVisibilityPoints();
	
	/**
	 * These are the Coordinates of the Tiles currently visible to the player. (These may be changed manually, e.g. in cutscenes.)
	 * @return A collection of the Tiles which are currently visible to the Camera
	 */
	ICollection<ICoordinate> visibilityPoints();
}
