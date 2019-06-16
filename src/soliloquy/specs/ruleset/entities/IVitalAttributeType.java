package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.IHasId;
import soliloquy.specs.common.shared.IHasPluralName;

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
public interface IVitalAttributeType extends IResistancesApplyWhenAltered,
	IActOnCharacterOnTurnAndRound, IHasPluralName, IIconForCharacter, IHasId {
}
