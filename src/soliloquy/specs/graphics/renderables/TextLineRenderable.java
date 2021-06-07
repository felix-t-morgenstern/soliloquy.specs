package soliloquy.specs.graphics.renderables;

import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.graphics.assets.Font;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

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
public interface TextLineRenderable extends RenderableWithBorders {
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

    /**
     * <i>NB: This provider will return the x and y locations (respectively) for where this text
     * line will start its rendering. For left or right aligned text lines, this location will be
     * the left-most or right-most location of text on this line, respectively. For horizontally
     * centered text, this location will specify the center of the text line.</i>
     * @return A provider which specifies the location at which this text line is rendered
     */
    ProviderAtTime<Pair<Float,Float>> getRenderingLocationProvider();

    /**
     * C.f. {@link #getRenderingLocationProvider()} for more information
     * @param renderingLocationProvider The renderingLocationProvider to set for this Renderable
     * @throws IllegalArgumentException If and only if renderingLocationProvider is null
     */
    void setRenderingLocationProvider(ProviderAtTime<Pair<Float,Float>> renderingLocationProvider)
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
     * @return The justification of the text line to be rendered (e.g. left, center, or right
     * horizontal alignment)
     */
    TextJustification getJustification();

    /**
     * @param justification The horizontal justification (i.e. alignment) of this line of text
     * @throws IllegalArgumentException If and only if justification is null or UNKNOWN
     */
    void setJustification(TextJustification justification) throws IllegalArgumentException;

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
