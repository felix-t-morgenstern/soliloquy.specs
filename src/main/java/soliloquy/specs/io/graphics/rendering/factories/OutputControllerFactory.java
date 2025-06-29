package soliloquy.specs.io.graphics.rendering.factories;

import soliloquy.specs.gamestate.entities.Setting;
import soliloquy.specs.io.graphics.rendering.OutputController;

import java.util.function.Function;

/**
 * <b>OutputControllerFactory</b>
 * <p>
 * This class is used to generate an OutputController
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface OutputControllerFactory {
    /**
     * @param settingsRepo The SettingsRepo, from which parameters used in OutputController
     *                     creation can be drawn
     * @return The newly-created OutputController
     * @throws IllegalArgumentException If settingsRepo is null, or if it does not contain all
     *                                  required {@link Setting}s
     */
    OutputController make(Function<String, Setting> settingsRepo) throws IllegalArgumentException;
}
