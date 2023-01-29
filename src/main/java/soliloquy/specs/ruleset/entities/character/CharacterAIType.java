package soliloquy.specs.ruleset.entities.character;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;

/**
 * <b>CharacterAI</b>
 * <p>
 * CharacterAI determines what a Character does when it is their turn to act.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterAIType extends HasId {
    /**
     * @param character The Character whose turn to execute
     * @throws IllegalArgumentException If and only if character is null
     * @throws EntityDeletedException If and only if character has been deleted
     */
    void act(Character character) throws IllegalArgumentException, EntityDeletedException;
}
