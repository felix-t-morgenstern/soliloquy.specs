package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.entities.Consumer;
import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.Component;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.io.graphics.rendering.RenderingBoundaries;
import soliloquy.specs.io.input.keyboard.KeyBinding;
import soliloquy.specs.io.input.keyboard.KeyEventHandler;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * <b>ComponentFactory</b>
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
     *                                    {@link KeyEventHandler#addComponent})
     * @param dimensionsProvider          Provides the dimensions of this Component for UI purposes
     *                                    (c.f. {@link Component#getDimensionsProvider()})
     * @param renderingBoundariesProvider Provides the rendering boundaries for this Component, to
     *                                    be fed into
     *                                    {@link RenderingBoundaries#currentBoundaries()}
     * @param prerenderHookId             The Id of the {@link Consumer} to execute prior to
     *                                    rendering the Component
     * @param addHookId                   The Id of the {@link Consumer} to execute for the
     *                                    Component prior to rendering, c.f.
     *                                    {@link Component#addHookId()}
     * @param containingComponent         The Component which contains the newly-created Component,
     *                                    may be null. <i>NB: If addHookId is defined, the
     *                                    corresponding {@link Consumer} will be called on the
     *                                    content before they are added to the newly-created
     *                                    Component.</i>
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
            int keyBindingPriority,
            ProviderAtTime<FloatBox> dimensionsProvider,
            ProviderAtTime<FloatBox> renderingBoundariesProvider,
            String prerenderHookId,
            String addHookId,
            Component containingComponent,
            Map<String, Object> data
    ) throws IllegalArgumentException;
}
