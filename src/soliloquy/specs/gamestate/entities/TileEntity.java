package soliloquy.specs.gamestate.entities;

/**
 * <b>TileEntity</b>
 * <p>
 * Specifies common properties for deletable entities that exist on Tiles.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface TileEntity extends GameEntity {
    /**
     * @return The Tile on which this entity sits
     * @throws IllegalStateException If this entity has been deleted
     */
    Tile tile() throws IllegalStateException;

    /**
     * <b>NB: This method is intended to <b><u>only</u></b> be used by
     * {@link TileEntities#add} and {@link TileEntities#remove}; it is intended to
     * check whether the Tile assigned to this entity has this entity on it, prior to
     * assignment or removal.</b>
     * @param tile - The Tile to which to assign to this entity (may be null)
     * @throws IllegalArgumentException If and only if tile is null, or tile does not contain this
     * entity
     * @throws IllegalStateException If this entity has been deleted
     */
    void assignTileAfterAddedToTileEntitiesOfType(Tile tile)
            throws IllegalArgumentException, IllegalStateException;
}
