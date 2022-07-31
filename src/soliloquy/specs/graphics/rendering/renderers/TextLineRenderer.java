package soliloquy.specs.graphics.rendering.renderers;

import soliloquy.specs.graphics.renderables.TextLineRenderable;

/**
 * <b>TextLineRenderer</b>
 * <p>
 * A renderer for {@link TextLineRenderable}s, which also has the capacity to calculate the length
 * of a TextLineRenderable, which is of use to the UI (e.g. for centering text)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface TextLineRenderer extends Renderer<TextLineRenderable> {
    /**
     * @param textLineRenderable The TextLineRenderable whose length to calculate
     * @param timestamp The timestamp for which the textLineLength is to be evaluated
     * @return The length of the TextLineRenderable, where the width of the window is 1.0f
     * @throws IllegalArgumentException If and only if textLineRenderable is null or has invalid
     * values, or if timestamp is before most recent timestamp provided to class (c.f.
     * {@link soliloquy.specs.graphics.shared.HasMostRecentTimestamp})
     */
    float textLineLength(TextLineRenderable textLineRenderable, long timestamp)
            throws IllegalArgumentException;
}
