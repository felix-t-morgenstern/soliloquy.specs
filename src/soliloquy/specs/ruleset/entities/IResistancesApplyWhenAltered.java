package soliloquy.specs.ruleset.entities;

import soliloquy.specs.gamestate.entities.ICharacter;
import soliloquy.specs.ruleset.entities.abilities.IAbilitySource;

/**
 * <b>ResistancesApplyWhenAltered</b>
 * <p>
 * This is for rapidly changing values, i.e. Status Effects and Vital Attributes; attempts to alter
 * these values (i.e. throwing a fireball at or attempting to poison a Character) are subject to 
 * that Character's resistance(s) to those incoming sources of harm (or possibly benefit).
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IResistancesApplyWhenAltered {
	/**
	 * This is used for altering the value of a Character's current value as part of an ability, 
	 * e.g. doing damage to a Character, draining their mana, etc.
	 * <p>
	 * This is also where to specify behavior when the current value of this type is altered; e.g.,
	 * when their Health is altered so that it is zero or less, they should be
	 * killed
	 * @param character - The Character for whom this value will be altered
	 * @param baseAmount - The base amount by which to alter this current value (e.g. the incoming
	 * fire damage, before it is adjusted by fire resistance)
	 * @param stopAtZero - True, if and only if any negative alterations should not go below zero,
	 * or if any positive alterations should not go above zero. For instance, you might have a 
	 * Ruleset where only negative health kills a Character. In that case, setting stopAtZero to 
	 * true implies that the Ability will never kill the Character in question.
	 * @param elementType - The Element of this incoming alteration (e.g. Fire for fire damage)
	 * @param abilitySource - A description of the source of the Ability, e.g. in case a Character 
	 * has specific resistances to specific Abilities, or Abilities used by a certain monster type.
	 * Can be null, in the case of effects without any associated Ability (e.g. a hazard found in 
	 * nature).
	 * @throws IllegalArgumentException If elementType is null, character is null, character is
	 * deleted, or character is dead
	 */
	void alterCurrentValue(ICharacter character, int baseAmount, boolean stopAtZero, IElement element,
			IAbilitySource abilitySource) throws IllegalArgumentException;
}
