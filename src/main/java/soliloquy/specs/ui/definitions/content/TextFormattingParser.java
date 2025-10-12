package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.io.graphics.renderables.TextLineRenderable;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface TextFormattingParser {
    LineFormatting formatSingleLine(String text, float maxLength);

    /**
     * Every entry in the array will have non-null values for each value. If text is null, the array
     * will still have one LineFormatting object, with no text or formatting options.
     *
     * @param text      The provided text, with potential formatting markup
     * @param maxLength The maximum length of the text line, expressed in percentage of screen width
     * @return The lines of the formatted text, with formatting options ready to be provided to
     *         {@link soliloquy.specs.io.graphics.renderables.factories.TextLineRenderableFactory}
     * @throws IllegalArgumentException If and only if maxLength is less than or equal to 0
     */
    LineFormatting[] formatMultiline(String text, float maxLength) throws IllegalArgumentException;

    /**
     * This allows for custom color names in markup tags, e.g.:
     * <p>
     * [color=burgundy]
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
            List<Integer> boldIndices
    ) {
    }
}
