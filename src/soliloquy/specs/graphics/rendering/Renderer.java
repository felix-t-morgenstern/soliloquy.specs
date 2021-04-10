package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.Renderable;

/**
 * <b>Renderer</b>
 * <p>
 * This class defines a class that renders renderables of a specific {@link Renderable}, e.g.
 * {@link soliloquy.specs.graphics.renderables.SpriteRenderable} or
 * {@link soliloquy.specs.graphics.renderables.FiniteAnimationRenderable}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Renderer<TRenderable extends Renderable> extends SoliloquyClass {
    /**
     * @param mesh The Mesh to assign to this Renderer
     * @throws IllegalArgumentException If and only if mesh is null
     */
    void setMesh(Mesh mesh) throws IllegalArgumentException;

    /**
     * @param shader The Shader to assign to this Renderer
     * @throws IllegalArgumentException If and only if shader is null
     */
    void setShader(Shader shader) throws IllegalArgumentException;

    /**
     * @param renderable The renderable of the provided type to render
     * @throws IllegalArgumentException If and only if renderable is null
     */
    void render(TRenderable renderable) throws IllegalArgumentException;
}
