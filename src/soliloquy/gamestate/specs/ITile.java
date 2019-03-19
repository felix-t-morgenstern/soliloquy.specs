package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ICoordinate;
import soliloquy.common.specs.IMap;
import soliloquy.ruleset.gameentities.abilities.specs.IActiveAbility;
import soliloquy.ruleset.gameentities.abilities.specs.IReactiveAbility;
import soliloquy.ruleset.gameentities.specs.IGameEntity;
import soliloquy.ruleset.gameentities.specs.IGroundType;
import soliloquy.sprites.specs.ISprite;

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
public interface ITile extends IGameEntity {
	/**
	 * @return The GameZone in which this Tile exists
	 * @throws IllegalStateException If the GameZone does not contain this Tile at the location
	 * specified by getLocation
	 */
	IGameZone getGameZone() throws IllegalStateException;
	
	/**
	 * @param gameZone - The GameZone in which this Tile will exist
	 * @param location - The Coordinate at which this Tile will exist
	 * @throws IllegalArgumentException If either gameZone or location are null, or if gameZone
	 * does not have this Tile at the provided location
	 * <p>
	 * <i>(If you want to enforce minimum or maximum values for height, you should enforce that
	 * invariant here, and throw this exception.)
	 * @throws UnsupportedOperationException If this Tile's GameZone has already been initialized
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	void initializeInGameZone(IGameZone gameZone, ICoordinate location, int height) throws IllegalArgumentException, UnsupportedOperationException, IllegalStateException;
	
	/**
	 * @return The Coordinate at which this Tile is located
	 * @throws IllegalStateException If the location is defined, but the gameZone is not; or if the
	 * gameZone does not have this Tile listed at the value returned by this method; or if this
	 * Tile has been deleted
	 */
	ICoordinate getLocation() throws IllegalStateException;
	
	/**
	 * (This is intended to be called by the GameZone after it moves this Tile from one Coordinate
	 * in its Map to another)
	 * @param location - The location to set for this Tile
	 * @throws IllegalArgumentException If location is not equal to the Coordinate key of this Tile
	 * in the Tiles Map of its GameZone
	 * @throws IllegalStateException If this Tile does not have a GameZone, or if this Tile has
	 * been deleted
	 */
	void setLocation(ICoordinate location) throws IllegalArgumentException, IllegalStateException;
	
	// NB: It may be worthwhile to enforce an invariant whereby
	//     any entity returned by this method is on this Tile.
	//     The index on the indexed set refers to the order of
	//     those entities on that Tile.
	/**
	 * @return A numbered Map of Characters, where the numerical index of the Map corresponds to
	 * the Z order of Characters on this Tile
	 * @throws IllegalStateException If any of the Characters returned by this method do not have
	 * this Tile listed as their location, or if this Tile has been deleted
	 * <p>
	 * <i>Also, if you want to forbid multiple Characters on a Tile, that condition should also
	 * throw this exception.</i>
	 */
	IMap<Integer,ICharacter> characters() throws IllegalStateException;
	
	/**
	 * @return A numbered Map of Items, where the numerical index of the Map corresponds to the Z
	 * order of Items on this Tile
	 * @throws IllegalStateException If any of the Items returned by this method do not have this
	 * Tile listed as their location, or if this Tile has been deleted
	 * <p>
	 * <i>N.B.: Be sure to check Item.getTile, not Item.getTileFixture</i>
	 */
	IMap<Integer,IItem> items() throws IllegalStateException;
	
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
	IGroundType getGroundType() throws IllegalStateException;
	
	/**
	 * @param groundType The GroundType to set for this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	void setGroundType(IGroundType groundType) throws IllegalStateException;
	
	/**
	 * @return A numbered Map of TileFixtures, where the numerical index of the Map corresponds to
	 * the Z order of TileFixtures on this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	IMap<Integer,ITileFixture> fixtures() throws IllegalStateException;

	/**
	 * This is a numbered Map of numbered Maps of TileWallSegments.
	 * <p>
	 * The first (outer) index refers to the height.
	 * <p>
	 * The second (inner) index is the z-index, i.e. the determinant of which wall segments go
	 * "atop" one another. (For instance, you may have a cliff face; and that cliff face may have
	 * rock outcrops on it, which are also TileWallSegments.)
	 * @return A collection of the east-to-west TileWallSegments on the north side of this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	IMap<Integer,IMap<Integer,ITileWallSegment>> nTileWallSegments() throws IllegalStateException;

	/**
	 * This is a numbered Map of numbered Maps of TileWallSegments.
	 * <p>
	 * The first (outer) index refers to the height.
	 * <p>
	 * The second (inner) index is the z-index, i.e. the determinant of which wall segments go
	 * "atop" one another. (For instance, you may have a cliff face; and that cliff face may have
	 * rock outcrops on it, which are also TileWallSegments.)
	 * @return A collection of the east-to-west TileWallSegments on the north side of this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	IMap<Integer,IMap<Integer,ITileWallSegment>> nwTileWallSegments() throws IllegalStateException;

	/**
	 * This is a numbered Map of numbered Maps of TileWallSegments.
	 * <p>
	 * The first (outer) index refers to the height.
	 * <p>
	 * The second (inner) index is the z-index, i.e. the determinant of which wall segments go
	 * "atop" one another. (For instance, you may have a cliff face; and that cliff face may have
	 * rock outcrops on it, which are also TileWallSegments.)
	 * @return A collection of the east-to-west TileWallSegments on the north side of this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	IMap<Integer,IMap<Integer,ITileWallSegment>> wTileWallSegments() throws IllegalStateException;
	
	/**
	 * @return A numbered Map of Sprites on this Tile, where the numerical index of the Map
	 * corresponds to the Z order of Sprites on this Tile
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	IMap<Integer,ICollection<ISprite>> sprites() throws IllegalStateException;
	
	/**
	 * @return A named Map of this Tile's ActiveAbilities; e.g. Heal Nearby Allies, Generate Golem;
	 * the Ids are the AbilityTypeIds
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	IMap<String,IActiveAbility> activeAbilities() throws IllegalStateException;
	
	/**
	 * @return A named Map of this Tile's ReactiveAbilities; e.g. Explode, Talk, Trigger Event when
	 * Investigated; the Ids are the AbilityTypeIds
	 * @throws IllegalStateException If this Tile has been deleted
	 */
	IMap<String,IReactiveAbility> reactiveAbilities() throws IllegalStateException;
}
