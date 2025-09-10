package soliloquy.specs.io.graphics.renderables;

/**
 * <b>RasterizedLineSegmentRenderable</b>
 * <p>
 * A rasterized (i.e. pixelated) line segment which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RasterizedLineSegmentRenderable extends LineSegmentRenderable {

    /**
     * <i>If this method returns null, it implies no stippling</i>
     *
     * @return The stippling pattern for this line segment (cf
     *         {@link <a
     *         href="https://www.dca.ufrn.br/~lmarcos/courses/compgraf/redbook/chapter02
     *         .html">https://www.dca.ufrn.br/~lmarcos/courses/compgraf/redbook/chapter02.html</a>}
     *         for more info)
     */
    Short getStipplePattern();

    /**
     * C.f. {@link #getStipplePattern()} for more information
     *
     * @param stipplePattern The stipple pattern to set for this Renderable; if null, then there
     *                       will be no stippling
     * @throws IllegalArgumentException If and only if stipplePattern is 0
     */
    void setStipplePattern(Short stipplePattern) throws IllegalArgumentException;

    /**
     * @return The stippling factor for this line segment (see documentation for more information
     *         about line segment stippling)
     */
    short getStippleFactor();

    /**
     * C.f. {@link #getStippleFactor()} for more information
     *
     * @param stippleFactor The stipple factor to set for this Renderable
     * @throws IllegalArgumentException If and only if stippleFactor is less than 1 or greater than
     *                                  256
     */
    void setStippleFactor(short stippleFactor) throws IllegalArgumentException;
}
