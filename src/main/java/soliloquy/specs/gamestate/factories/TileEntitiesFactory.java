package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.TileEntities;
import soliloquy.specs.gamestate.entities.TileEntity;

import java.util.function.Consumer;

/**
 * <b>TileEntitiesFactory</b>
 * <p>
 * This class creates a {@link TileEntities} for a given {@link Tile}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileEntitiesFactory extends SoliloquyClass {
    /**
     * @param tile       The {@link Tile} for which this TileEntities is to be made
     * @param archetype  The archetype for the newly created TileEntities
     * @param addHook    After an entity has been added, this function is called with the entity as
     *                   input. Can be null.
     * @param removeHook After an entity has been removed, this function is called with the entity
     *                   as input. Can be null.
     * @return A {@link TileEntities} for tile
     * @throws IllegalArgumentException If and only if tile or archetype are null
     */
    <TEntity extends TileEntity> TileEntities<TEntity> make(Tile tile, TEntity archetype,
                                                            Consumer<TEntity> addHook,
                                                            Consumer<TEntity> removeHook)
            throws IllegalArgumentException;
}
