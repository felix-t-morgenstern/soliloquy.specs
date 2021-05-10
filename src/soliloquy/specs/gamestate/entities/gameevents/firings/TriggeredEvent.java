package soliloquy.specs.gamestate.entities.gameevents.firings;

import soliloquy.specs.common.shared.HasUuid;
import soliloquy.specs.common.shared.SoliloquyClass;

// TODO: Draft class summary
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
