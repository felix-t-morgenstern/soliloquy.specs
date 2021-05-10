package soliloquy.specs.graphics.rendering;

import soliloquy.specs.gamestate.entities.gameevents.firings.FrameBlockingEvent;
import soliloquy.specs.gamestate.entities.gameevents.firings.TriggeredEvent;

public interface FrameExecutor {
    void placeEventFiringBlock(TriggeredEvent triggeredEvent) throws IllegalArgumentException;

    void releaseEventFiringBlock(TriggeredEvent triggeredEvent) throws IllegalArgumentException;

    void registerTriggeredEvent(TriggeredEvent triggeredEvent) throws IllegalArgumentException;

    void registerFrameBlockingEvent(FrameBlockingEvent frameBlockingEvent)
            throws IllegalArgumentException;

    /**
     * First, this method looks for any TriggeredEvents and TimedEvents registered to fire, and
     * fires them in order of priority. Each event, and all of its children, must finish firing
     * before any other registered events are fired. If a fired event blocks frame execution, then
     * the current frame's firing is delayed until the completion of that event blocking frame
     * execution. <i>(It is expected that any events which block frame execution will be very
     * brief, like adding in an animation or changing a
     * {@link soliloquy.specs.gamestate.entities.TileEntity}.)</i>
     */
    void execute();
}
