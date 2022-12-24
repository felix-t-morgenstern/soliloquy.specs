package soliloquy.specs.graphics.rendering.renderers;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.rendering.RenderableStack;

/**
 * <b>StackRenderer</b>
 * <p>
 * This class renders the contents of the {@link RenderableStack}.
 * <p>
 * (NB: This class is separate from the FrameTimer, since this class is responsible for what
 * happens when a frame must be rendered, rather than determining when a frame should be rendered.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface StackRenderer extends SoliloquyClass {
    /**
     * <i>NB: Higher z values will be rendered first.</i>
     * Renders the contents of the top-level {@link RenderableStack}.
     *
     * @param stack     The RenderableStack to render
     * @param timestamp The timestamp at which to render the top-level {@link RenderableStack}.
     *                  (The timestamp provided is primarily used by
     *                  {@link ProviderAtTime}s.)
     * @throws IllegalArgumentException If and only if stack is null, or timestamp is less than the
     *                                  previously rendered timestamp
     */
    void render(RenderableStack stack, long timestamp) throws IllegalArgumentException;
}
