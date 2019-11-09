package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.exceptions.SoliloquyIOException;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.GameZone;

/**
 * <b>GameZones</b>
 * <p>
 * Retrieves GameZones, either from disk or main memory
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface GameZonesRepo extends SoliloquyClass {
	/**
	 * Intended use is reading a GameZone from disk or main memory.
	 * @param gameZoneId - The Id of the GameZone to retrieve
	 * @return The GameZone with that Id
	 * @throws IllegalArgumentException If gameZoneId does not match any GameZone's Id
	 */
	GameZone getGameZone(String gameZoneId) throws IllegalArgumentException;

	/**
	 * @param gameZone - The GameZone to save
	 * @throws IllegalArgumentException If and only if gameZone is null, or if the Id of gameZone
	 * is not recognized
	 */
	void saveGameZone(GameZone gameZone) throws IllegalArgumentException;
}
