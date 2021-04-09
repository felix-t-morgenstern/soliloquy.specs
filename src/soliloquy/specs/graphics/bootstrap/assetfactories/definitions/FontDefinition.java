package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.graphics.assets.Font;

/**
 * <b>FontDefinition</b>
 * <p>
 * This class defines a {@link Font}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface FontDefinition extends AssetDefinition<Font> {
    /**
     * @return This is the relative location of the font file within the font folder
     */
    String relativeLocation();

    /**
     * @return The maximum size of the font which can be displayed without getting blurry from
     * being drawn too large (cannot be less than 0)
     */
    float maxLosslessFontSize();

    /**
     * <i>NB: This value only specifies how the glyphs are padded when stored on the GPU; it does
     * not affect how they are rendered whatsoever.</i> The padding here is expressed in percentage
     * of glyph width, so a value of 0.1f implies an additional padding of 10% of the glyph's
     * width. <i>This method exists because some fonts require additional padding to prevent glyphs
     * from overlapping.</i>
     * @return The amount of horizontal padding between rendered glyphs of this Font (cannot be
     * less than 0)
     */
    float additionalGlyphHorizontalPadding();

    /**
     * <i>NB: This value only specifies how the glyphs are padded when stored on the GPU; it does
     * not affect how they are rendered whatsoever.</i> The padding here is expressed in percentage
     * of glyph height, so a value of 0.1f implies an additional padding of 10% of the glyph's
     * height. <i>This method exists because some fonts require additional padding to prevent
     * glyphs from overlapping.</i>
     * @return The amount of vertical padding between rendered glyphs of this Font (cannot be less
     * than 0)
     */
    float additionalGlyphVerticalPadding();

    /**
     * <i>This method exists because some TTF files do not properly encode the leading of their
     * lines.</i> You will be able to tell this when you load the font, and you find that none of
     * the uppercase glyphs reach the top of the line. If you want to use a font whose leading is
     * not set properly, use this method to specify the additional percentage of the line height
     * which should properly be the leading. If this method returns 0.1f, for instance, this
     * implies that an additional 10% of the line height should be read by the Graphics engine as
     * the leading of the font.
     * <p>
     * @see <a href="https://en.wikipedia.org/wiki/Leading">https://en.wikipedia.org/wiki/Leading</a>
     * @return The additional percentage of the font's total line height to interpret as leading
     */
    float leadingAdjustment();
}
