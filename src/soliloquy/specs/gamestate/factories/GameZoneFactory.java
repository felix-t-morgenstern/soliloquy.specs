package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.GenericParamsSet;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.ReadableCoordinate;
import soliloquy.specs.gamestate.entities.GameZone;

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
     * @param id - The Id of the newly-created GameZone
     * @param name - The name of the newly-created GameZone
     * @param zoneType - The type of the newly-created GameZone (e.g. Town, Outdoors, Dungeon,
     *                 Cutscene, etc.); may be null or empty
     * @param maxCoordinates - The maximum coordinates in the newly-created GameZone
     * @param data - The data for the newly-created GameZone; may be null
     * @return A newly-created GameZone
     * @throws IllegalArgumentException If and only if id, name or type are null or empty, or
     * maxCoordinates is null or invalid
     */
    GameZone make(String id, String name, String zoneType, ReadableCoordinate maxCoordinates,
                  GenericParamsSet data)
            throws IllegalArgumentException;
}
