package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.ReadableMap;
import soliloquy.specs.ruleset.entities.CharacterStatisticType;
import soliloquy.specs.ruleset.gameconcepts.CharacterStatisticCalculation;

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
        extends CharacterEntityOfType<TStatType> {
    /**
     * @return The total value, resulting from all modifiers
     * @throws IllegalStateException If the Character has been deleted
     */
    int totalValue() throws IllegalStateException;

    /**
     * @return A read-only Map, where each key is the name of a modifier (e.g. "FromBase",
     * "FromItems", etc.), and each value is the value from that modifier contributing to the total
     * value.
     * @throws IllegalStateException If the Character has been deleted
     */
    ReadableMap<String,Integer> representation() throws IllegalStateException;

    /**
     * Calculates the value of this CharacterStatistic (using a calculator from the
     * Ruleset module, e.g. an implementation of {@link
     * CharacterStatisticCalculation})
     * @throws IllegalStateException If the Character has been deleted
     */
    void calculate() throws IllegalStateException;
}
