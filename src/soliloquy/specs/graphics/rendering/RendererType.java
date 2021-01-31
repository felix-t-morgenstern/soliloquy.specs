package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.Renderable;

/**
 * <b>RendererType</b>
 * <p>
 * This class defines a class that renders renderables of a specific {@link Renderable}, e.g.
 * {@link soliloquy.specs.graphics.renderables.SpriteRenderable} or
 * {@link soliloquy.specs.graphics.renderables.AnimationRenderable}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RendererType<TRenderable extends Renderable> extends SoliloquyClass {
    /**
     * @param renderable The renderable of the provided type to render
     * @throws IllegalArgumentException If and only if renderable is null
     */
    void render(TRenderable renderable) throws IllegalArgumentException;
}
