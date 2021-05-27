package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.assets.Font;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
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
public interface TextLineRenderable extends Renderable {
    /**
     * @return The Font of this line
     */
    Font getFont();

    /**
     * C.f. {@link #getFont()} for more information
     * @param font The Font to set for this Renderable
     * @throws IllegalArgumentException If and only if font is null
     */
    void setFont(Font font) throws IllegalArgumentException;

    /**
     * @return The text of this line
     */
    String getLineText();

    /**
     * C.f. {@link #getLineText()} for more information
     * @param lineText The text to set for this line
     * @throws IllegalArgumentException If and only if lineText is null
     */
    void setLineText(String lineText) throws IllegalArgumentException;

    // TODO: Consider making this a Coordinate, and create an interface which supports renderingAreaProvider
    /**
     * <b>NB: For TextLineRenderables, only the left X and top Y values are considered; the height
     * is calculated using {@link #getLineHeight}, and the width is calculated at runtime from the
     * width of the text</b>
     * @return The area in the window into which to render
     */
    ProviderAtTime<FloatBox> getRenderingAreaProvider();

    /**
     * C.f. {@link #getRenderingAreaProvider()} for more information
     * @param renderingAreaProvider The renderingAreaProvider to set for this Renderable
     * @throws IllegalArgumentException If and only if renderingAreaProvider is null
     */
    void setRenderingAreaProvider(ProviderAtTime<FloatBox> renderingAreaProvider)
            throws IllegalArgumentException;

    // TODO: Consider making this a ProviderAtTime
    /**
     * @return The height of the line, where the entirety of the window has a height of 1.0.
     */
    float getLineHeight();

    /**
     * C.f. {@link #getLineHeight()} for more information
     * @param lineHeight The height to set for this line
     * @throws IllegalArgumentException If and only if lineHeight is less than or equal to 0
     */
    void setLineHeight(float lineHeight) throws IllegalArgumentException;

    /**
     * @return The amount of padding between glyphs, where 0f implies the standard padding between
     * glyphs of the font (rather than no space between glyphs whatsoever), and 1f implies an
     * additional space between letters equal to {@link #getLineHeight}.
     */
    float getPaddingBetweenGlyphs();

    /**
     * C.f. {@link #getPaddingBetweenGlyphs()} for more information
     * @param paddingBetweenGlyphs The padding between glyphs for this line
     */
    void setPaddingBetweenGlyphs(float paddingBetweenGlyphs);

    /**
     * When the Color value provided is null, this corresponds to the default font color
     * @return A map, where the integer keys correspond to the indices in the String (c.f.
     * {@link #getLineText}), and the ProviderAtTime values correspond to providers which provide
     * the color to draw all subsequent glyphs at a given timestamp. This method may return null,
     * in which case, the entire text line is rendered in the default text color.
     */
    Map<Integer, ProviderAtTime<Color>> colorProviderIndices();

    /**
     * <i>NB: It is assumed that indices will be in ascending order; if they are not, the
     * {@link soliloquy.specs.graphics.rendering.renderers.TextLineRenderer} will throw an
     * exception.</i>
     * @return A list of integer keys, corresponding to the indices in the String (c.f.
     * {@link #getLineText()}. The first index corresponds to when the text should begin rendering
     * as italicized, the second corresponds to when the text should stop rendering as italicized,
     * the third when it should resume rendering as italicized, and so-on. This method may not
     * return null.
     */
    List<Integer> italicIndices();

    /**
     * <i>NB: It is assumed that indices will be in ascending order; if they are not, the
     * {@link soliloquy.specs.graphics.rendering.renderers.TextLineRenderer} will throw an
     * exception.</i>
     * @return A list of integer keys, corresponding to the indices in the String (c.f.
     * {@link #getLineText()}. The first index corresponds to when the text should begin rendering
     * as bold, the second corresponds to when the text should stop rendering as bold, the third
     * when it should resume rendering as bold, and so-on. This method may not return null.
     */
    List<Integer> boldIndices();
}
