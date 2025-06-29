package soliloquy.specs.io.graphics.rendering.factories;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.rendering.RenderableStack;

import java.util.UUID;

/**
 * <b>ShaderFactory</b>
 * <p>
 * Creates {@link RenderableStack}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RenderableStackFactory {
    /**
     * @return A top-level RenderingStack, intended to contain all Renderables except for itself
     */
    RenderableStack makeTopLevelStack();

    /**
     * @param uuid                        The UUID of this RenderableStack
     * @param z                           The z-index of this RenderableStack
     * @param renderingBoundariesProvider The dimensions within which anything in this stack will be
     *                                    rendered
     * @param containingStack             The RenderableStack in which this RenderableStack is
     *                                    contained
     * @return The newly-created RenderableStack
     * @throws IllegalArgumentException If and only if uuid is null
     */
    RenderableStack makeContainedStack(UUID uuid, int z,
                                       ProviderAtTime<FloatBox> renderingBoundariesProvider,
                                       RenderableStack containingStack)
            throws IllegalArgumentException;
}
