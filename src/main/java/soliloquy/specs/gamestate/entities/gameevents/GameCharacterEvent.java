package soliloquy.specs.gamestate.entities.gameevents;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasPriority;
import soliloquy.specs.gamestate.entities.Character;

public interface GameCharacterEvent extends HasId, HasPriority {
    /**
     * Runs this event for a specific Character
     *
     * @param character The Character for whom to run this event
     * @param params    Parameters associated with the event. Can be null.
     * @return If and only if subsequent GameCharacterEvents are permitted to fire. (E.g., if a
     *         Character has an event on death which causes them to explode, followed by one where
     *         they give a monologue, then the explosion event should return true, so they do not
     *         give a monologue after exploding.)
     * @throws IllegalArgumentException If and only if character is null
     */
    boolean fire(Character character, VariableCache params) throws IllegalArgumentException;
}
