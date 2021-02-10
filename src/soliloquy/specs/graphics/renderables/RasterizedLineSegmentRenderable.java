package soliloquy.specs.graphics.renderables;

/**
 * <b>RasterizedLineSegmentRenderable</b>
 * <p>
 * A rasterized (i.e. pixelated) line segment which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RasterizedLineSegmentRenderable extends Renderable {
    /**
     * @return The thickness of this line segment, <i>in rasterized pixels</i>
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

    // TODO: java.awt.Color was giving some issues; look into this
    /**
     * @return The red channel of this line segment, from 0.0 - 1.0
     */
    float red();

    /**
     * @return The green channel of this line segment, from 0.0 - 1.0
     */
    float green();

    /**
     * @return The blue channel of this line segment, from 0.0 - 1.0
     */
    float blue();

    /**
     * @return The alpha channel of this line segment, from 0.0 - 1.0
     */
    float alpha();
}
