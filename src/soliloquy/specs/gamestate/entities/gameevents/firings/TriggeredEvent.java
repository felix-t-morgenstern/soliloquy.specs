package soliloquy.specs.gamestate.entities.gameevents.firings;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>TriggeredEvent</b>
 * <p>
 * This represents an event, triggered by something within the game; it is not intended to block
 * the execution of frames, but is expected to block the execution of other TriggeredEvents; c.f.
 * {@link soliloquy.specs.graphics.rendering.FrameExecutor#execute} for more details.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TriggeredEvent extends SoliloquyClass {
    /**
     * @return The priority for this firing
     */
    int priority();

    /**
     * Fires the underlying GameEvent, e.g. a
     * {@link soliloquy.specs.gamestate.entities.gameevents.GameAbilityEvent} or
     * {@link soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent}; it is assumed that
     * this method places a block on saving gamestate via
     * {@link soliloquy.specs.gamestate.infrastructure.GameSaveBlocker#placeTriggeredEventBlock}
     */
    void fire();
}
