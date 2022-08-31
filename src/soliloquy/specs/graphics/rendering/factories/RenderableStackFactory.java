package soliloquy.specs.graphics.rendering.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.rendering.FloatBox;
import soliloquy.specs.graphics.rendering.RenderableStack;

import java.util.UUID;

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
     * @return A top-level RenderingStack, intended to contain all Renderables except for itself
     */
    RenderableStack makeTopLevelStack();

    /**
     * @param uuid The UUID of this RenderableStack
     * @param z The z-index of this RenderableStack
     * @param renderingDimensions The dimensions within which anything in this stack will be rendered
     * @param containingStack The RenderableStack in which this RenderableStack is contained
     * @return The newly-created RenderableStack
     * @throws IllegalArgumentException If and only if uuid is null
     */
    RenderableStack makeContainedStack(UUID uuid, int z, FloatBox renderingDimensions, RenderableStack containingStack) throws IllegalArgumentException;
}
