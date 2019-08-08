package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Collection;
import soliloquy.specs.common.valueobjects.Coordinate;
import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.ruleset.entities.GroundType;
import soliloquy.specs.sprites.entities.Sprite;

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
public interface Tile extends HasEvents, GameEntity {
	/**
	 * @return The GameZone in which this Tile exists
	 * @throws IllegalStateException If the GameZone does not contain this Tile at the location
	 * specified by getLocation
	 */
	GameZone gameZone() throws IllegalStateException;
	
	/**
	 * @return The Coordinate at which this Tile is located
	 * @throws IllegalStateException If the location is defined, but the gameZone is not; or if the
	 * gameZone does not have this Tile listed at the value returned by this method; or if this
	 * Tile has been deleted
	 */
	Coordinate getLocation() throws IllegalStateException;
	
	/**
	 * (This is intended to be called by the GameZone after it moves this Tile from one Coordinate
	 * in its Map to another)
	 * @param location - The location to set for this Tile
	 * @throws IllegalArgumentException If location is not equal to the Coordinate key of this Tile
	 * in the Tiles Map of its GameZone
	 * @throws IllegalStateException If this Tile does not have a GameZone, or if this Tile has
	 * been deleted
	 */
	void setLocation(Coordinate location) throws IllegalArgumentException, IllegalStateException;
	
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
	TileCharacters characters();

	/**
	 * @return An interface for obtaining and editing the Items on this Tile
	 */
	TileItems items();
	
	/**
	 * @return A numbered Map of TileFixtures, where the numerical index of the Map corresponds to
	 * the Z order of TileFixtures on this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	TileFixtures fixtures() throws IllegalStateException;

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
	TileWallSegments tileWallSegments() throws IllegalStateException;
	
	/**
	 * @return A numbered Map of Sprites on this Tile, where the numerical index of the Map
	 * corresponds to the Z order of Sprites on this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	Map<Integer, Collection<Sprite>> sprites() throws IllegalStateException;
}
