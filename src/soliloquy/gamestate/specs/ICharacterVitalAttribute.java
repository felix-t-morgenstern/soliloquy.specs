package soliloquy.gamestate.specs;

import soliloquy.ruleset.gameentities.specs.IVitalAttributeType;

/**
 * <b>CharacterAttribute</b>
 * <p>
 * An Attribute, for a specific Character.
 * <p>
 * This Attribute is intended for base Character stats/abilities, but not skills; e.g. Strength or 
 * Intimidate, but not Magic Missile. (Ability with Magic Missile would, instead, be a {@link 
 * ICharacterAptitude}.)
 * <p>
 * This {@link ICharacterValueFromModifiers} is intended to use an // TODO: Make a IAttributeCalculator class; add link here
 * <p>
 * <i>NB: The "value from modifiers" is the <u>maximum</u> value; e.g., max health. The 
 * currentValue methods would describe the current value, e.g. current health.</i>
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterVitalAttribute extends ICharacterValueFromModifiers {
	/**
	 * @return The type of this CharacterVitalAttribute
	 * @throws IllegalStateException If the Character has been deleted
	 */
	IVitalAttributeType vitalAttributeType() throws IllegalStateException;
	
	/**
	 * The <i>current</i> value is different from the <i>total</i> value. For instance, if a
	 * character has 40/60 Health, 40 would be the current value, while 60 would be the total
	 * value.
	 * @return The current value of this CharacterVitalAttribute.
	 * @throws IllegalStateException If the Character has been deleted, or if the Character or 
	 * VitalAttributeType have not been specified
	 */
	int getCurrentValue() throws IllegalStateException;
	
	/**
	 * The <i>current</i> value is different from the <i>total</i> value. For instance, if a
	 * character has 40/60 Health, 40 would be the current value, while 60 would be the total
	 * value.
	 * <p>
	 * <i>This method calls onChange.</i>
	 * @param currentVal - The value to which to set the current value of this
	 * CharacterVitalAttribute
	 * @throws IllegalStateException If the Character has been deleted, or if the Character or 
	 * VitalAttributeType have not been specified
	 * @throws IllegalArgumentException If your ruleset has restrictions on what the current value
	 * of a CharacterValueAttribute can be, e.g. if you forbid the current value from exceeding the
	 * total value or from falling below zero, then forbidden values should result in this
	 * exception.
	 */
	void setCurrentValue(int currentVal) throws IllegalStateException, IllegalArgumentException;
}
