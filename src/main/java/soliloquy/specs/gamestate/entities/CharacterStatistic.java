package soliloquy.specs.gamestate.entities;

import soliloquy.specs.ruleset.entities.character.CharacterStatisticType;
import soliloquy.specs.ruleset.entities.character.CharacterStaticStatisticType;
import soliloquy.specs.ruleset.entities.character.CharacterVariableStatisticType;
import soliloquy.specs.ruleset.gameconcepts.CharacterStatisticCalculation;

import java.util.Map;

/**
 * <b>CharacterStatistic</b>
 * <p>
 * A given {@link Character}'s statistic of a specified type (i.e.
 * {@link CharacterVariableStatisticType} or
 * {@link CharacterStaticStatisticType}).
 *
 * @param <TStatType> The type (e.g. variable or static) of this statistic
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
// TODO: GET RID OF THIS!!! SIMPLY HAVE CHARACTERS STORE THEIR TYPES!!!
public interface CharacterStatistic<TStatType extends CharacterStatisticType>
        extends EntityMemberOfType<TStatType> {
    /**
     * @return The total value, resulting from all modifiers
     * @throws IllegalStateException If the Character has been deleted
     */
    int totalValue() throws IllegalStateException;

    /**
     * @return A Map, where each key is the name of a modifier (e.g. "FromBase", "FromItems",
     *         etc.), and each value is the value from that modifier contributing to the total
     *         value.
     * @throws IllegalStateException If the Character has been deleted
     */
    Map<String, Integer> representation() throws IllegalStateException;

    /**
     * Calculates the value of this CharacterStatistic (using a calculator from the
     * Ruleset module, e.g. an implementation of {@link
     * CharacterStatisticCalculation})
     *
     * @throws IllegalStateException If the Character has been deleted
     */
    void calculate() throws IllegalStateException;
}
