package soliloquy.specs.ui;

import soliloquy.specs.io.graphics.renderables.Renderable;
import soliloquy.specs.io.graphics.renderables.RenderableWithDimensions;
import soliloquy.specs.io.keyboard.KeyBindingContext;

import java.util.Set;

public interface Component extends RenderableWithDimensions {
    /**
     * Components alone are expected to be in control of blocking KeyBindings of "lower" components, so it is expected that KeyBindingContexts will not appear in any other context
     *
     * @return The KeyBindingContext for this Component
     */
    KeyBindingContext keyBindingContext();

    /**
     * @return A Set of Renderables which comprise this Component
     */
    Set<Renderable> contents();
}
