package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.valueobjects.Coordinate;
import soliloquy.specs.ruleset.entities.GroundType;
import soliloquy.specs.graphics.assets.Sprite;

import java.util.Map;

/**
 * <b>Tile</b>
 * <p>
 * A Tile, which may exist at a location and a height in a GameZone.
 * <p>
 * May have a GroundType, TileFixtures, TileWallSegments, Characters, Items, ActiveAbilities,
 * ReactiveAbilities, and Sprites
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Tile extends GameEventTargetEntity, Deletable, HasData {
	/**
	 * @return The GameZone in which this Tile exists
	 * @throws IllegalStateException If the GameZone does not contain this Tile at the location
	 * specified by {@link #location}
	 */
	GameZone gameZone() throws IllegalStateException;
	
	/**
	 * @return The Coordinate at which this Tile is located
	 * @throws IllegalStateException If the GameZone does not contain this Tile at the location
	 */
	Coordinate location() throws IllegalStateException;
	
	/**
	 * @return The height of this Tile in the GameWorld
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	int getHeight() throws IllegalStateException;
	
	/**
	 * @param height - The height in the GameWorld to set for this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	void setHeight(int height) throws IllegalStateException;
	
	/**
	 * @return The GroundType of this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	GroundType getGroundType() throws IllegalStateException;
	
	/**
	 * @param groundType The GroundType to set for this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	void setGroundType(GroundType groundType) throws IllegalStateException;

	/**
	 * @return An interface for obtaining and editing the Characters on this Tile
	 */
	TileEntities<Character> characters();

	/**
	 * @return An interface for obtaining and editing the Items on this Tile
	 */
	TileEntities<Item> items();
	
	/**
	 * @return A numbered Map of TileFixtures, where the numerical index of the Map corresponds to
	 * the Z order of TileFixtures on this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	TileEntities<TileFixture> fixtures() throws IllegalStateException;

	/**
	 * This is a numbered Map of numbered Maps of TileWallSegments.
	 * <p>
	 * The first (outer) index refers to the height.
	 * <p>
	 * The second (inner) index is the z-index, i.e. the determinant of which wall segments go
	 * "atop" one another. (For instance, you may have a cliff face; and that cliff face may have
	 * rock outcrops on it, which are also TileWallSegments.)
	 * @return A collection of the TileWallSegments on this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	TileWallSegments wallSegments() throws IllegalStateException;
	
	/**
	 * @return A numbered Map of Sprites on this Tile, where the numerical value of the Map
	 * corresponds to the Z order of that Sprite on this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	Map<Sprite, Integer> sprites() throws IllegalStateException;

	/**
	 * <b>NB: This method is intended to <b><u>only</u></b> be used by the constructor of
	 * {@link GameZone}; it is intended to check whether the GameZone assigned to this entity has
	 * this entity on it, prior to assignment.</b>
	 * @param gameZone - The Tile to which to assign to this entity (may be null)
	 * @throws IllegalArgumentException If and only if gameZone is null, or gameZone does not
	 * contain this entity
	 * @throws IllegalStateException If this entity has been deleted
	 */
	void assignGameZoneAfterAddedToGameZone(GameZone gameZone)
			throws IllegalArgumentException, IllegalStateException;
}
