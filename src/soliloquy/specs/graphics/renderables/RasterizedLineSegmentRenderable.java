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
public interface RasterizedLineSegmentRenderable extends LineSegmentRenderable {

    /**
     * @return The stippling pattern for this line segment (see documentation for more information
     * about line segment stippling)
     */
    short getStipplePattern();

    /**
     * C.f. {@link #getStipplePattern()} for more information
     * @param stipplePattern The stipple pattern to set for this Renderable
     * @throws IllegalArgumentException If and only if stipplePattern is 0
     */
    void setStipplePattern(short stipplePattern) throws IllegalArgumentException;

    /**
     * @return The stippling factor for this line segment (see documentation for more information
     * about line segment stippling)
     */
    short getStippleFactor();

    /**
     * C.f. {@link #getStippleFactor()} for more information
     * @param stippleFactor The stipple factor to set for this Renderable
     * @throws IllegalArgumentException If and only if stippleFactor is less than 1 or greater than
     * 256
     */
    void setStippleFactor(short stippleFactor) throws IllegalArgumentException;
}
