package soliloquy.specs.io.graphics.rendering.renderers;

import soliloquy.specs.common.valueobjects.Pair;
import soliloquy.specs.io.graphics.assets.Font;
import soliloquy.specs.io.graphics.assets.FontStyleInfo;
import soliloquy.specs.io.graphics.renderables.TextLineRenderable;

import java.util.List;

/**
 * <b>TextLineRenderer</b>
 * <p>
 * A renderer for {@link TextLineRenderable}s, which also has the capacity to calculate the length
 * of a TextLineRenderable, which is of use to the UI (e.g. for centering text)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TextLineRenderer extends Renderer<TextLineRenderable> {
    /**
     * @param textLineRenderable The TextLineRenderable whose length to calculate
     * @param timestamp          The timestamp for which the textLineLength is to be evaluated
     * @return The length of the TextLineRenderable, where the width of the window is 1.0f
     * @throws IllegalArgumentException If and only if textLineRenderable is null or has invalid
     *                                  values, or if timestamp is before most recent timestamp
     *                                  provided to class
     */
    float textLineLength(TextLineRenderable textLineRenderable, long timestamp)
            throws IllegalArgumentException;

    /**
     * @param text                 The text whose line length to calculate
     * @param font                 The font
     * @param paddingBetweenGlyphs The padding between glyphs (c.f.
     *                             {@link TextLineRenderable#getPaddingBetweenGlyphs()})
     * @param italicIndices        The indices at which italicization begins and ends (c.f.
     *                             {@link TextLineRenderable#italicIndices()}
     * @param boldIndices          The indices at which boldface begins and ends (c.f.
     *                             {@link TextLineRenderable#boldIndices()} ()}
     * @param lineHeight           The height of the line, expressed in percentage of screen height
     * @return The length of the line, expressed in percentage of screen width
     * @throws IllegalArgumentException If and only if text is null, italicIndices is null,
     *                                  boldIndices is null, font is null, or lineHeight is less
     *                                  than or equal to 0
     */
    float textLineLength(String text,
                         Font font,
                         float paddingBetweenGlyphs,
                         List<Integer> italicIndices,
                         List<Integer> boldIndices,
                         float lineHeight) throws IllegalArgumentException;

    /**
     * @param aChar                The character whose glyph width to calculate
     * @param fontStyleInfo        The style info for a given Font (e.g., the bold-italic version of
     *                             a font, obtained from {@link Font#boldItalic()})
     * @return The length of the glyph, expressed in percentage of screen width
     * @throws IllegalArgumentException If and only if text is null, fontStyleInfo is null, or
     *                                  lineHeight is less than or equal to 0
     */
    float getGlyphWidth(char aChar,
                        FontStyleInfo fontStyleInfo,
                        float lineHeight) throws IllegalArgumentException;
}
