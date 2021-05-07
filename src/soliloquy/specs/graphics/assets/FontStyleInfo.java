package soliloquy.specs.graphics.assets;

import soliloquy.specs.common.valueobjects.Coordinate;
import soliloquy.specs.graphics.rendering.FloatBox;

import java.util.Map;

// TODO: Add javadocs header
public interface FontStyleInfo extends HasTextureId {
    /**
     * ("UV coordinates" here refers to the coordinates within a texture uploaded to the GPU; this
     * method allows glyphs to be rendered analogously to {@link AssetSnippet}s.)
     * @param glyph The glyph for which to retrieve the UV coordinates
     * @return The UV coordinates of the provided glyph
     * @throws IllegalArgumentException If and only if glyph corresponds to an invalid character
     * (e.g. ASCII control characters, such as DEL or CR)
     */
    FloatBox getUvCoordinatesForGlyph(char glyph) throws IllegalArgumentException;

    /**
     * @return The dimensions of the texture generated for this style of the font
     */
    Coordinate textureDimensions();

    /**
     * @return The width-to-height ratio of the texture generated for this style of the font
     */
    float textureWidthToHeightRatio();

    /**
     * @return The amount of additional horizontal padding for all glyphs of this style of the font
     */
    float additionalHorizontalPadding();

    /**
     * @return This method is used by
     * {@link soliloquy.specs.graphics.rendering.renderers.TextLineRenderer#render} to ensure that
     * glyphs with additional padding, like a 'Q' with a long tail, don't push subsequent glyphs
     * off to the right by that same amount. This method can return null.
     */
    Map<Character, Float> glyphwiseAdditionalHorizontalPadding();
}
