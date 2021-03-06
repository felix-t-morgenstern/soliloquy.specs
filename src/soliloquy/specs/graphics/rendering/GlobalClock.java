package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>GlobalClock</b>
 * <p>
 * This class tracks the milliseconds since the graphics engine completed startup and began running
 * the {@link soliloquy.specs.game.Game}. This clock is to be used by both the
 * {@link FrameTimer}, as well as by the {@link Renderer} for
 * {@link soliloquy.specs.graphics.assets.Animation}s. (It is expected that the Animation renderer
 * will manage the relationship between the GlobalClock and the current frame of all Animations,
 * both during and after any pauses for those specific Animations.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface GlobalClock extends SoliloquyClass {
    /**
     * Starts up the global clock; calling this method assumes that the graphics engine has
     * completed initialization, and the time at which this method is called is a timestamp of 0mS.
     * @throws UnsupportedOperationException If and only if the GlobalClock has already been
     * started
     */
    void start() throws UnsupportedOperationException;

    /**
     * @return The current global timestamp, i.e., the milliseconds since the graphics engine
     * completed initialization
     * @throws UnsupportedOperationException If and only if the GlobalClock has not yet been
     * started
     */
    long globalTimestamp() throws UnsupportedOperationException;
}
