package soliloquy.specs.io.graphics.rendering;

/**
 * <b>Mesh</b>
 * <p>
 * This class is used to render {@link soliloquy.specs.io.graphics.assets.Sprite}s,
 * {@link soliloquy.specs.io.graphics.assets.Animation}s, etc., by defining how vertices are rendered.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Mesh {
    /**
     * Renders the object whose vertices have just been defined (intended to be used by
     * {@link soliloquy.specs.io.graphics.rendering.renderers.Renderer#render}).
     */
    void render();

    /**
     * Binds the Mesh for rendering (intended to be used by
     * {@link soliloquy.specs.io.graphics.bootstrap.GraphicsCoreLoop#startup}).
     */
    void bind();

    /**
     * Unbinds the Mesh for rendering (intended to be used during application teardown).
     */
    void unbind();

    /**
     * Cleans up the Mesh from memory (intended to be used during application teardown).
     */
    void cleanUp();
}
