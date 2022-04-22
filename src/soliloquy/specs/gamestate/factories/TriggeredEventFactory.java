package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.gameevents.firings.TriggeredEvent;

/**
 * <b>TriggeredEventFactory</b>
 * <p>
 * This class creates {@link TriggeredEvent}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TriggeredEventFactory extends SoliloquyClass {
    /**
     * @param priority The priority of the TriggeredEvent (c.f. {@link TriggeredEvent#priority()})
     * @param eventAction The action to be fired when this event is triggered
     * @return The created TriggeredEvent
     * @throws IllegalArgumentException If and only if eventAction is null
     */
    TriggeredEvent make(int priority, Runnable eventAction) throws IllegalArgumentException;
}
