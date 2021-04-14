package soliloquy.specs.graphics.rendering.timing;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>GlobalClock</b>
 * <p>
 * This class tracks the milliseconds, e.g. in UTC milliseconds. This clock is to be used by both
 * the {@link FrameTimer}, as well as by the
 * {@link soliloquy.specs.graphics.rendering.renderers.Renderer} for
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
     * @return The current global timestamp, e.g. in UTC milliseconds
     * @throws UnsupportedOperationException If and only if the GlobalClock has not yet been
     * started
     */
    long globalTimestamp() throws UnsupportedOperationException;
}
