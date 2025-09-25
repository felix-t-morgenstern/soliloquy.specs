package soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions;

import java.util.Map;

/**
 * <b>FontStyleDefinition</b>
 * <p>
 * This class describes the characteristics of a font, usually in the form of a .ttf file, to be
 * used to generate a texture in OpenGL, and a corresponding
 * {@link soliloquy.specs.io.graphics.assets.FontStyleInfo}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class FontStyleDefinition {
    private final float ADDITIONAL_GLYPH_HORIZONTAL_TEXTURE_SPACING;
    private final Map<Character, Float> GLYPHWISE_ADDITIONAL_HORIZONTAL_TEXTURE_SPACING;
    private final Map<Character, Float> GLYPHWISE_ADDITIONAL_LEFT_BOUNDARY_SHIFT;
    private final Map<Character, Float> GLYPHWISE_WIDTH_FACTORS;
    private final float ADDITIONAL_GLYPH_VERTICAL_TEXTURE_SPACING;

    public FontStyleDefinition(float additionalGlyphHorizontalTextureSpacing,
                               Map<Character, Float> glyphwiseAdditionalHorizontalTextureSpacing,
                               Map<Character, Float> glyphwiseAdditionalLeftBoundaryShift,
                               Map<Character, Float> glyphwiseWidthFactors,
                               float additionalGlyphVerticalTextureSpacing) {
        ADDITIONAL_GLYPH_HORIZONTAL_TEXTURE_SPACING = additionalGlyphHorizontalTextureSpacing;
        GLYPHWISE_ADDITIONAL_HORIZONTAL_TEXTURE_SPACING =
                glyphwiseAdditionalHorizontalTextureSpacing;
        GLYPHWISE_ADDITIONAL_LEFT_BOUNDARY_SHIFT = glyphwiseAdditionalLeftBoundaryShift;
        GLYPHWISE_WIDTH_FACTORS = glyphwiseWidthFactors;
        ADDITIONAL_GLYPH_VERTICAL_TEXTURE_SPACING = additionalGlyphVerticalTextureSpacing;
    }

    /**
     * <i>NB: This value only specifies how the glyphs are spaced in the texture stored in the GPU;
     * it does not affect how they are rendered whatsoever.</i> The spacing here is expressed in
     * percentage of glyph height, so a value of 0.1f implies an additional spacing of 10% of the
     * glyph's height. <i>This method exists because some fonts require additional spacing to
     * prevent glyphs from overlapping.</i>
     *
     * @return The amount of horizontal texture spacing between rendered glyphs of this style of
     *         this Font (cannot be less than 0)
     */
    public float additionalGlyphHorizontalTextureSpacing() {
        return ADDITIONAL_GLYPH_HORIZONTAL_TEXTURE_SPACING;
    }

    /**
     * <i>NB: This method is intended for fonts with specific problematic characters, like a 'Q'
     * whose tail juts out dramatically to the right, potentially overlapping with other
     * glyphs.</i>
     *
     * @return A Map linking Characters to their horizontal texture spacing, in addition to what is
     *         specified by {@link #additionalGlyphHorizontalTextureSpacing}. This method can return
     *         null.
     *         (It can also contain invalid characters, which will just be ignored.) However, all
     *         values
     *         for valid characters must be non-null.
     */
    public Map<Character, Float> glyphwiseAdditionalHorizontalTextureSpacing() {
        return GLYPHWISE_ADDITIONAL_HORIZONTAL_TEXTURE_SPACING;
    }

    /**
     * <i>NB: This method is intended for fonts with specific problematic glyph spacing, like where
     * the space that the 'i' glyph is rendered includes the left-most tip of the 'j' glyph; and
     * conversely, when the 'j' glyph is rendered, it does not include that left-most tip. For this
     * method, a Map is returned, where the character corresponds to the glyph in need of that
     * extra left space, and the corresponding float value is the amount of left space needed,
     * expressed in percentage of this FontStyle's glyph height.</i>
     *
     * @return A Map, linking characters to the shifting of their left boundaries, expressed in
     *         line height
     */
    public Map<Character, Float> glyphwiseAdditionalLeftBoundaryShift() {
        return GLYPHWISE_ADDITIONAL_LEFT_BOUNDARY_SHIFT;
    }

    /**
     * <i>NB: This method is intended for fonts where certain glyphs have a recorded width which
     * goes too far to the right, occasionally including the left fringes of 'neighboring' glyphs.
     * The width of a provided glyph (reported by {@link java.awt.FontMetrics#charWidth(char)}) is
     * multiplied by the respective float factor for its respective character key value.</i>
     *
     * @return A Map, linking characters to the width multiplication factor for their glyph
     */
    public Map<Character, Float> glyphwiseWidthFactors() {
        return GLYPHWISE_WIDTH_FACTORS;
    }

    /**
     * <i>NB: This value only specifies how the glyphs are spaced in the texture stored in the GPU;
     * it does not affect how they are rendered whatsoever.</i> The spacing here is expressed in
     * percentage of glyph height, so a value of 0.1f implies an additional spacing of 10% of the
     * glyph's height. <i>This method exists because some fonts require additional spacing to
     * prevent glyphs from overlapping.</i>
     *
     * @return The amount of vertical texture spacing between rendered glyphs of this style of this
     *         Font (cannot be less than 0)
     */
    public float additionalGlyphVerticalTextureSpacing() {
        return ADDITIONAL_GLYPH_VERTICAL_TEXTURE_SPACING;
    }
}
