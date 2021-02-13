package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.assets.Font;

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
}
