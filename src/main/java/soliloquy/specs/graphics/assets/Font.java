package soliloquy.specs.graphics.assets;

/**
 * <b>Font</b>
 * <p>
 * This class is a Font, which can be used to generate a
 * {@link soliloquy.specs.graphics.renderables.TextLineRenderable}. This class describes how to
 * render letters in a font, for four different font styles: Plain, italic, bold, and bold-italic.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
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
