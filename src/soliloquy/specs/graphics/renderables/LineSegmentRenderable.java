package soliloquy.specs.graphics.renderables;

import java.awt.*;

/**
 * <b>LineSegmentRenderable</b>
 * <p>
 * A line segment which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface LineSegmentRenderable extends RenderableType {
    /**
     * @return The thickness of this line segment
     */
    float thickness();

    /**
     * @return The stippling pattern for this line segment (see documentation for more information
     * about line segment stippling)
     */
    short stipplePattern();

    /**
     * @return The stippling factor for this line segment (see documentation for more information
     * about line segment stippling)
     */
    int stippleFactor();

    /**
     * @return The color of this line segment
     */
    Color color();
}
