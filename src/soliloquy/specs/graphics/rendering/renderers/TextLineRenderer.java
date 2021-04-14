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
     * @return The length of the TextLineRenderable, where the width of the window is 1.0f
     * @throws IllegalArgumentException If and only if textLineRenderable is null or has invalid
     * values
     */
    float textLineLength(TextLineRenderable textLineRenderable) throws IllegalArgumentException;
}
