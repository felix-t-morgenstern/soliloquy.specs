package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.valueobjects.Pair;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.ruleset.entities.character.StatisticType;

import java.math.BigDecimal;
import java.util.Map;

/**
 * <b>StatisticCalculation</b>
 * <p>
 * This class is used to determine a given Character statistic for a given Character.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface StatisticCalculation {
    /**
     * This method calculates the value of a {@link StatisticType} for a {@link Character}
     *
     * @param character     The {@link Character} whose statistic to calculate
     * @param statisticType The type of the statistic to calculate for character
     * @return The calculated value of the statistic
     * @throws IllegalArgumentException If and only if character or entityType are null
     * @throws IllegalStateException    If and only if character is deleted
     */
    int calculate(Character character, StatisticType statisticType)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * This method calculates both the value for a {@link Character}, as well as a Map of various
     * modifying entities with the respective adjustment amounts
     *
     * @param character     The {@link Character} whose statistic to calculate
     * @param statisticType The type of the statistic to calculate for character
     * @return A Pair, whose first entry is the ultimate value of the statistic, and whose second
     *         entry is the collection of modifier types (e.g. "FromBaseAttributes", "FromItems",
     *         etc.)
     * @throws IllegalArgumentException If and only if character or entityType are null
     * @throws IllegalStateException    If and only if character is deleted
     */
    Pair<Integer, Map<Object, BigDecimal>> calculateWithDescriptors(Character character,
                                                                    StatisticType statisticType)
            throws IllegalArgumentException, IllegalStateException;
}
