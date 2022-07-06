package soliloquy.specs.graphics.renderables.factories;

import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.assets.Font;
import soliloquy.specs.graphics.renderables.ImageAssetSetRenderable;
import soliloquy.specs.graphics.renderables.Renderable;
import soliloquy.specs.graphics.renderables.TextJustification;
import soliloquy.specs.graphics.renderables.TextLineRenderable;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * <b>SpriteRenderableFactory</b>
 * <p>
 * Creates {@link TextLineRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface TextLineRenderableFactory extends SoliloquyClass {
    /**
     * @param font The Font to set for this Renderable
     * @param lineTextProvider The text of this line
     * @param lineHeightProvider The {@link ProviderAtTime} for the height of the line, where the
     *                           entirety of the window has a height of 1.0.
     * @param justification The justification of the text line to be rendered (e.g. left, center,
     *                      or right horizontal alignment)
     * @param paddingBetweenGlyphs The amount of padding between glyphs, c.f.
     *                             {@link TextLineRenderable#getPaddingBetweenGlyphs}
     * @param colorProviderIndices A map, where the integer keys correspond to the indices in the
     *                             String; c.f. {@link TextLineRenderable#colorProviderIndices}
     * @param italicIndices A list of integer keys, corresponding to the indices in the String,
     *                      c.f. {@link TextLineRenderable#italicIndices}
     * @param boldIndices A list of integer keys, corresponding to the indices in the String, c.f.
     *                    {@link TextLineRenderable#boldIndices}
     * @param borderThicknessProvider A ProviderAtTime providing thickness of the border to render
     *                                around this Renderable, c.f.
     *                                {@link TextLineRenderable#getBorderThicknessProvider}
     * @param borderColorProvider A ProviderAtTime providing the color of the border to render
     *                            around this Renderable, c.f.
     *                            {@link TextLineRenderable#getBorderColorProvider}
     * @param renderingLocationProvider A provider which specifies the location at which this text
     *                                  line is rendered, c.f.
     *                                  {@link TextLineRenderable#getRenderingLocationProvider}
     * @param dropShadowSizeProvider The ProviderAtTime for the size of the drop shadow, where the
     *                               entirety of the window has a height of 1.0.
     * @param dropShadowOffsetProvider The ProviderAtTime which provides the offset of the drop
     *                                 shadow, where the two floats provided are x and y offsets
     *                                 respectively, and entirety of the window has a height of 1.0
     * @param dropShadowColorProvider The ProviderAtTime for the color of the drop shadow
     * @param z The z-index of this Renderable, c.f. {@link Renderable#getZ}
     * @param uuid The uuid of this Renderable
     * @param updateZIndexInContainer A Consumer which will accept this object to update its
     *                                z-index within its container when
     *                                {@link ImageAssetSetRenderable#setZ} is called
     * @param removeFromContainer A Consumer which will accept this object to delete it from its
     *                            container when deleted
     * @return The newly-created TextLineRenderable
     * @throws IllegalArgumentException If and only if font is null; lineTextProvider is null; lineHeight
     * is 0 or less; justification is null or UNKNOWN; colorProviderIndices is null; italicIndices
     * is null; boldIndices is null; borderThicknessProvider is null, and borderColorProvider is
     * non-null; renderingLocationProvider is null; dropShadowSizeProvider is null;
     * dropShadowOffsetProvider is null; dropShadowColorProvider is null; uuid is null;
     * updateZIndexInContainer is null; or removeFromContainer is null
     */
    TextLineRenderable make(Font font, ProviderAtTime<String> lineTextProvider,
                            ProviderAtTime<Float> lineHeightProvider,
                            TextJustification justification, float paddingBetweenGlyphs,
                            Map<Integer, ProviderAtTime<Color>> colorProviderIndices,
                            List<Integer> italicIndices, List<Integer> boldIndices,
                            ProviderAtTime<Float> borderThicknessProvider,
                            ProviderAtTime<Color> borderColorProvider,
                            ProviderAtTime<Pair<Float,Float>> renderingLocationProvider,
                            ProviderAtTime<Float> dropShadowSizeProvider,
                            ProviderAtTime<Pair<Float,Float>> dropShadowOffsetProvider,
                            ProviderAtTime<Color> dropShadowColorProvider,
                            int z, UUID uuid,
                            Consumer<Renderable> updateZIndexInContainer,
                            Consumer<Renderable> removeFromContainer)
            throws IllegalArgumentException;
}
