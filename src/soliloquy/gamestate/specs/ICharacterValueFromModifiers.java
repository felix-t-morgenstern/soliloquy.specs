package soliloquy.gamestate.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>CharacterValueFromModifiers</b>
 * <p>
 * Describes a CharacterValue (e.g. an Attribute, like Wisdom), whose ultimate value is the sum of
 * various modifiers
 * <p>
 * Such modifiers include "Base value", "Amount trained", "Bonuses from items", "Bonuses from other
 * base and trained Attributes", etc.
 * <p>
 * Intended use is for 
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterValueFromModifiers extends IDeletable {
	/**
	 * This is intended to identify the Character whose value is being described.
	 * @return The Id of the Character whose value is being described
	 * @throws IllegalStateException If the Character has been deleted
	 */
	ICharacter character() throws IllegalStateException;
	
	/**
	 * @return The total value, resulting from all modifiers
	 * @throws IllegalStateException If the Character has been deleted
	 */
	int totalValue() throws IllegalStateException;
	
	/**
	 * @return A Map, where each key is the name of a modifier (e.g. "FromBase", "FromItems", 
	 * etc.), and each value is the value from that modifier contributing to the total value.
	 * @throws IllegalStateException If the Character has been deleted
	 */
	IMap<String,Integer> modifiers() throws IllegalStateException;
	
	/**
	 * Calculates the value of this CharacterValueFromModifiers (using a calculator from the 
	 * Ruleset module, e.g. an implementation of {@link 
	 * soliloquy.ruleset.gameconcepts.specs.IVitalAttributeCalculation})
	 * @throws IllegalStateException If the Character has been deleted
	 */
	void calculateValue() throws IllegalStateException;
}
