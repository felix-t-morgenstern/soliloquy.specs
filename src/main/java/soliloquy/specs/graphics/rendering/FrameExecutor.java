package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.timers.ClockBasedTimer;

import java.util.function.Consumer;

/**
 * <b>FrameExecutor</b>
 * <p>
 * This class manages the execution of frames, as well as frame-blocking events.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FrameExecutor extends SoliloquyClass {
    /**
     * <i>(NB: All frame-blocking events are fired parallelly via an internal semaphore, so no
     * frame-blocking events should be capable of generating race conditions.)</i>
     *
     * @param fireFunction The function to be called when this event is fired; the consumed value
     *                     is the global timestamp corresponding to the time of frame execution
     * @throws IllegalArgumentException If and only if fireFunction is null
     */
    void registerFrameBlockingEvent(Consumer<Long> fireFunction) throws IllegalArgumentException;

    /**
     * The workflow of this method is as follows:
     * <p>
     * First, all frame-blocking events (including all {@link ClockBasedTimer}s provided to
     * {@link #registerFrameBlockingEvent} via
     * {@link soliloquy.specs.gamestate.entities.timers.ClockBasedTimerManager}) are fired in
     * parallel. These are events which are expected to occur (effectively) simultaneously, like
     * the initiation of {@link soliloquy.specs.audio.entities.Sound}s, the placement of
     * {@link soliloquy.specs.graphics.renderables.Renderable}s or
     * {@link soliloquy.specs.gamestate.entities.TileEntity}s, etc. These events are expected to be
     * extremely brief, on the level of 2-5 ms in total, though this is not enforced.
     * <p>
     * Then, FrameExecutor calls
     * {@link soliloquy.specs.graphics.rendering.renderers.StackRenderer#render} <i>at the current
     * time after the firing of all frame-blocking events.</i> The reasoning here is that
     * frame-blocking events do genuinely block frame rendering; therefore, even if events take
     * 12ms to fire, the FrameExecutor will be sure to render the {@link RenderableStack} only
     * after those 12ms, to ensure that animations etc are not staggered or stilted by those
     * frame-blocking events.
     */
    void execute();
}
