package soliloquy.specs.gamestate.entities;

import soliloquy.specs.ruleset.entities.CharacterStatisticType;

/**
 * <b>CharacterStatistic</b>
 * <p>
 * An statistic of a given type for a specific Character.
 * <p>
 * This class is intended to describe Character statistics of all sorts. Some examples:
 * <p>
 * Fundamental characterStatisticTypes of Characters, such as "Strength", "Dexterity", "Luck"
 * <p>
 * Trained skills of Characters, such as "
 * <p>
 * This {@link CharacterValueFromModifiers} is intended to use an // TODO: Make a IAttributeCalculator class; add link here
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface CharacterStatistic extends CharacterValueFromModifiers {
	/**
	 * @return The type of Attribute whose effective value will be calculated for this Character
	 */
	CharacterStatisticType type();
}
