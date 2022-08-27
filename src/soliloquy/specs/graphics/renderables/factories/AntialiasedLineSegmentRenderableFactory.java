package soliloquy.specs.graphics.renderables.factories;

import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.AntialiasedLineSegmentRenderable;
import soliloquy.specs.graphics.renderables.ImageAssetSetRenderable;
import soliloquy.specs.graphics.renderables.LineSegmentRenderable;
import soliloquy.specs.graphics.renderables.Renderable;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.awt.*;
import java.util.function.Consumer;

/**
 * <b>AntialiasedLineSegmentRenderableFactory</b>
 * <p>
 * Creates {@link AntialiasedLineSegmentRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface AntialiasedLineSegmentRenderableFactory extends SoliloquyClass {
    /**
     * @param vertex1LocationProvider          A Provider, which provides the first vertex of this
     *                                         line segment
     * @param vertex2LocationProvider          A Provider, which provides the second vertex of this
     *                                         line segment
     * @param thicknessProvider                A ProviderAtTime which provides the thickness of this
     *                                         line segment, c.f.
     *                                         {@link LineSegmentRenderable#getThicknessProvider()}
     * @param colorProvider                    A ProviderAtTime which provides the color of this
     *                                         line segment
     * @param thicknessGradientPercentProvider A Provider, which designates what percentage of the
     *                                         line segment's thickness is made of a gradient going
     *                                         from the provided color to transparency
     * @param lengthGradientPercentProvider    A Provider, which designates what percentage of the
     *                                         line segment's length is made of a gradient going
     *                                         from the provided color to transparency
     * @param z                                The z-index of this Renderable, c.f. {@link
     *                                         Renderable#getZ}
     * @param uuid                             The uuid of this Renderable
     * @return The newly-created AntialiasedLineSegmentRenderable
     */
    AntialiasedLineSegmentRenderable make(ProviderAtTime<Pair<Float, Float>>
                                                  vertex1LocationProvider,
                                          ProviderAtTime<Pair<Float, Float>>
                                                  vertex2LocationProvider,
                                          ProviderAtTime<Float> thicknessProvider,
                                          ProviderAtTime<Color> colorProvider,
                                          ProviderAtTime<Float> thicknessGradientPercentProvider,
                                          ProviderAtTime<Float> lengthGradientPercentProvider,
                                          int z,
                                          java.util.UUID uuid)
            throws IllegalArgumentException;
}
