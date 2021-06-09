package soliloquy.specs.graphics.rendering.factories;

import soliloquy.specs.common.factories.ListFactory;
import soliloquy.specs.common.factories.MapFactory;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.rendering.RenderableStack;

/**
 * <b>ShaderFactory</b>
 * <p>
 * Creates {@link RenderableStack}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RenderableStackFactory extends SoliloquyClass {
    /**
     * @param mapFactory A MapFactory
     * @param listFactory A ListFactory
     * @return The newly-created RenderableStack
     * @throws IllegalArgumentException If and only if mapFactory is null or listFactory is null
     */
    RenderableStack make(MapFactory mapFactory, ListFactory listFactory)
            throws IllegalArgumentException;
}
