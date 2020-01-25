package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;
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
     * @param id - The Id of the newly-created GameZone
     * @param zoneType - The type of the newly-created GameZone (e.g. Town, Outdoors, Dungeon,
     *                 Cutscene, etc.); may be null or empty
     * @param tiles - The Tiles in the newly-created GameZone
     * @param data - The data for the newly-created GameZone; may be null
     * @return A newly-created GameZone
     * @throws IllegalArgumentException If and only if id, name or type are null or empty, or
     * maxCoordinates is null or invalid
     */
    GameZone make(String id, String zoneType, Tile[][] tiles, VariableCache data)
            throws IllegalArgumentException;
}
