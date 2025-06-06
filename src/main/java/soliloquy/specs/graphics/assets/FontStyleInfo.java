package soliloquy.specs.graphics.assets;

import soliloquy.specs.common.valueobjects.Coordinate2d;
import soliloquy.specs.graphics.bootstrap.assetfactories.definitions.FontStyleDefinition;
import soliloquy.specs.common.valueobjects.FloatBox;

import java.util.Map;

/**
 * <b>FontStyleInfo</b>
 * <p>
 * This class describes a texture (c.f.
 * {@linktourl <a href="https://learnopengl.com/Getting-started/Textures">here for more info</a>})
 * which can be rendered by the {@link soliloquy.specs.graphics.renderables.TextLineRenderable},
 * given the information provided in this class.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FontStyleInfo extends HasTextureId {
    /**
     * ("UV coordinates" here refers to the coordinates within a texture uploaded to the GPU; this
     * method allows glyphs to be rendered analogously to {@link AssetSnippet}s.)
     *
     * @param glyph The glyph for which to retrieve the UV coordinates
     * @return The UV coordinates of the provided glyph
     * @throws IllegalArgumentException If and only if glyph corresponds to an invalid character
     *                                  (e.g. ASCII control characters, such as DEL or CR)
     */
    FloatBox getUvCoordinatesForGlyph(char glyph) throws IllegalArgumentException;

    /**
     * @return The dimensions of the texture generated for this style of the font
     */
    Coordinate2d textureDimensions();

    /**
     * @return The width-to-height ratio of the texture generated for this style of the font
     */
    float textureWidthToHeightRatio();

    /**
     * @return The amount of additional horizontal texture spacing (c.f.
     *         {@link FontStyleDefinition#additionalGlyphHorizontalTextureSpacing} for all glyphs of
     *         this style of the font
     */
    float additionalHorizontalTextureSpacing();

    /**
     * @return This method is used by
     *         {@link soliloquy.specs.graphics.rendering.renderers.TextLineRenderer#render} to
     *         ensure that glyphs with additional texture spacing, like a 'Q' with a long tail,
     *         don't push subsequent glyphs off to the right by that same amount. This method can
     *         return null.
     */
    Map<Character, Float> glyphwiseAdditionalHorizontalTextureSpacing();
}
