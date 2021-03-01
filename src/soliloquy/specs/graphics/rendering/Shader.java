package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>Shader</b>
 * <p>
 *
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Shader extends SoliloquyClass {
    /**
     * Binds the graphics engine to this Shader. (Unbinds the previously bound Shader
     * automatically.)
     */
    void bind();

    /**
     * Unbinds the graphics engine from this Shader.
     */
    void unbind();

    /**
     * @param name The name of the uniform value to set
     * @param f The value to set for the specified uniform value
     * @throws IllegalArgumentException If and only if name is null or empty
     */
    void setUniform(String name, float f) throws IllegalArgumentException;

    /**
     * @param name The name of the uniform value to set
     * @param f1 The first value to set for the specified uniform value
     * @param f2 The second value to set for the specified uniform value
     * @throws IllegalArgumentException If and only if name is null or empty
     */
    void setUniform(String name, float f1, float f2) throws IllegalArgumentException;

    /**
     * @param name The name of the uniform value to set
     * @param f1 The first value to set for the specified uniform value
     * @param f2 The second value to set for the specified uniform value
     * @param f3 The third value to set for the specified uniform value
     * @throws IllegalArgumentException If and only if name is null or empty
     */
    void setUniform(String name, float f1, float f2, float f3) throws IllegalArgumentException;

    /**
     * @param name The name of the uniform value to set
     * @param f1 The first value to set for the specified uniform value
     * @param f2 The second value to set for the specified uniform value
     * @param f3 The third value to set for the specified uniform value
     * @param f4 The fourth value to set for the specified uniform value
     * @throws IllegalArgumentException If and only if name is null or empty
     */
    void setUniform(String name, float f1, float f2, float f3, float f4)
            throws IllegalArgumentException;
}
