package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Tile;

/**
 * <b>TileFactory</b>
 * <p>
 * This class creates Tiles
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileFactory extends SoliloquyClass {
    /**
     * (NB: Tiles can belong to either one or zero
     * {@link soliloquy.specs.gamestate.entities.GameZone}s; therefore, the constructor of Tile does
     * not check whether a GameZone contains the created Tile at the specified location.)
     *
     * @param data The data for the newly-created Tile
     * @return The created Tile
     * @throws IllegalArgumentException If and only if data is null
     */
    Tile make(VariableCache data) throws IllegalArgumentException;
}
