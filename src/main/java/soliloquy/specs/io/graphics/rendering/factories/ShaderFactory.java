package soliloquy.specs.io.graphics.rendering.factories;

import soliloquy.specs.io.graphics.rendering.Shader;

/**
 * <b>ShaderFactory</b>
 * <p>
 * Creates {@link Shader}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ShaderFactory {
    /**
     * @param filenamePrefix The prefix to the filenames of the Shaders. For instance, if
     *                       filenamePrefix is "defaultShader", then this class will look for
     *                       "defaultShader.fs" and "defaultShader.vs" for the fragment and vertex
     *                       Shaders respectively.
     * @return The newly-created Shader
     * @throws IllegalArgumentException If and only if filenamePrefix is null or empty
     */
    Shader make(String filenamePrefix) throws IllegalArgumentException;
}
