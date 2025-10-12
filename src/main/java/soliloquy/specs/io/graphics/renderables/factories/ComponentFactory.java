package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.Component;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.io.graphics.rendering.RenderingBoundaries;
import soliloquy.specs.io.input.keyboard.KeyBinding;
import soliloquy.specs.io.input.keyboard.KeyEventListener;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * <b>ComponentFactory</b>
 * <p>
 * Creates {@link Component}s. (This factory is exceedingly straightforward, but it needs to be
 * exposed to other modules.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ComponentFactory {
    /**
     * @param uuid                        The uuid of the Component
     * @param z                           The z-index of the Component
     * @param keyBindings                 The keys bound to the Component, and their respective
     *                                    actions
     * @param blocksLowerKeyBindings      True, if and only if this Component's keyBindings block
     *                                    the keyBindings of Components with lower priority (c.f.
     *                                    {@link KeyEventListener#addComponent}
     * @param renderingBoundariesProvider Provides the rendering boundaries for this Component, to
     *                                    be fed into
     *                                    {@link RenderingBoundaries#currentBoundaries()}
     * @param containingComponent         The Component which contains the newly-created Component,
     *                                    may be null
     * @param data                        Data relating to this component (intended to aid UI)
     * @return The newly-created Component
     * @throws IllegalArgumentException If and only if uuid, keyBindings,
     *                                  renderingBoundariesProvider, or containingComponent are
     *                                  null
     */
    Component make(
            UUID uuid,
            int z,
            Set<KeyBinding> keyBindings,
            boolean blocksLowerKeyBindings,
            ProviderAtTime<FloatBox> renderingBoundariesProvider,
            Component containingComponent,
            Map<String, Object> data
    ) throws IllegalArgumentException;
}
