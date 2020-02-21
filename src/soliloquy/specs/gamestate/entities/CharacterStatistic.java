package soliloquy.specs.gamestate.entities;

import soliloquy.specs.ruleset.entities.CharacterStatisticType;

/**
 * <b>CharacterStatistic</b>
 * <p>
 * A given {@link Character}'s statistic of a specified type (i.e.
 * {@link soliloquy.specs.ruleset.entities.CharacterVariableStatisticType} or
 * {@link soliloquy.specs.ruleset.entities.CharacterStaticStatisticType}).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <TStatType> The type (e.g. variable or static) of this statistic
 */
public interface CharacterStatistic<TStatType extends CharacterStatisticType>
        extends CharacterEntityOfType<TStatType>, CharacterValueFromModifiers {
}
