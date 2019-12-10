package soliloquy.specs.gamestate.entities;

import soliloquy.specs.ruleset.entities.CharacterStaticStatisticType;

/**
 * <b>CharacterStaticStatistic</b>
 * <p>
 * An statistic of a given type for a specific Character. Statistics of this type don't have a
 * maximum value that is different from its current value; statistics of that other type would be
 * things like health, mana, etc.; see {@link CharacterDepletableStatistic} for more information
 * <p>
 * This class is intended to describe Character statistics of all sorts. Some examples:
 * <p>
 * Fundamental characterStatisticTypes of Characters, such as "Strength", "Dexterity", "Luck"
 * <p>
 * Trained skills of Characters, such as "Melee Fighting", "Sword Fighting", "Lockpicking"
 * <p>
 * This {@link CharacterValueFromModifiers} is intended to use an // TODO: Make a IAttributeCalculator class; add link here
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface CharacterStaticStatistic
		extends CharacterStatistic<CharacterStaticStatisticType> {
}
