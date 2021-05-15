package soliloquy.specs.graphics.rendering;

import soliloquy.specs.gamestate.entities.gameevents.firings.TriggeredEvent;
import soliloquy.specs.gamestate.entities.timers.ClockBasedTimer;

import java.util.function.Consumer;

/**
 * <b>FrameExecutor</b>
 * <p>
 * This class manages the execution of frames, as well as frame-blocking events and
 * {@link TriggeredEvent}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FrameExecutor {
    /**
     * @param triggeredEvent The TriggeredEvent for which to place a block on event firing
     * @throws IllegalArgumentException If and only if triggeredEvent is null
     */
    void placeEventFiringBlock(TriggeredEvent triggeredEvent) throws IllegalArgumentException;

    /**
     * @param triggeredEvent The TriggeredEvent for which
     * @throws IllegalArgumentException If and only if triggeredEvent is null
     */
    void releaseEventFiringBlock(TriggeredEvent triggeredEvent) throws IllegalArgumentException;

    /**
     * @param triggeredEvent The TriggeredEvent to fire if it has the highest priority the next
     *                       time {@link #execute} is called without a block placed on the firing
     *                       of TriggeredEvents
     * @throws IllegalArgumentException If and only if triggeredEvent is null
     */
    void registerTriggeredEventToFire(TriggeredEvent triggeredEvent)
            throws IllegalArgumentException;

    /**
     * <i>(NB: All frame-blocking events are fired parallelly via an internal semaphore, so no
     * frame-blocking events should be capable of generating race conditions.)</i>
     * @param fireFunction The function to be called when this event is fired; the consumed value
     *                     is the global timestamp corresponding to the time of frame execution
     * @throws IllegalArgumentException If and only if fireFunction is null
     */
    void registerFrameBlockingEvent(Consumer<Long> fireFunction) throws IllegalArgumentException;

    /**
     * @param clockBasedTimer The ClockBasedTimer to register
     * @throws IllegalArgumentException If and only if clockBasedTimer is null
     */
    void registerClockBasedTimer(ClockBasedTimer clockBasedTimer) throws IllegalArgumentException;

    /**
     * The workflow of this method is as follows:
     * <p>
     * First, all frame-blocking events (including all {@link ClockBasedTimer}s) are fired in
     * parallel. These are events which are expected to occur (effectively) simultaneously, like
     * the initiation of {@link soliloquy.specs.audio.entities.Sound}s, the placement of
     * {@link soliloquy.specs.graphics.renderables.Renderable}s, or
     * {@link soliloquy.specs.gamestate.entities.TileEntity}s, etc. These events are expected to be
     * extremely brief, on the level of 2 ms in total, though this is not enforced.
     * <p>
     * Second, the first {@link TriggeredEvent} by priority is selected. All TriggeredEvents do not
     * block frame execution. When a TriggeredEvent begins firing, it places a block on the
     * firing of other TriggeredEvents by way of {@link #placeEventFiringBlock}. Any
     * TriggeredEvents fired within that initial TriggeredEvent will also place a block on the
     * firing of further TriggeredEvents. The FrameExecutor will continue to run frames unabated;
     * each time, it will avoid firing any TriggeredEvents, unless there are no TriggeredEvents
     * whose firing has placed a block on the firing of other TriggeredEvents.
     */
    void execute();
}
