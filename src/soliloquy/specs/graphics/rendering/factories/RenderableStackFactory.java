package soliloquy.specs.graphics.rendering.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.rendering.RenderableStack;

/**
 * <b>ShaderFactory</b>
 * <p>
 * Creates {@link RenderableStack}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RenderableStackFactory extends SoliloquyClass {
    /**
     * @return The newly-created RenderableStack
     * @throws IllegalArgumentException If and only if mapFactory is null or listFactory is null
     */
    RenderableStack make() throws IllegalArgumentException;
}
