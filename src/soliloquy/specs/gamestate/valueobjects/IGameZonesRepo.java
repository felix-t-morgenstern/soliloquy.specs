package soliloquy.specs.gamestate.valueobjects;

import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.gamestate.entities.IGameZone;

/**
 * <b>GameZones</b>
 * <p>
 * Retrieves GameZones, either from disk or main memory
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IGameZonesRepo extends ISoliloquyClass {
	/**
	 * Intended use is reading a GameZone from disk or main memory
	 * @param gameZoneId - The Id of the GameZone to retrieve
	 * @return The GameZone with that Id
	 * @throws IllegalArgumentException If gameZoneId does not match any GameZone's Id
	 */
	IGameZone getGameZone(String gameZoneId) throws IllegalArgumentException;
}
