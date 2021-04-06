package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.assets.Font;
import soliloquy.specs.graphics.rendering.FloatBox;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * <b>TextLineRenderable</b>
 * <p>
 * An text line which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface TextLineRenderable extends Renderable<TextLineRenderable> {
    /**
     * @return The Font of this line
     */
    Font font();

    /**
     * @return The text of this line
     */
    String lineText();

    /**
     * <b>NB: For TextLineRenderables, only the left X and top Y values are considered; the height
     * is calculated using {@link #lineHeight}, and the width is calculated at runtime from the </b>
     * @return The area in the window into which to render
     */
    FloatBox renderingArea();

    /**
     * @return The height of the line, where the entirety of the window has a height of 1.0.
     */
    float lineHeight();

    /**
     * When the Color value is null, this corresponds to the default font color
     * @return A map, where the integer keys correspond to the indices in the String (c.f.
     * {@link #lineText}), and the Color value corresponds to the color to draw all subsequent
     * glyphs. This method may return null, in which case, the entire text line is rendered in the
     * default text color.
     */
    Map<Integer, Color> colorIndices();

    /**
     * @return A list of integer keys, corresponding to the indices in the String (c.f.
     * {@link #lineText()}. The first index corresponds to when the text should begin rendering as
     * italicized, the second corresponds to when the text should stop rendering as italicized, the
     * third when it should resume rendering as italicized, and so-on. This method may return null,
     * in which case, the entire text line is rendered non-italicized.
     */
    List<Integer> italicIndices();

    /**
     * @return A list of integer keys, corresponding to the indices in the String (c.f.
     * {@link #lineText()}. The first index corresponds to when the text should begin rendering as
     * bold, the second corresponds to when the text should stop rendering as bold, the third when
     * it should resume rendering as bold, and so-on. This method may return null, in which case,
     * the entire text line is rendered non-bold.
     */
    List<Integer> boldIndices();
}
