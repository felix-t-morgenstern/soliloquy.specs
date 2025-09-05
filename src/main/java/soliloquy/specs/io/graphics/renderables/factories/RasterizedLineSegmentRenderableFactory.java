package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.io.graphics.renderables.LineSegmentRenderable;
import soliloquy.specs.io.graphics.renderables.RasterizedLineSegmentRenderable;
import soliloquy.specs.io.graphics.renderables.Renderable;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.io.graphics.renderables.Component;

import java.awt.*;
import java.util.UUID;

/**
 * <b>SpriteRenderableFactory</b>
 * <p>
 * Creates {@link RasterizedLineSegmentRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RasterizedLineSegmentRenderableFactory {
    /**
     * @param vertex1Provider   A Provider, which provides the first vertex of this line segment
     * @param vertex2Provider   A Provider, which provides the second vertex of this line segment
     * @param thicknessProvider A ProviderAtTime which provides the thickness of this line segment,
     *                          c.f. {@link LineSegmentRenderable#getThicknessProvider()}
     * @param stipplePattern    The stippling pattern for this line segment, c.f.
     *                          {@link RasterizedLineSegmentRenderable#getStippleFactor}
     * @param stippleFactor     The stippling factor for this line segment, c.f.
     *                          {@link RasterizedLineSegmentRenderable#getStippleFactor}
     * @param colorProvider     A ProviderAtTime which provides the color of this line
     *                          segment, c.f.
     *                          {@link RasterizedLineSegmentRenderable#getColorProvider}
     * @param z                 The z-index of this Renderable, c.f. {@link Renderable#getZ}
     * @param uuid              The uuid of this Renderable
     * @param component         The Component to contain the Renderable
     * @return The newly-created RasterizedLineSegmentRenderable
     * @throws IllegalArgumentException If and only if thicknessProvider is null; stipplePattern is
     *                                  not 0; stippleFactor is less than 1, or greater than 256;
     *                                  colorProvider is null; renderingDimensionsProvider is null;
     *                                  uuid is null; or component is null
     */
    RasterizedLineSegmentRenderable make(ProviderAtTime<Vertex> vertex1Provider,
                                         ProviderAtTime<Vertex> vertex2Provider,
                                         ProviderAtTime<Float> thicknessProvider,
                                         short stipplePattern, short stippleFactor,
                                         ProviderAtTime<Color> colorProvider,
                                         int z, UUID uuid,
                                         Component component)
            throws IllegalArgumentException;
}
