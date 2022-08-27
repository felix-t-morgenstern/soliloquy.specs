package soliloquy.specs.graphics.renderables.factories;

import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.ImageAssetSetRenderable;
import soliloquy.specs.graphics.renderables.LineSegmentRenderable;
import soliloquy.specs.graphics.renderables.RasterizedLineSegmentRenderable;
import soliloquy.specs.graphics.renderables.Renderable;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.awt.*;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * <b>SpriteRenderableFactory</b>
 * <p>
 * Creates {@link RasterizedLineSegmentRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RasterizedLineSegmentRenderableFactory extends SoliloquyClass {
    /**
     * @param vertex1LocationProvider A Provider, which provides the first vertex of this line
     *                                segment
     * @param vertex2LocationProvider A Provider, which provides the second vertex of this line
     *                                segment
     * @param thicknessProvider       A ProviderAtTime which provides the thickness of this line
     *                                segment, c.f.
     *                                {@link LineSegmentRenderable#getThicknessProvider()}
     * @param stipplePattern          The stippling pattern for this line segment, c.f.
     *                                {@link RasterizedLineSegmentRenderable#getStippleFactor}
     * @param stippleFactor           The stippling factor for this line segment, c.f.
     *                                {@link RasterizedLineSegmentRenderable#getStippleFactor}
     * @param colorProvider           A ProviderAtTime which provides the color of this line
     *                                segment, c.f.
     *                                {@link RasterizedLineSegmentRenderable#getColorProvider}
     * @param z                       The z-index of this Renderable, c.f. {@link Renderable#getZ}
     * @param uuid                    The uuid of this Renderable
     * @param updateZIndexInContainer A Consumer which will accept this object to update its
     *                                z-index within its container when
     *                                {@link ImageAssetSetRenderable#setZ} is called
     * @param removeFromContainer     A Consumer which will accept this object to delete it from its
     *                                container when deleted
     * @return The newly-created RasterizedLineSegmentRenderable
     * @throws IllegalArgumentException If and only if thicknessProvider is null; stipplePattern is
     *                                  not 0; stippleFactor is less than 1, or greater than 256;
     *                                  colorProvider is null; renderingDimensionsProvider is null;
     *                                  uuid is null; updateZIndexInContainer is null; or
     *                                  removeFromContainer is null
     */
    RasterizedLineSegmentRenderable make(ProviderAtTime<Pair<Float, Float>> vertex1LocationProvider,
                                         ProviderAtTime<Pair<Float, Float>> vertex2LocationProvider,
                                         ProviderAtTime<Float> thicknessProvider,
                                         short stipplePattern, short stippleFactor,
                                         ProviderAtTime<Color> colorProvider,
                                         int z, UUID uuid,
                                         Consumer<Renderable> updateZIndexInContainer,
                                         Consumer<Renderable> removeFromContainer)
            throws IllegalArgumentException;
}
