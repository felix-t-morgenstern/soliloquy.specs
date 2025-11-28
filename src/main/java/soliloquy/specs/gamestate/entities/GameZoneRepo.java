package soliloquy.specs.gamestate.entities;

/**
 * <b>GameZoneRepo</b>
 * <p>
 * Retrieves GameZones, either from disk or main memory
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameZoneRepo {
    /**
     * @return The current GameZone; null, if none has been loaded
     */
    GameZone currentGameZone();

    /**
     * Intended use is reading a GameZone from disk or main memory. If a GameZone has already been
     * loaded, it must be unloaded before loading a new one.
     *
     * @param gameZoneId The Id of the GameZone to load
     * @throws IllegalArgumentException      If gameZoneId does not match any GameZone's Id
     * @throws UnsupportedOperationException If and only if a GameZone is already currently loaded
     */
    void loadGameZone(String gameZoneId)
            throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * If a GameZone has been loaded, it is dropped from memory. (Be sure to save it first if you
     * want to preserve any changes to it!)
     */
    void unloadGameZone();

    /**
     * @param gameZone The GameZone to save
     * @throws IllegalArgumentException If and only if gameZone is null, or if the Id of gameZone
     *                                  is not recognized
     */
    void saveGameZone(GameZone gameZone) throws IllegalArgumentException;
}
