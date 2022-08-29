package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.common.valueobjects.Pair;
import soliloquy.specs.common.shared.HasOneGenericParam;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;

import java.util.function.Consumer;

/**
 * <b>TileFixtures</b>
 * <p>
 * This class handles a type of entity on a Tile. It exists to handle invariants which must be
 * enforced, since a Tile should know its entities, and those entities should know their Tile. To
 * be more specific, every TileEntity on a Tile should know that it belongs to that Tile, and
 * vice-versa.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileEntities<TEntity extends TileEntity>
        extends Iterable<Pair<TEntity, Integer>>, HasOneGenericParam<TEntity>, Deletable {
    /**
     * (NB: This method simply calls {@link #add(TEntity, int)} with a zIndex of 0)
     *
     * @param entity The entity to add onto this Tile
     * @throws IllegalArgumentException If and only if entity is null
     * @throws EntityDeletedException   If and only if the containing Tile is deleted
     */
    void add(TEntity entity) throws IllegalArgumentException, EntityDeletedException;

    /**
     * (NB: If multiple Items have the same z-index, this will not cause an error; the z-index only
     * controls display order on the UI. However, if multiple Items have the same z-index, then
     * display order will be indeterminate.)
     *
     * @param entity The entity to add onto this Tile
     * @param zIndex The z-index for this entity. (NB: This only determines display order. If
     *               multiple entities are on the same Tile, that is not considered an error.)
     * @throws IllegalArgumentException If and only if entity is null
     * @throws EntityDeletedException   If and only if the containing Tile is deleted
     */
    void add(TEntity entity, int zIndex) throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param entity The entity whose z-index to return
     * @return The z-index for the provided entity; null, if entity is not present
     * @throws IllegalArgumentException If and only if entity is null
     * @throws EntityDeletedException   If and only if the containing Tile is deleted
     */
    Integer getZIndex(TEntity entity) throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param entity The entity whose z-index to set
     * @param zIndex The z-index to set for entity
     * @throws IllegalArgumentException If and only if entity is null, or entity is not present
     * @throws EntityDeletedException   If and only if the containing Tile is deleted
     */
    void setZIndex(TEntity entity, int zIndex)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param entity The entity to remove
     * @return True, if and only if the Item was present, and therefore removed
     * @throws IllegalArgumentException If and only if entity is null
     * @throws EntityDeletedException   If and only if the containing Tile is deleted
     */
    boolean remove(TEntity entity) throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param entity The entity whose presence to verify
     * @return True, if and only if entity is present on this Tile
     * @throws IllegalArgumentException If and only if entity is null
     * @throws EntityDeletedException   If and only if the containing Tile is deleted
     */
    boolean contains(TEntity entity) throws IllegalArgumentException, EntityDeletedException;

    int size();

    /**
     * <i>NB: This is only supposed to be a REPRESENTATION of the entities present on this Tile. To
     * add or remove Items, use the other methods specified.</i>
     *
     * @return A numbered Map of entities, where the keys of this Map are entities present on
     *         this Tile, and the numerical values of the Map corresponds to the Z order of entities
     *         on
     *         this Tile
     * @throws EntityDeletedException If and only if the containing Tile is deleted
     */
    Map<TEntity, Integer> representation() throws EntityDeletedException;

    // NB: The following methods are exposed on the interface, so that GameZone may be tested,
    //     without also testing the implementation of TileEntities

    /**
     * <i>NB: When adding a Character, intended use is to have that Character be placed at the
     * <b>end</b> of the queue in the RoundManager; their position can be altered manually
     * afterwards.</i>
     * <p>
     * <b>This action is to only be assigned once.</b> Generally speaking, initializing objects
     * (rather than feeding dependencies at construction) is a code smell; however, in this case,
     * exposing an initialization method is required to allow the GameZone to inject itself into
     * this class, while keeping GameZone implementations decoupled from implementations of this
     * class.
     *
     * @param actionAfterAdding A function, which is called whenever an entity of type TEntity is
     *                          added to this class; that function can take certain actions, e.g
     *                          adding a Character to both the GameZone and the RoundManager.
     *                          <p>
     *                          (This parameter may be null.)
     * @throws UnsupportedOperationException If and only if actionAfterRemoving has already been
     *                                       initialized
     */
    void initializeActionAfterAdding(Consumer<TEntity> actionAfterAdding)
            throws UnsupportedOperationException;

    /**
     * <b>This action is to only be assigned once.</b> Generally speaking, initializing objects
     * (rather than feeding dependencies at construction) is a code smell; however, in this case,
     * exposing an initialization method is required to allow the GameZone to inject itself into
     * this class, while keeping GameZone implementations decoupled from implementations of this
     * class.
     *
     * @param actionAfterRemoving A function, which is called whenever an entity of type TEntity
     *                            is removed from this class; that function can take certain
     *                            actions, e.g removing a Character to both the GameZone and the
     *                            RoundManager.
     *                            <p>
     *                            (This parameter may be null.)
     * @throws UnsupportedOperationException If and only if actionAfterRemoving has already been
     *                                       initialized
     */
    void initializeActionAfterRemoving(Consumer<TEntity> actionAfterRemoving)
            throws UnsupportedOperationException;
}
