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
public class FontDefinition extends AssetDefinition<Font> {
    private final String RELATIVE_LOCATION;
    private final float MAX_LOSSLESS_FONT_SIZE;
    private final float LEADING_ADJUSTMENT;
    private final FontStyleDefinition PLAIN;
    private final FontStyleDefinition ITALIC;
    private final FontStyleDefinition BOLD;
    private final FontStyleDefinition BOLD_ITALIC;

    public FontDefinition(String id,
                          String relativeLocation,
                          float maxLosslessFontSize,
                          float leadingAdjustment,
                          FontStyleDefinition plain,
                          FontStyleDefinition italic,
                          FontStyleDefinition bold,
                          FontStyleDefinition boldItalic) {
        super(id);
        RELATIVE_LOCATION = relativeLocation;
        MAX_LOSSLESS_FONT_SIZE = maxLosslessFontSize;
        LEADING_ADJUSTMENT = leadingAdjustment;
        PLAIN = plain;
        ITALIC = italic;
        BOLD = bold;
        BOLD_ITALIC = boldItalic;
    }

    /**
     * @return This is the relative location of the font file within the font folder
     */
    public String relativeLocation() {
        return RELATIVE_LOCATION;
    }

    /**
     * @return The maximum size of the font which can be displayed without getting blurry from
     * being drawn too large (cannot be less than 0)
     */
    public float maxLosslessFontSize() {
        return MAX_LOSSLESS_FONT_SIZE;
    }

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
    public float leadingAdjustment() {
        return LEADING_ADJUSTMENT;
    }

    /**
     * @return A definition of how to load the plain (non-italic, non-bold) style of this Font
     */
    public FontStyleDefinition plain() {
        return PLAIN;
    }

    /**
     * @return A definition of how to load the italic style of this Font
     */
    public FontStyleDefinition italic() {
        return ITALIC;
    }

    /**
     * @return A definition of how to load the bold style of this Font
     */
    public FontStyleDefinition bold() {
        return BOLD;
    }

    /**
     * @return A definition of how to load the bold, italic style of this Font
     */
    public FontStyleDefinition boldItalic() {
        return BOLD_ITALIC;
    }
}
