package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.GenericParamsSet;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.ReadableCoordinate;
import soliloquy.specs.gamestate.entities.GameZone;
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
     * (NB: The intended use is for GameZone to invoke this class in its constructor; therefore,
     * the constructor of Tile does not check whether gameZone contains the created Tile at the
     * specified location.)
     * @param gameZone - The GameZone to which to assign the created Tile
     * @param location - The coordinate to which to assign the created Tile
     * @param data - The data for the newly-created Tile
     * @return The created Tile
     * @throws IllegalArgumentException If and only if gameZone is null or deleted or location is
     * null
     */
    Tile make(GameZone gameZone, ReadableCoordinate location, GenericParamsSet data)
            throws IllegalArgumentException;
}
