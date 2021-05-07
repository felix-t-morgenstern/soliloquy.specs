package soliloquy.specs.graphics.assets;

// TODO: Add javadocs header
public interface Font extends Asset {
    /**
     * @return The font style info for the plain version of the font (non-italic, non-bold)
     */
    FontStyleInfo plain();

    /**
     * @return The font style info for the italic version of the font
     */
    FontStyleInfo italic();

    /**
     * @return The font style info for the bold version of the font
     */
    FontStyleInfo bold();

    /**
     * @return The font style info for the bold and italic version of the font
     */
    FontStyleInfo boldItalic();
}
