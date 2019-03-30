package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IHasPluralName;
import soliloquy.gamestate.specs.ICharacter;

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
public interface IVitalAttributeType extends IActOnCharacterOnTurnAndRound, IHasPluralName, IIconForCharacter, IGameEntity {
	/**
	 * This is used for altering the value of a Character's CharacterVitalAttribute as part of an
	 * ability, e.g. doing damage to a Character, draining their mana, etc.
	 * <p>
	 * This is also where to specify behavior when their CharacterVitalAttribute of theirs is
	 * altered; e.g., when their Health is altered so that it is zero or less, they should be
	 * killed
	 * @param character - The Character for whom this VitalAttribute will be altered
	 * @param baseAmount - The base amount by which to alter this current value (e.g. the incoming
	 * fire damage, before it is adjusted by fire resistance)
	 * @param elementType - The Element of this incoming alteration (e.g. Fire for fire damage)
	 * @throws IllegalArgumentException If elementType is null, character is null, character is
	 * deleted, or character is dead
	 */
	void alterCurrentValue(ICharacter character, int baseAmount, IElement elementType) throws IllegalArgumentException;
}
