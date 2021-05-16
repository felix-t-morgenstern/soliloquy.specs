package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.common.shared.SoliloquyClass;

import java.util.Map;

public interface FontStyleDefinition extends SoliloquyClass {
    /**
     * <i>NB: This value only specifies how the glyphs are spaced in the texture stored in the GPU;
     * it does not affect how they are rendered whatsoever.</i> The spacing here is expressed in
     * percentage of glyph height, so a value of 0.1f implies an additional spacing of 10% of the
     * glyph's height. <i>This method exists because some fonts require additional spacing to
     * prevent glyphs from overlapping.</i>
     * @return The amount of horizontal texture spacing between rendered glyphs of this style of
     * this Font (cannot be less than 0)
     */
    float additionalGlyphHorizontalTextureSpacing();

    /**
     * <i>NB: This method is intended for fonts with specific problematic characters, like a 'Q'
     * whose tail juts out dramatically to the right, potentially overlapping with other
     * glyphs.</i>
     * @return A Map linking Characters to their horizontal texture spacing, in addition to what is
     * specified by {@link #additionalGlyphHorizontalTextureSpacing}. This method can return null.
     * (It can also contain invalid characters, which will just be ignored.) However, all values
     * for valid characters must be non-null.
     */
    Map<Character, Float> glyphwiseAdditionalHorizontalTextureSpacing();

    /**
     * <i>NB: This value only specifies how the glyphs are spaced in the texture stored in the GPU;
     * it does not affect how they are rendered whatsoever.</i> The spacing here is expressed in
     * percentage of glyph height, so a value of 0.1f implies an additional spacing of 10% of the
     * glyph's height. <i>This method exists because some fonts require additional spacing to
     * prevent glyphs from overlapping.</i>
     * @return The amount of vertical texture spacing between rendered glyphs of this style of this
     * Font (cannot be less than 0)
     */
    float additionalGlyphVerticalTextureSpacing();
}
