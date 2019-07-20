package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.infrastructure.Collection;
import soliloquy.specs.common.infrastructure.ReadableMap;
import soliloquy.specs.common.valueobjects.Coordinate;
import soliloquy.specs.common.valueobjects.EntityUuid;
import soliloquy.specs.common.shared.HasGlobalAccess;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;

/**
 * <b>GameZone</b>
 * <p>
 * A GameZone is a set of Tiles in two-dimensional space where gameplay takes place. (Like a
 * castle, or a dungeon, or a forest.)
 * <p>
 * A GameZone has a type, a size, Tiles, Characters, Items, and Actions which are executed when
 * entering and leaving the GameZone.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface GameZone extends HasName, HasId, HasGlobalAccess {
	/**
	 * @return The type of the GameZone (e.g. expansive, local)
	 */
	String zoneType();
	
	/**
	 * @return The maximum x and y values of Coordinates in the GameZone
	 */
	Coordinate getMaxCoordinates();
	
	/**
	 * If you shrink the dimensions of the GameZone, Tiles with a greater x or y coordinate than
	 * the new dimensions will be lost. Conversely, if you enlarge the dimensions, blank Tiles will be created.
	 * @param dimensions - The new dimensions of the GameZone.
	 * @throws IllegalArgumentException dimensions is null, or either of the coordinates are 0 or
	 * less
	 */
	void setDimensions(Coordinate dimensions) throws IllegalArgumentException;
	
	/**
	 * @param coordinates - The coordinates of the Tile to return
	 * @return The Tile at those coordinates
	 * @throws IllegalArgumentException If coordinates is null, or coordinates is beyond the
	 * dimensions of the GameZone
	 */
	Tile tile(Coordinate coordinates) throws IllegalArgumentException;
	
	/**
	 * <i>NB: This is a representation of the Characters in this GameZone. Intended use is that any
	 * Tile will have access to the underlying data structure of this GameZone, and will maintain
	 * the invariant that all Characters in a GameZone are known by that GameZone, and all
	 * Characters know their GameZone.</i>
	 * @return A Set of the Characters in this GameZone
	 */
	ReadableMap<EntityUuid, Character> charactersRepresentation();

	/**
	 * <b>NB: This method is <u>only</u> to be used by {@link TileCharacters#addCharacter}; an
	 * invariant should be set for this method where character must be on a Tile belonging to this
	 * GameZone <u>before</u> this method is called.</b>
	 * @param character - The Character to assign to this GameZone
	 */
	void assignCharacterToGameZone(Character character);
	
	/**
	 * <i>NB: This is a representation of the Items in this GameZone. Intended use is that any Tile
	 * will have access to the underlying data structure of this GameZone, and will maintain the
	 * invariant that all Items in a GameZone are known by that GameZone, and all Items know their
	 * GameZone.</i>
	 * @return A Set of the Items in this GameZone
	 */
	ReadableMap<EntityUuid, Item> itemsRepresentation();

	/**
	 * @param item - The Item whose presence to verify
	 * @return True, if and only if item is present in this GameZone
	 */
	boolean containsItem(Item item);

	/**
	 * @return A Collection of Actions which are fired when the Party enters this GameZone.
	 * <p>
	 * (It is expected that this will be called when GameState.setCurrentGameZone is called.)
	 */
	Collection<Action<Void>> onEntry();
	
	/**
	 * @return A Collection of Actions which are fired when the Party leaves this GameZone.
	 * <p>
	 * (It is expected that this will be called when GameState.setCurrentGameZone is called.)
	 * <p>
	 * (Also, this is where Timers which are intended only for this GameZone can be eliminated.)
	 */
	Collection<Action<Void>> onExit();
}
