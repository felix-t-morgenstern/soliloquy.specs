package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.valueobjects.IMap;
import soliloquy.specs.common.valueobjects.IPair;
import soliloquy.specs.gamestate.entities.ICharacter;
import soliloquy.specs.ruleset.entities.IResistancesApplyWhenAltered;
import soliloquy.specs.ruleset.entities.IVitalAttributeType;

/**
 * <b>VitalAttributeCalculation</b>
 * <p>
 * This class is used to determine a given VitalAttributeType max value for a given Character, 
 * given the constraints of a particular ruleset.
 * <p>
 * Intended use is by {@link 
 * IResistancesApplyWhenAltered#alterCurrentValue}
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IVitalAttributeCalculation {
	/**
	 * This method calculates both the total max Vital Attribute value for a Character, as well as 
	 * a Map of various modifier types with the respective integer adjustments
	 * @param character - The Character whose Vital Attribute max value to calculate
	 * @param vitalAttributeType - The VitalAttributeType to calculate for the Character
	 * @return A Pair, whose first entry is the ultimate value of the VitalAttributeType for the 
	 * Character, and whose second entry is the collection of modifier types (e.g. 
	 * "FromBaseAttributes", "FromItems", etc.)
	 * @throws IllegalArgumentException - If and only if character or vitalAttributeType are null
	 * @throws IllegalStateException - If and only if character is deleted
	 */
	IPair<Integer, IMap<String,Integer>> calculateVitalAttributeMaxValue(ICharacter character,
                                                                         IVitalAttributeType vitalAttributeType)
					throws IllegalArgumentException, IllegalStateException;
}
