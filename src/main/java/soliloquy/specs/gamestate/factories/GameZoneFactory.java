package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.Coordinate2d;
import soliloquy.specs.gamestate.entities.GameZone;
import soliloquy.specs.gamestate.entities.Tile;

/**
 * <b>GameZoneFactory</b>
 * <p>
 * This class creates GameZones
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameZoneFactory extends SoliloquyClass {
    /**
     * <i>NB: This method is intended to be called by
     * {@link soliloquy.specs.gamestate.entities.GameZonesRepo#getGameZone}.</i>
     *
     * @param id             The Id of the newly-created GameZone
     * @param maxCoordinates The maximum x and y value for this GameZone in which a Tile can be
     *                       located
     * @param data           The data for the newly-created GameZone; may be null
     * @return A newly-created GameZone
     * @throws IllegalArgumentException If and only if id, name or type are null or empty, or
     *                                  maxCoordinates is null or has an X or Y value less than or
     *                                  equal to zero
     */
    GameZone make(String id, Coordinate2d maxCoordinates, VariableCache data)
            throws IllegalArgumentException;
}
