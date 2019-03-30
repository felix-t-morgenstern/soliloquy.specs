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
	int calculateEffectiveChange(ICharacter character, IStatusEffectType statusEffectType, 
			int baseAmount, boolean stopAtZero, IElement element, IAbilitySource abilitySource) 
					throws IllegalStateException, IllegalArgumentException;
	
	int calculateEffectiveChange(ICharacter character, IVitalAttributeType vitalAttributeType, 
			int baseAmount, boolean stopAtZero, IElement element, IAbilitySource abilitySource) 
					throws IllegalStateException, IllegalArgumentException;
}
