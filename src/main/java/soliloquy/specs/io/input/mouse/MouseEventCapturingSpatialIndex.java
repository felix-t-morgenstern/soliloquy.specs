package soliloquy.specs.io.input.mouse;

import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.io.graphics.renderables.RenderableWithMouseEvents;
import soliloquy.specs.common.valueobjects.FloatBox;

/**
 * <b>MouseEventCapturingSpatialIndex</b>
 * <p>
 * This class is used to store spatial information about the
 * {@link soliloquy.specs.io.graphics.renderables.Renderable}s currently on the screen which capture
 * mouse events. On each frame, whether or not the user has clicked, this class determines which
 * (if any) Renderable will capture any mouse events at the cursor's current location.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface MouseEventCapturingSpatialIndex {
    /**
     * @param location  The location in the window, with x and y values ranging from 0.0 to 1.0, to
     *                  check for a Renderable which captures mouse events
     * @param timestamp The timestamp at which to determine the capturing Renderable at the
     *                  specified point
     * @return The RenderableWithArea capturing mouse events at that particular location; if no
     *         Renderable is capturing events, this method returns null
     * @throws IllegalArgumentException If and only if location is null or outside the range of
     *                                  [0.0,1.0], or if timestamp is before the most recent
     *                                  timestamp provided to class
     */
    RenderableWithMouseEvents getCapturingRenderableAtPoint(Vertex location, long timestamp)
            throws IllegalArgumentException;

    /**
     * @param renderable The Renderable to place in this index
     * @throws IllegalArgumentException If and only if renderable is null
     */
    void putRenderable(RenderableWithMouseEvents renderable)
            throws IllegalArgumentException;

    /**
     * @param renderable The Renderable to remove from this index
     * @throws IllegalArgumentException If and only if renderable is null
     */
    void removeRenderable(RenderableWithMouseEvents renderable) throws IllegalArgumentException;
}
