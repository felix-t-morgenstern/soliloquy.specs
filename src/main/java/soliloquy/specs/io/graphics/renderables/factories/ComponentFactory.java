package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.io.graphics.renderables.Component;
import soliloquy.specs.io.input.keyboard.entities.KeyBindingContext;

import java.util.UUID;

/**
 * <b>ComponentFactory</b>
 * <p>
 * Creates {@link Component}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ComponentFactory {
    Component make(
            UUID uuid,
            int z,
            KeyBindingContext bindingContext
    ) throws IllegalArgumentException;
}
