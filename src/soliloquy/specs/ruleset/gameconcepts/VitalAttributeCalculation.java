package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.ruleset.entities.ResistancesApplyWhenAltered;
import soliloquy.specs.ruleset.entities.VitalAttributeType;

/**
 * <b>VitalAttributeCalculation</b>
 * <p>
 * This class is used to determine a given VitalAttributeType max value for a given Character, 
 * given the constraints of a particular ruleset.
 * <p>
 * Intended use is by {@link 
 * ResistancesApplyWhenAltered#alterCurrentValue}
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface VitalAttributeCalculation {
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
	Pair<Integer, Map<String,Integer>> calculateVitalAttributeMaxValue(Character character,
                                                                       VitalAttributeType vitalAttributeType)
					throws IllegalArgumentException, IllegalStateException;
}
