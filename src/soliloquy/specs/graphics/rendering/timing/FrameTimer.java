package soliloquy.specs.graphics.rendering.timing;

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
     * <i>NB: If targetFps is null, this implies that there is no target FPS, and therefore the
     * FrameTimer will try to maximize FPS.</i>
     * @param targetFps The target frames per second (FPS); may be null
     * @throws IllegalArgumentException If targetFps is less than or equal to zero
     */
    void setTargetFps(Float targetFps) throws IllegalArgumentException;

    /**
     * Starts the FrameTimer (e.g. begins calculating frames completed per second, being able to
     * report whether to execute the next frame, etc.).
     * <p>
     * <i>NB: This method is both intended to be started on its own thread, and to also start a new
     * thread for tracking information about the current period, i.e. second</i>
     * @throws UnsupportedOperationException If and only if FrameTimer has already been started.
     * (Even if it has been stopped, it cannot be restarted.)
     */
    void start() throws UnsupportedOperationException;

    // TODO: Review implementation and specify use case for this method (i.e. "should only be used when tearing down application")
    /**
     * Stops the FrameTimer
     * @throws UnsupportedOperationException If and only if FrameTimer is not running
     */
    void stop() throws UnsupportedOperationException;

    /**
     * Registers the completion of a frame, contributing to the FPS for the current second interval
     * @throws UnsupportedOperationException If ad only if FrameTimer is not running
     */
    void registerFrameExecution() throws UnsupportedOperationException;

    /**
     * NB: This
     * @return True, if and only if it is the right time for the next frame to be executed
     * @throws UnsupportedOperationException If and only if the FrameTimer has not been started, or
     * if it has been stopped
     */
    boolean shouldExecuteNextFrame() throws UnsupportedOperationException;
}
