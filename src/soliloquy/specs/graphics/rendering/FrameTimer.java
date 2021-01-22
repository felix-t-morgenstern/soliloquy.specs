package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>FrameTimer</b>
 * <p>
 * An object which will periodically determine whether the next frame is to be rendered.
 * <p>
 * If the game cannot render the target FPS, it will throttle FPS, gradually ramping it back up, if
 * it appears viable.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface FrameTimer extends SoliloquyClass {
    /**
     * @return The milliseconds between intervals in which the FrameTimer determines whether to
     * render the next frame
     */
    int getPollingInterval();

    /**
     * <i>NB: This does not guarantee that the FrameTimer will be asked every ms milliseconds
     * whether a new frame should be rendered; instead, it guarantees a <b>delay</b> of ms
     * milliseconds between either the end of rendering a frame, or determining that a frame
     * needn't be rendered yet, and the next time the FrameTimer will be asked again whether the
     * next frame will be rendered. Think about it as a <u>delay</u>.</i>
     * @param ms The milliseconds between the end of rendering the most recent frame, or when the
     *           FrameTimer stated that the next frame should not be rendered yet, and the next
     *           time {@link soliloquy.specs.graphics.bootstrap.GraphicsCoreLoop} should ask the
     *           FrameTimer again whether to render the next frame.
     * @throws IllegalArgumentException If ms is less than or equal to zero
     */
    void setPollingInterval(int ms) throws IllegalArgumentException;

    /**
     * @param targetFps The target frames per second (FPS)
     * @throws IllegalArgumentException If ms is less than or equal to zero
     */
    void setTargetFps(int targetFps) throws IllegalArgumentException;

    /**
     * NB: This
     * @return True, if and only if it is the right time for the next frame to be executed
     */
    boolean shouldExecuteNextFrame();
}
