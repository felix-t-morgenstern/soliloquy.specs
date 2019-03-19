package soliloquy.gamestate.specs;

import soliloquy.common.specs.IAction;
import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ICoordinate;
import soliloquy.common.specs.IEntityUuid;
import soliloquy.common.specs.IGlobalAccess;
import soliloquy.common.specs.IHasId;
import soliloquy.common.specs.IHasName;
import soliloquy.common.specs.IMap;

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
public interface IGameZone extends IHasName, IHasId, IGlobalAccess {
	/**
	 * @return The type of the GameZone (e.g. expansive, local)
	 */
	String zoneType();
	
	/**
	 * @return The size of the GameZone
	 */
	ICoordinate getDimensions();
	
	/**
	 * If you shrink the dimensions of the GameZone, Tiles with a greater x or y coordinate than
	 * the new dimensions will be lost. Conversely, if you enlarge the dimensions, blank Tiles will be created.
	 * @param dimensions - The new dimensions of the GameZone.
	 * @throws IllegalArgumentException dimensions is null, or either of the coordinates are 0 or
	 * less
	 */
	void setDimensions(ICoordinate dimensions) throws IllegalArgumentException;
	
	/**
	 * @param coordinates - The coordinates of the Tile to return
	 * @return The Tile at those coordinates
	 * @throws IllegalArgumentException If coordinates is null, or coordinates is beyond the
	 * dimensions of the GameZone
	 */
	ITile tile(ICoordinate coordinates) throws IllegalArgumentException;
	
	/**
	 * @return A Set of the Characters in this GameZone
	 */
	IMap<IEntityUuid,ICharacter> characters();
	
	/**
	 * @return A Set of the Items in this GameZone
	 */
	IMap<IEntityUuid,IItem> items();

	/**
	 * @return A Collection of Actions which are fired when the Party enters this GameZone.
	 * <p>
	 * (It is expected that this will be called when GameState.setCurrentGameZone is called.)
	 */
	ICollection<IAction<Void>> onEntry();
	
	/**
	 * @return A Collection of Actions which are fired when the Party leaves this GameZone.
	 * <p>
	 * (It is expected that this will be called when GameState.setCurrentGameZone is called.)
	 * <p>
	 * (Also, this is where Timers which are intended only for this GameZone can be eliminated.)
	 */
	ICollection<IAction<Void>> onExit();
}
