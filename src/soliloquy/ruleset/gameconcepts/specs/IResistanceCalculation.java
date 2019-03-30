package soliloquy.ruleset.gameconcepts.specs;

import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.gamestate.specs.ICharacter;
import soliloquy.ruleset.gameentities.abilities.specs.IAbilitySource;
import soliloquy.ruleset.gameentities.specs.IElement;
import soliloquy.ruleset.gameentities.specs.IStatusEffectType;
import soliloquy.ruleset.gameentities.specs.IVitalAttributeType;

/**
 * <b>ResistanceCalculation</b>
 * <p>
 * A heuristic for calculating the resistance a Character has to Abilities (or other events) which
 * change that Character's Status Effect or Vital Attribute levels.
 * <p>
 * Intended use case is to search through a Character's various modifiers, and to calculate the 
 * effective change to that Status Effect or Vital Attribute, after those resistances have been
 * calculated.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IResistanceCalculation extends ISoliloquyClass {
	/**
	 * Calculates the effective change to a Status Effect for a specific Character, given the 
	 * following parameters:
	 * @param character - The Character whose resistance to calculate
	 * @param statusEffectType - The type of the Status Effect to be effected
	 * @param baseAmount - The amount by which the Status Effect is to be effected, prior to 
	 * calculating resistance
	 * @param stopAtZero - Whether the Ability intends to stop at zero. For instance, an ability
	 * such as "Dispel Alertness" may attempt to bring Alertness down to no less than zero, even
	 * though that StatusEffectType might permit negative values.
	 * @param element - The Element of this effect. NB: Null values are not permitted; to have a 
	 * "non-elemental" attack, create an element for "non-elemental" (and then perhaps implement 
	 * this interface to ignore resistances for that Element).
	 * @param abilitySource - The AbilitySource of this effect. May be null.
	 * @return The effective change to this Character's Status Effect of the specified type, after
	 * having calculated appropriate resistances.
	 * @throws IllegalStateException If and only if the Character is dead or deleted
	 * @throws IllegalArgumentException If and only if Character is null, StatusEffectType is null,
	 * or element is null
	 */
	int calculateEffectiveChange(ICharacter character, IStatusEffectType statusEffectType, 
			int baseAmount, boolean stopAtZero, IElement element, IAbilitySource abilitySource) 
					throws IllegalStateException, IllegalArgumentException;

	/**
	 * Calculates the effective change to a Status Effect for a specific Character, given the 
	 * following parameters:
	 * @param character - The Character whose resistance to calculate
	 * @param statusEffectType - The type of the Status Effect to be effected
	 * @param baseAmount - The amount by which the Status Effect is to be effected, prior to 
	 * calculating resistance
	 * @param stopAtZero - Whether the Ability intends to stop at zero. (This is unlikely to ever 
	 * be the case for Vital Attributes, but consult the other calculateEffectiveChange method on
	 * this interface for an example of how this patameter behaves.
	 * @param element - The Element of this effect. NB: Null values are not permitted; to have a 
	 * "non-elemental" attack, create an element for "non-elemental" (and then perhaps implement 
	 * this interface to ignore resistances for that Element).
	 * @param abilitySource - The AbilitySource of this effect. May be null.
	 * @return The effective change to this Character's Status Effect of the specified type, after
	 * having calculated appropriate resistances.
	 * @throws IllegalStateException If and only if the Character is dead or deleted
	 * @throws IllegalArgumentException If and only if Character is null, StatusEffectType is null,
	 * or element is null
	 */
	int calculateEffectiveChange(ICharacter character, IVitalAttributeType vitalAttributeType, 
			int baseAmount, boolean stopAtZero, IElement element, IAbilitySource abilitySource) 
					throws IllegalStateException, IllegalArgumentException;
}
