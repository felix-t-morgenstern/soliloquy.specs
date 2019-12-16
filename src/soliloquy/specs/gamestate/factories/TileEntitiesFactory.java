package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.TileEntities;
import soliloquy.specs.gamestate.entities.TileEntity;

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
     * @param tile - The {@link Tile} for which this TileEntities is to be made
     * @param archetype - The archetype for the newly created TileEntities
     * @return A {@link TileEntities} for tile
     * @throws IllegalArgumentException If and only if tile or archetype are null
     */
    <TEntity extends TileEntity> TileEntities<TEntity> make(Tile tile, TEntity archetype)
            throws IllegalArgumentException;
}
