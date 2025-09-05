package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.io.graphics.renderables.AntialiasedLineSegmentRenderable;
import soliloquy.specs.io.graphics.renderables.LineSegmentRenderable;
import soliloquy.specs.io.graphics.renderables.Renderable;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.io.graphics.renderables.Component;

import java.awt.*;

/**
 * <b>AntialiasedLineSegmentRenderableFactory</b>
 * <p>
 * Creates {@link AntialiasedLineSegmentRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface AntialiasedLineSegmentRenderableFactory {
    /**
     * @param vertex1Provider                  A Provider, which provides the first vertex of this
     *                                         line segment
     * @param vertex2Provider                  A Provider, which provides the second vertex of this
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
     * @param component                        The Component to contain the Renderable
     * @return The newly-created AntialiasedLineSegmentRenderable
     * @throws IllegalArgumentException If and only if vertex1Provider, vertex2Provider,
     *                                  thicknessProvider, colorProvider,
     *                                  thicknessGradientPercentProvider,
     *                                  lengthGradientPercentProvider, uuid, or component are null
     */
    AntialiasedLineSegmentRenderable make(ProviderAtTime<Vertex> vertex1Provider,
                                          ProviderAtTime<Vertex> vertex2Provider,
                                          ProviderAtTime<Color> colorProvider,
                                          ProviderAtTime<Float> thicknessProvider,
                                          ProviderAtTime<Float> thicknessGradientPercentProvider,
                                          ProviderAtTime<Float> lengthGradientPercentProvider,
                                          int z,
                                          java.util.UUID uuid,
                                          Component component)
            throws IllegalArgumentException;
}
