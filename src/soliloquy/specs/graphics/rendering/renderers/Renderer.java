package soliloquy.specs.graphics.rendering.renderers;

import soliloquy.specs.graphics.renderables.Renderable;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.rendering.Mesh;
import soliloquy.specs.graphics.rendering.Shader;
import soliloquy.specs.graphics.shared.HasMostRecentTimestamp;

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
public interface Renderer<TRenderable extends Renderable> extends HasMostRecentTimestamp {
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
     * @param timestamp The timestamp at which to render the Renderable; this parameter is of
     *                  particular importance to
     *                  {@link ProviderAtTime}.
     * @throws IllegalArgumentException If and only if renderable is null, or if timestamp is
     * before the most recently rendered timestamp
     */
    void render(TRenderable renderable, long timestamp) throws IllegalArgumentException;
}
