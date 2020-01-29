package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Camera;
import soliloquy.specs.gamestate.entities.GameZone;

import java.util.function.Supplier;

/**
 * <b>CameraFactory</b>
 * <p>
 * This class creates a new {@link Camera}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CameraFactory extends SoliloquyClass {
    /**
     * @param getGameZone - A function which obtains the current GameZone at any given time
     * @return The newly-created Camera
     * @throws IllegalArgumentException If and only if getGameZone is null
     */
    Camera make(Supplier<GameZone> getGameZone) throws IllegalArgumentException;
}
