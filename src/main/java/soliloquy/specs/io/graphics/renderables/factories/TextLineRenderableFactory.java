package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.io.graphics.assets.Font;
import soliloquy.specs.io.graphics.renderables.Renderable;
import soliloquy.specs.io.graphics.renderables.TextJustification;
import soliloquy.specs.io.graphics.renderables.TextLineRenderable;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.Component;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <b>SpriteRenderableFactory</b>
 * <p>
 * Creates {@link TextLineRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TextLineRenderableFactory {
    /**
     * @param font                     The Font to set for this Renderable
     * @param lineTextProvider         The text of this line
     * @param lineHeightProvider       The {@link ProviderAtTime} for the height of the line, where
     *                                 the entirety of the window has a height of 1.0.
     * @param justification            The justification of the text line to be rendered (e.g.
     *                                 left, center, or right horizontal alignment)
     * @param paddingBetweenGlyphs     The amount of padding between glyphs, c.f.
     *                                 {@link TextLineRenderable#getPaddingBetweenGlyphs}
     * @param colorProviderIndices     A map, where the integer keys correspond to the indices in
     *                                 the String; c.f.
     *                                 {@link TextLineRenderable#colorProviderIndices}
     * @param italicIndices            A list of integer keys, corresponding to the indices in the
     *                                 String, c.f. {@link TextLineRenderable#italicIndices}
     * @param boldIndices              A list of integer keys, corresponding to the indices in the
     *                                 String, c.f. {@link TextLineRenderable#boldIndices}
     * @param borderThicknessProvider  A ProviderAtTime providing thickness of the border to
     *                                 render around this Renderable, c.f.
     *                                 {@link TextLineRenderable#getBorderThicknessProvider}
     * @param borderColorProvider      A ProviderAtTime providing the color of the border to
     *                                 render around this Renderable, c.f.
     *                                 {@link TextLineRenderable#getBorderColorProvider}
     * @param locationProvider         A provider which specifies the location at which this text
     *                                 line is rendered, c.f.
     *                                 {@link TextLineRenderable#getRenderingLocationProvider}
     * @param dropShadowSizeProvider   The ProviderAtTime for the size of the drop shadow, where
     *                                 the entirety of the window has a height of 1.0.
     * @param dropShadowOffsetProvider The ProviderAtTime which provides the offset of the drop
     *                                 shadow, where the two floats provided are x and y offsets
     *                                 respectively, and entirety of the window has a height of 1.0
     * @param dropShadowColorProvider  The ProviderAtTime for the color of the drop shadow
     * @param z                        The z-index of this Renderable, c.f. {@link Renderable#getZ}
     * @param uuid                     The uuid of this Renderable
     * @param component          The Component to contain the Renderable
     * @return The newly-created TextLineRenderable
     * @throws IllegalArgumentException If and only if font is null; lineTextProvider is null;
     *                                  lineHeight is 0 or less; justification is null or UNKNOWN;
     *                                  colorProviderIndices is null; italicIndices is null;
     *                                  boldIndices is null; borderThicknessProvider is null, and
     *                                  borderColorProvider is non-null; locationProvider is null;
     *                                  dropShadowSizeProvider is null; dropShadowOffsetProvider is
     *                                  null; dropShadowColorProvider is null; uuid is null; or
     *                                  component is null
     */
    TextLineRenderable make(Font font,
                            ProviderAtTime<String> lineTextProvider,
                            ProviderAtTime<Vertex> locationProvider,
                            ProviderAtTime<Float> lineHeightProvider,
                            TextJustification justification,
                            float paddingBetweenGlyphs,
                            Map<Integer, ProviderAtTime<Color>> colorProviderIndices,
                            List<Integer> italicIndices,
                            List<Integer> boldIndices,
                            ProviderAtTime<Float> borderThicknessProvider,
                            ProviderAtTime<Color> borderColorProvider,
                            ProviderAtTime<Float> dropShadowSizeProvider,
                            ProviderAtTime<Vertex> dropShadowOffsetProvider,
                            ProviderAtTime<Color> dropShadowColorProvider,
                            int z,
                            UUID uuid,
                            Component component)
            throws IllegalArgumentException;
}
