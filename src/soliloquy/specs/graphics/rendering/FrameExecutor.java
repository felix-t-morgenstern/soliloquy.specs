package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>FrameExecutor</b>
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
public interface FrameExecutor extends SoliloquyClass {
    /**
     * @param ms The milliseconds between intervals in which the FrameExecutor determines whether
     *           to render the next frame
     * @throws IllegalArgumentException If ms is less than or equal to zero
     */
    void setPollingInterval(int ms) throws IllegalArgumentException;

    /**
     * @param targetFps The target frames per second (FPS)
     * @throws IllegalArgumentException If ms is less than or equal to zero
     */
    void setTargetFps(int targetFps) throws IllegalArgumentException;
}
