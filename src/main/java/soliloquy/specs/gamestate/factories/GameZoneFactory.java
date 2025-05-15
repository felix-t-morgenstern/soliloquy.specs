package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.valueobjects.Coordinate2d;
import soliloquy.specs.gamestate.entities.GameZone;
import soliloquy.specs.gamestate.entities.GameZoneRepo;

import java.util.Map;

/**
 * <b>GameZoneFactory</b>
 * <p>
 * This class creates GameZones
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameZoneFactory {
    /**
     * <i>NB: This method is intended to be called by
     * {@link GameZoneRepo#currentGameZone()}.</i>
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
    GameZone make(String id, Coordinate2d maxCoordinates, Map<String, Object> data)
            throws IllegalArgumentException;
}
