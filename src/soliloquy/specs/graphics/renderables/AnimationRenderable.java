package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.assets.Animation;

/**
 * <b>AnimationRenderable</b>
 * <p>
 * An Animation which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface AnimationRenderable extends Renderable {
    /**
     * @return The Animation to render
     */
    Animation animation();

    /**
     * @return The UI millisecond timestamp at which the Animation started. (NB: This timestamp is
     * the timestamp of the Animation renderer (i.e.
     * {@link soliloquy.specs.graphics.rendering.RendererType<Animation>}), not the timestamp of
     * the application.)
     */
    long startMs();
}
