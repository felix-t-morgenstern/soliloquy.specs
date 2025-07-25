package soliloquy.specs.io.graphics.rendering.renderers;

import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.Component;

/**
 * <b>ComponentRenderer</b>
 * <p>
 * This class renders the contents of the {@link Component}.
 * <p>
 * (NB: This class is separate from the FrameTimer, since this class is responsible for what
 * happens when a frame must be rendered, rather than determining when a frame should be rendered.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ComponentRenderer {
    /**
     * Renders the contents of a {@link Component}.
     *
     * @param stack     The Component to render
     * @param timestamp The timestamp at which to render the top-level {@link Component}. (The
     *                  timestamp provided is primarily used by {@link ProviderAtTime}s.)
     * @throws IllegalArgumentException If and only if stack is null, or timestamp is less than the
     *                                  previously rendered timestamp
     */
    void render(Component stack, long timestamp) throws IllegalArgumentException;
}
