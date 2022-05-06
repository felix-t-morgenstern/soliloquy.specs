package soliloquy.specs.gamestate.entities.gameevents;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>TriggeredEvent</b>
 * <p>
 * This represents an event, triggered by something within the game; it is not intended to block
 * the execution of frames, but while it is running, it is expected to block the execution of other
 * TriggeredEvents.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TriggeredEvent extends Runnable, SoliloquyClass {
    /**
     * @return The priority for this TriggeredEvent, with higher value implying higher priority;
     * when multiple TriggeredEvents are fired, events with higher priority are fired first. (If
     * multiple TriggeredEvents have the same priority, no assurances are made as to which will
     * fire first!)
     */
    int priority();

    /**
     * Runs the underlying GameEvent, e.g. a
     * {@link soliloquy.specs.gamestate.entities.gameevents.GameAbilityEvent} or
     * {@link soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent}; it is assumed that
     * this method places a block on saving gamestate via
     * {@link soliloquy.specs.gamestate.infrastructure.GameSaveBlocker#placeTriggeredEventBlock}
     */
    void run();
}
