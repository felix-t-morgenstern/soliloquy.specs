package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ICoordinate;
import soliloquy.common.specs.IGlobalAccess;
import soliloquy.common.specs.IMap;

/**
 * <b>Camera</b>
 * <p>
 * Camera is used to describe what the player sees, i.e. the center of their view in the GameWorld,
 * and which Tiles are rendered.
 * <p>
 * The Camera is fed into the {@link soliloquy.ui.windowelements.specs.IGameWorldView}, which takes snapshots from the Camera, which are then
 * rendered by WindowRenderer.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICamera extends IGlobalAccess {
	/**
	 * NB: This ICoordinate is a representation of the TileLocation; changing its values will not
	 * change the Camera's TileLocation
	 * @return The Tile on which the Camera is centered
	 */
	ICoordinate getTileLocation();
	
	/**
	 * @param x - The x location of Tile on which to center the Camera
	 * @param y - The y location of Tile on which to center the Camera
	 * @throws IllegalArgumentException If and only if x or y are negative
	 */
	void setTileLocation(int x, int y) throws IllegalArgumentException;
	
	/**
	 * NB: This ICoordinate is a representation of the PixelOffset; changing its values will not
	 * change the Camera's PixelOffset
	 * @return The offset of the Camera in pixels from the Tile on which it is centered
	 * <p>
	 * (Intended use is for things like shaking the Camera, smooth transitions across the
	 * GameWorld, etc.)
	 */
	ICoordinate getPixelOffset();
	
	/**
	 * @param offset - The pixel offset to set for the Camera which will determine its distance in
	 * pixels from the center of its current Tile
	 * @throws IllegalArgumentException If and only if x or y are negative
	 */
	void setPixelOffset(int xOffset, int yOffset) throws IllegalArgumentException;
	
	/**
	 * This method does not return how many Tiles away a given Character can see; instead, it 
	 * returns how many Tiles away from the center of the Camera can be rendered by the Camera
	 * itself. For example, the Party might be highly spread out, giving Visibility over many 
	 * Tiles, but if the Camera is set to have a TileRenderingRadius of 7, the Camera will only 
	 * check tiles within 7 of its TileLocation to see whether they are visible. (This also limits
	 * how many Tiles will be displayed when AllTilesVisible is set to true.)
	 * <p>
	 * <i>NB: The radius includes the TileLocation. So, a TileRenderingRadius of 0 implies that no 
	 * Tiles will be rendered; a TileRenderingRadius of 1 implies that only the TileLocation will 
	 * be rendered; a TileRenderingRadius of 2 implies that the TileLocation and all immediately 
	 * surrounding Tiles will be rendered, and so on.</i>
	 * @return The radius around the TileLocation for which Tiles will be rendered (if they are 
	 * visible)
	 */
	int getTileRenderingRadius();
	
	/**
	 * For more detailed explanation regarding the meaning of "TileRenderingRadius", see 
	 * {@link #getTileRenderingRadius}.
	 * @param tileRenderingRadius - The radius around the TileLocation for which Tiles will be 
	 * rendered (if they are visible)
	 * @throws IllegalArgumentException If and only if tileRenderingRadius is negative
	 */
	void setTileRenderingRadius(int tileRenderingRadius) throws IllegalArgumentException;
	
	/**
	 * @return Whether all Tiles are visible to this Camera
	 */
	boolean getAllTilesVisible();
	
	/**
	 * @param allTilesVisible - Sets whether the Camera should treat all Tiles as visible
	 */
	void setAllTilesVisible(boolean allTilesVisible);
	
	/**
	 * Intended use for this method is to return Characters through whom the player sees the game
	 * world; generally the Party, and perhaps also some allies in certain instances.
	 * @return A collection of Characters who provide visibility to the player
	 */
	ICollection<ICharacter> charactersProvidingVisibility();
	
	/**
	 * The intended use of this Map is to have each key specify a Coordinate for which there is 
	 * visibility, and each Integer specify the radius around that Coordinate to which that 
	 * visibility extends. The visibility radius for these Coordinates would include the Coordinate
	 * itself, similarly to how the radius value behaves in {@link #getTileRenderingRadius}.
	 * @return A collection of Coordinates which provide visibility to the player.
	 */
	IMap<ICoordinate,Integer> coordinatesProvidingVisibility();
	
	/**
	 * This function sets visibilityPoints to return the Coordinates of Tiles which are visible to
	 * Characters controlled by the player (as specified by
	 * {@link soliloquy.ruleset.gameconcepts.specs.ITileVisibility}).
	 */
	void calculateVisibileTiles();
	
	/**
	 * These are the Coordinates of the Tiles currently visible to the player. (These may be
	 * changed manually, e.g. in cutscenes.)
	 * @return A collection of the Tiles which are currently visible to the player
	 */
	ICollection<ICoordinate> visibileTiles();
}
