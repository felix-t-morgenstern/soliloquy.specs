package soliloquy.gamestate.specs;

import soliloquy.ruleset.gameentities.specs.IElement;
import soliloquy.ruleset.gameentities.specs.IVitalAttribute;

// NB: The ValueFromModifiers refers to MAX value
public interface ICharacterVitalAttribute extends ICharacterValueFromModifiers {
	/**
	 * @return The type of this CharacterVitalAttribute
	 * @throws IllegalStateException if no VitalAttribute is defined
	 */
	IVitalAttribute vitalAttributeType() throws IllegalStateException;
	
	/**
	 * The <i>current</i> value is different from the <i>total</i> value. If a character has 40/60 Health, 40 would be the current value, while 60 would be the total value.
	 * @return The current value of this CharacterVitalAttribute.
	 * @throws IllegalStateException If character is null, or character has been deleted, or character is dead
	 */
	int getCurrentValue() throws IllegalStateException;
	
	/**
	 * The <i>current</i> value is different from the <i>total</i> value. If a character has 40/60 Health, 40 would be the current value, while 60 would be the total value.
	 * <p>
	 * <i>This method calls onChange.</i>
	 * @param currentVal - The value to which to set the current value of this CharacterVitalAttribute
	 * @throws IllegalStateException If character is null, or character has been deleted, or character is dead
	 * @throws IllegalArgumentException If your ruleset has restrictions on what the current value of a CharacterValueAttribute can be, e.g. if you forbid the current value from exceeding the total value or from falling below zero, then forbidden values should result in this exception.
	 */
	void setCurrentValue(int currentVal) throws IllegalStateException, IllegalArgumentException;
	
	/**
	 * This is used for altering the value of a CharacterVitalAttribute as part of an ability, e.g. doing damage to a Character, draining their mana, etc.
	 * <p>
	 * <i>Intended usage is to call {@code vitalAttributeType().alterCurrentValue}</i>
	 * <p>
	 * This is also where to specify behavior when this CharacterVitalAttribute of that Character is altered; e.g., when their Health is altered so that it is zero or less, they should be killed
	 * @param baseAmount - The base amount by which to alter this current value (e.g. the incoming fire damage, before it is adjusted by fire resistance)
	 * @param elementType - The Element of this incoming alteration (e.g. Fire for fire damage)
	 * @throws IllegalStateException If character is null, or character has been deleted, or character is dead
	 * @throws IllegalArgumentException If elementType is null
	 */
	void alterCurrentValue(int baseAmount, IElement elementType) throws IllegalStateException, IllegalArgumentException;
}
