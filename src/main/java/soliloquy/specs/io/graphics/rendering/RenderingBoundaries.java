package soliloquy.specs.io.graphics.rendering;

import soliloquy.specs.common.valueobjects.FloatBox;

/**
 * <b>RenderingBoundaries</b>
 * <p>
 * This class specifies the boundaries in the window in which
 * {@link soliloquy.specs.io.graphics.renderables.Renderable}s can render. When a Renderable is
 * defined partly outside of the RenderingBoundaries, it is clipped to fit within the boundaries.
 * <p>
 * This class acts like a
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RenderingBoundaries {
    /**
     * <i>NB: If there is no place in the window within which rendering can take place, this method
     * returns null.</i>
     *
     * @return The current rendering boundaries; can be null
     */
    FloatBox currentBoundaries();

    /**
     * This method defines a new set of boundaries <i>within the existing boundaries</i>.
     * Therefore, the new boundaries (i.e. what will be returned by {@link #currentBoundaries}
     * after this method has finished executing) will always be a rectangular subset of the current
     * boundaries.
     * <p>
     * <i>If box is null, that implies that there will then be no valid rendering area.</i>
     *
     * @param box The rendering boundaries to add.
     */
    void pushNewBoundaries(FloatBox box);

    /**
     * This method will remove the most recently added boundary box; all other boundary boxes on
     * this stack will remain.
     */
    void popMostRecentBoundaries();

    /**
     * This method will clear the stack of rendering boundaries, and set the current boundaries
     * back to the whole window (i.e. [-1.0,1.0]).
     */
    void clearAllBoundaries();
}
