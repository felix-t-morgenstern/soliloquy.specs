package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasPluralName;

/**
 * <b>VitalAttribute</b>
 * <p>
 * It has a name, a pluralized name, and an Id.
 * <p>
 * It has Actions, which can be performed on each Character, at the start and end of their turn,
 * and the start and end of the round.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface VitalAttributeType extends ResistancesApplyWhenAltered,
        ActOnCharacterOnTurnAndRound, HasPluralName, IconForCharacter, HasId {
}
