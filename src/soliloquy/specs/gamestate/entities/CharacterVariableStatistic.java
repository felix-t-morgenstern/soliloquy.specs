package soliloquy.specs.gamestate.entities;

import soliloquy.specs.ruleset.entities.CharacterVariableStatisticType;

/**
 * <b>CharacterVariableStatistic</b>
 * <p>
 * A variable statistic (e.g. Health), i.e. a statistic with both a fixed (e.g. max) value and a
 * current, variable value, for a specific Character.
 * <p>
 * This class is intended to use an // TODO: Make a IAttributeCalculator class; add link here
 * <p>
 * <i>NB: The "value from modifiers" is the <u>maximum</u> value; e.g., max health. The 
 * currentValue methods would describe the current value, e.g. current health.</i>
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
// NB: This interface does not extend CharacterStaticStatistic, because it should not be able to be
// stored alongside CharacterStaticStatistic, e.g. Character::statistics
public interface CharacterVariableStatistic extends
		CharacterStatistic<CharacterVariableStatisticType> {
	/**
	 * The <i>current</i> value is different from the <i>total</i> value. For instance, if a
	 * character has 40/60 Health, 40 would be the current value, while 60 would be the total
	 * value.
	 * @return The current value of this CharacterVariableStatistic.
	 * @throws IllegalStateException If the Character has been deleted, or if the Character or 
	 * CharacterVariableStatisticType have not been specified
	 */
	int getCurrentValue() throws IllegalStateException;
	
	/**
	 * The <i>current</i> value is different from the <i>total</i> value. For instance, if a
	 * character has 40/60 Health, 40 would be the current value, while 60 would be the total
	 * value.
	 * <p>
	 * <i>This method calls onChange.</i>
	 * @param currentVal - The value to which to set the current value of this
	 * CharacterVariableStatistic
	 * @throws IllegalStateException If the Character has been deleted, or if the Character or 
	 * CharacterVariableStatisticType have not been specified
	 * @throws IllegalArgumentException If your ruleset has restrictions on what the current value
	 * of a CharacterValueAttribute can be, e.g. if you forbid the current value from exceeding the
	 * total value or from falling below zero, then forbidden values should result in this
	 * exception.
	 */
	void setCurrentValue(int currentVal) throws IllegalStateException, IllegalArgumentException;
}
