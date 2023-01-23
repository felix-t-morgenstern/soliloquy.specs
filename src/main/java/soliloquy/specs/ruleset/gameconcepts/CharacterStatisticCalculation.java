package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.valueobjects.Pair;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.ruleset.entities.character.CharacterStatisticType;

import java.util.Map;

/**
 * <b>CharacterStatisticCalculation</b>
 * <p>
 * This class is used to determine a given Character statistic for a given Character.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterStatisticCalculation extends SoliloquyClass {
    /**
     * This method calculates both the value for a
     * {@link soliloquy.specs.gamestate.entities.Character}, as well as a Map of various modifier
     * types with the respective integer adjustments
     *
     * @param character     The {@link soliloquy.specs.gamestate.entities.Character} whose statistic
     *                      to calculate
     * @param statisticType The type of the statistic to calculate for character
     * @return A Pair, whose first entry is the ultimate value of the statistic, and whose second
     *         entry is the collection of modifier types (e.g. "FromBaseAttributes", "FromItems",
     *         etc.)
     * @throws IllegalArgumentException If and only if character or entityType are null
     * @throws IllegalStateException    If and only if character is deleted
     */
    Pair<Integer, Map<String, Integer>> calculate(Character character,
                                                  CharacterStatisticType statisticType)
            throws IllegalArgumentException, IllegalStateException;
}
