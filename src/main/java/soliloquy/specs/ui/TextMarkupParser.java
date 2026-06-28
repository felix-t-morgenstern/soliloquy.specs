package soliloquy.specs.ui;

import soliloquy.specs.io.graphics.assets.Font;
import soliloquy.specs.io.graphics.renderables.TextLineRenderable;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.content.TextLineRenderableDefinition;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <b><u>For more information on text markup and how it will be parsed, see the
 * documentation.</u></b>
 */
public interface TextMarkupParser {
    /**
     * If rawText is null or empty, this method will still return a non-null value
     *
     * @param rawText The provided text, with potential formatting markup
     * @return The line of the formatted text, with formatting options, to be provided e.g. to
     *         {@link soliloquy.specs.io.graphics.renderables.factories.TextLineRenderableFactory}
     *         or {@link TextLineRenderableDefinition}
     * @throws IllegalArgumentException If and only if timestamp is invalid
     */
    LineFormatting formatSingleLine(String rawText, UUID containingComponentUuid, long timestamp)
            throws IllegalArgumentException;

    /**
     * Every entry in the array will have non-null values for each value. If rawText is null, the
     * array will still have one LineFormatting object, with no text or formatting options.
     *
     * @param rawText                 The provided text, with potential formatting markup
     * @param font                    The font in which the text will be rendered
     * @param paddingBetweenGlyphs    The space between glyphs, where 1f implies lineHeight, c.f.
     *                                {@link TextLineRenderable#getPaddingBetweenGlyphs()}
     * @param lineHeight              The height at which the text will be rendered, c.f.
     *                                {@link TextLineRenderable#lineHeightProvider()}
     * @param maxLength               The maximum length of the text lines, expressed in percentage
     *                                of screen width
     * @param containingComponentUuid If the formatted text will be part of a larger
     *                                {@link soliloquy.specs.io.graphics.renderables.Component}, the
     *                                MarkupParser can use its UUID to find custom color providers.
     *                                (Again, see the docs for more info.)
     * @return The lines of the formatted text, with formatting options, to be provided e.g. to
     *         {@link soliloquy.specs.io.graphics.renderables.factories.TextLineRenderableFactory}
     *         or {@link TextLineRenderableDefinition}
     * @throws IllegalArgumentException If and only if maxLength is less than or equal to 0, or
     *                                  timestamp is invalid
     */
    LineFormatting[] formatMultiline(String rawText,
                                     Font font,
                                     float paddingBetweenGlyphs,
                                     float lineHeight,
                                     float maxLength,
                                     UUID containingComponentUuid,
                                     long timestamp) throws IllegalArgumentException;

    /**
     * This allows for custom color names in markup tags, e.g.:
     * <p>
     * [color=burgundy]
     *
     * @param name  The name of the color preset to add (capitalization is ignored)
     * @param color The color of the color preset to add
     * @throws IllegalArgumentException If and only if name is null or empty, or if color is null
     */
    void addColorPreset(String name, Color color) throws IllegalArgumentException;

    /**
     * @param text          The text of the formatted line, stripped of markup
     * @param colorIndices  The indices at which certain colors are rendered (c.f.
     *                      {@link TextLineRenderable#colorProviderIndices()})
     * @param italicIndices The indices at which italicization begins and ends (c.f.
     *                      {@link TextLineRenderable#italicIndices()})
     * @param boldIndices   The indices at which boldface begins and ends (c.f.
     *                      {@link TextLineRenderable#boldIndices()})
     */
    record LineFormatting(
            String text,
            Map<Integer, ProviderAtTime<Color>> colorIndices,
            List<Integer> italicIndices,
            List<Integer> boldIndices,
            List<MouseEventSpan> mouseEventSpans
    ) {
        record MouseEventSpan(
                UUID uuid,
                String name,
                float lineStartPosition,
                float lineEndPosition,
                Map<String, String> tagData
        ) {

        }
    }
}
