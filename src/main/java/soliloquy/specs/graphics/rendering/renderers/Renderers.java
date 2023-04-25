package soliloquy.specs.graphics.rendering.renderers;

import soliloquy.specs.graphics.renderables.Renderable;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.shared.HasMostRecentTimestamp;

/**
 * <b>Renderer</b>
 * <p>
 * This class registers Renderers for given Renderables, and handles requests to render Renderables
 * of unspecified types, using its registered Renderables to determine which is appropriate for the
 * provided Renderable
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Renderers extends HasMostRecentTimestamp {
    /**
     * @param renderableInterfaceName The name of the interface of the Renderable
     * @param renderer                The Renderer for that class
     * @param <T>                     The type of the Renderable
     * @throws IllegalArgumentException If and only if renderableInterfaceName is null or empty, or
     *                                  renderer is null
     */
    <T extends Renderable> void registerRenderer(String renderableInterfaceName,
                                                 Renderer<T> renderer)
            throws IllegalArgumentException;

    /**
     * @param stackRenderer The StackRenderer to be used
     * @throws IllegalArgumentException If and only if stackRenderer is null
     */
    void registerStackRenderer(StackRenderer stackRenderer) throws IllegalArgumentException;

    /**
     * @param renderable The renderable to render
     * @param timestamp  The timestamp at which to render the Renderable; this parameter is of
     *                   particular importance to {@link ProviderAtTime}.
     * @throws IllegalArgumentException If and only if renderable is null, or is of an unregistered
     *                                  Renderable type; or if timestamp is before the most recently
     *                                  rendered timestamp
     */
    <T extends Renderable> void render(T renderable, long timestamp)
            throws IllegalArgumentException;
}
