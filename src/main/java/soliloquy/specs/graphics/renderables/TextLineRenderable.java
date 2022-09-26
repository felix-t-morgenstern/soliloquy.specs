package soliloquy.specs.graphics.renderables;

import soliloquy.specs.common.valueobjects.Pair;
import soliloquy.specs.common.valueobjects.Vertex;
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
 */
public interface TextLineRenderable extends RenderableWithBorders {
    /**
     * @return The Font of this line
     */
    Font getFont();

    /**
     * C.f. {@link #getFont()} for more information
     *
     * @param font The Font to set for this Renderable
     * @throws IllegalArgumentException If and only if font is null
     */
    void setFont(Font font) throws IllegalArgumentException;

    /**
     * @return The text of this line
     */
    ProviderAtTime<String> getLineTextProvider();

    /**
     * C.f. {@link #getLineTextProvider()} for more information
     *
     * @param lineTextProvider The text to set for this line
     * @throws IllegalArgumentException If and only if lineTextProvider is null
     */
    void setLineTextProvider(ProviderAtTime<String> lineTextProvider)
            throws IllegalArgumentException;

    /**
     * <i>NB: This provider will return the x and y locations (respectively) for where this text
     * line will start its rendering. For left or right aligned text lines, this location will be
     * the left-most or right-most location of text on this line, respectively. For horizontally
     * centered text, this location will specify the center of the text line.</i>
     *
     * @return A provider which specifies the location at which this text line is rendered
     */
    ProviderAtTime<Vertex> getRenderingLocationProvider();

    /**
     * C.f. {@link #getRenderingLocationProvider()} for more information
     *
     * @param renderingLocationProvider The renderingLocationProvider to set for this Renderable
     * @throws IllegalArgumentException If and only if renderingLocationProvider is null
     */
    void setRenderingLocationProvider(ProviderAtTime<Vertex> renderingLocationProvider)
            throws IllegalArgumentException;

    /**
     * @return The height of the line, where the entirety of the window has a height of 1.0.
     */
    ProviderAtTime<Float> lineHeightProvider();

    /**
     * C.f. {@link #lineHeightProvider()} for more information
     *
     * @param lineHeightProvider The height to set for this line
     * @throws IllegalArgumentException If and only if lineHeightProvider is null
     */
    void setLineHeightProvider(ProviderAtTime<Float> lineHeightProvider)
            throws IllegalArgumentException;

    /**
     * @return The amount of padding between glyphs, where 0f implies the standard padding between
     *         glyphs of the font (rather than no space between glyphs whatsoever), and 1f implies
     *         an
     *         additional space between letters equal to {@link #lineHeightProvider}.
     */
    float getPaddingBetweenGlyphs();

    /**
     * C.f. {@link #getPaddingBetweenGlyphs()} for more information
     *
     * @param paddingBetweenGlyphs The padding between glyphs for this line
     */
    void setPaddingBetweenGlyphs(float paddingBetweenGlyphs);

    /**
     * @return The justification of the text line to be rendered (e.g. left, center, or right
     *         horizontal alignment)
     */
    TextJustification getJustification();

    /**
     * @param justification The horizontal justification (i.e. alignment) of this line of text
     * @throws IllegalArgumentException If and only if justification is null or UNKNOWN
     */
    void setJustification(TextJustification justification) throws IllegalArgumentException;

    /**
     * When the Color value provided is null, this corresponds to the default font color
     *
     * @return A map, where the integer keys correspond to the indices in the String (c.f.
     *         {@link #getLineTextProvider}), and the ProviderAtTime values correspond to providers
     *         which provide
     *         the color to draw all subsequent glyphs at a given timestamp. This method may return
     *         null,
     *         in which case, the entire text line is rendered in the default text color.
     */
    Map<Integer, ProviderAtTime<Color>> colorProviderIndices();

    /**
     * <i>NB: It is assumed that indices will be in ascending order; if they are not, the
     * {@link soliloquy.specs.graphics.rendering.renderers.TextLineRenderer} will throw an
     * exception.</i>
     *
     * @return A list of integer keys, corresponding to the indices in the String (c.f.
     *         {@link #getLineTextProvider()}. The first index corresponds to when the text should
     *         begin rendering
     *         as italicized, the second corresponds to when the text should stop rendering as
     *         italicized,
     *         the third when it should resume rendering as italicized, and so-on. This method may
     *         not
     *         return null.
     */
    List<Integer> italicIndices();

    /**
     * <i>NB: It is assumed that indices will be in ascending order; if they are not, the
     * {@link soliloquy.specs.graphics.rendering.renderers.TextLineRenderer} will throw an
     * exception.</i>
     *
     * @return A list of integer keys, corresponding to the indices in the String (c.f.
     *         {@link #getLineTextProvider()}. The first index corresponds to when the text should
     *         begin rendering
     *         as bold, the second corresponds to when the text should stop rendering as bold, the
     *         third
     *         when it should resume rendering as bold, and so-on. This method may not return null.
     */
    List<Integer> boldIndices();

    /**
     * <i>NB: {@link soliloquy.specs.graphics.rendering.renderers.TextLineRenderer#render} will
     * fail if this method produces a value less than 0.0.</i>
     *
     * @return A ProviderAtTime which provides the size of the drop shadow, where the entirety of
     *         the window has a height of 1.0.
     */
    ProviderAtTime<Float> dropShadowSizeProvider();

    /**
     * @param dropShadowSizeProvider The ProviderAtTime for the size of the drop shadow, where the
     *                               entirety of the window has a height of 1.0.
     * @throws IllegalArgumentException If and only if dropShadowSizeProvider is null
     */
    void setDropShadowSizeProvider(ProviderAtTime<Float> dropShadowSizeProvider)
            throws IllegalArgumentException;

    /**
     * @return A ProviderAtTime which provides the offset of the drop shadow, where the two floats
     *         provided are x and y offsets respectively, and entirety of the window has a height of
     *         1.0
     */
    ProviderAtTime<Vertex> dropShadowOffsetProvider();

    /**
     * <i>NB: If {@link #dropShadowSizeProvider} returns a non-null and non-zero value, this
     * ProviderAtTIme cannot return null.</i>
     *
     * @param dropShadowOffsetProvider The ProviderAtTime which provides the offset of the drop
     *                                 shadow, where the two floats provided are x and y offsets
     *                                 respectively, and entirety of the window has a height of 1.0
     * @throws IllegalArgumentException If and only if dropShadowOffsetProvider is null
     */
    void setDropShadowOffsetProvider(ProviderAtTime<Vertex> dropShadowOffsetProvider)
            throws IllegalArgumentException;

    /**
     * <i>NB: If {@link #dropShadowSizeProvider} returns a non-null and non-zero value, this
     * ProviderAtTIme cannot return null.</i>
     *
     * @return A ProviderAtTime which provides the color of the drop shadow.
     */
    ProviderAtTime<Color> dropShadowColorProvider();

    /**
     * @param dropShadowColorProvider The ProviderAtTime for the color of the drop shadow
     * @throws IllegalArgumentException If and only if dropShadowColorProvider is null
     */
    void setDropShadowColorProvider(ProviderAtTime<Color> dropShadowColorProvider)
            throws IllegalArgumentException;
}
