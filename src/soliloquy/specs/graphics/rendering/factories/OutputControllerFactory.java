package soliloquy.specs.graphics.rendering.factories;

import soliloquy.specs.common.infrastructure.SettingsRepo;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.rendering.OutputController;

/**
 * <b>OutputControllerFactory</b>
 * <p>
 * This class is used to generate an OutputController
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface OutputControllerFactory extends SoliloquyClass {
    /**
     * @param settingsRepo The SettingsRepo, from which parameters used in OutputController
     *                     creation can be drawn
     * @return The newly-created OutputController
     * @throws IllegalArgumentException If settingsRepo is null, or if it does not contain all
     *                                  required
     *                                  {@link soliloquy.specs.common.infrastructure.Setting}s
     */
    OutputController make(SettingsRepo settingsRepo) throws IllegalArgumentException;
}
