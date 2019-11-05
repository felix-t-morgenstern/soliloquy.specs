package soliloquy.specs.gamestate.entities.gameevents;

import soliloquy.specs.common.shared.HasGlobalAccess;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.gamestate.entities.Character;

public interface GameCharacterEvent extends HasId, HasGlobalAccess {
    /**
     * Runs this event for a specific Character
     * @param character - The Character for whom to run this event
     * @return If and only if subsequent GameCharacterEvents are permitted to fire. (E.g., if a
     * Character has an event on death which causes them to explode, followed by one where they
     * give a monologue, then the explosion event should return true, so they do not give a
     * monologue after exploding.)
     * @throws IllegalArgumentException If and only if character is null
     */
    Boolean fire(Character character) throws IllegalArgumentException;
}
