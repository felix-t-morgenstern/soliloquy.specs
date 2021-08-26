package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasPluralName;

/**
 * <b>CharacterVariableStatisticType</b>
 * <p>
 * It has a name, a pluralized name, a way to obtain icons for Characters (e.g. for status
 * indicators on a {@link soliloquy.specs.gamestate.entities.Party} member's portrait), and an Id.
 * <p>
 * It has behaviors which can be performed on each Character at the start or end of their turn or
 * the round, e.g. regeneration, taking damage from poison, spilling blood on the ground, etc.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface CharacterVariableStatisticType extends CharacterStatisticType,
        ActOnCharacterOnTurnAndRound, HasPluralName,
        IconForCharacter<CharacterVariableStatisticType> {
}
