package soliloquy.specs.ruleset.entities.character;

import soliloquy.specs.common.shared.HasPluralName;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.ruleset.entities.IconForCharacter;

/**
 * <b>VariableStatisticType</b>
 * <p>
 * It has a name, a pluralized name, a way to obtain icons for Characters (e.g. for status
 * indicators on a {@link soliloquy.specs.gamestate.entities.Party} member's portrait), and an Id.
 * <p>
 * It has behaviors which can be performed on each Character at the start or end of their turn or
 * the round, e.g. regeneration, taking damage from poison, spilling blood on the ground, etc.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface VariableStatisticType
        extends StatisticType, HasPluralName, IconForCharacter {
    /**
     * This function is to be used after incoming changes have been moderated by
     * {@link soliloquy.specs.ruleset.gameconcepts.VariableStatisticLossResistanceCalculation}, if
     * applicable.
     *
     * @param character The character whose current value to alter
     * @param amount    The amount by which to alter the current value
     * @throws IllegalArgumentException If and only if character is null
     * @throws EntityDeletedException   If and only if character is deleted
     */
    void alter(Character character, int amount)
            throws IllegalArgumentException, EntityDeletedException;
}
