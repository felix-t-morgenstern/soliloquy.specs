package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.CharacterVariableStatistic;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.ruleset.entities.actonroundendandcharacterturn.StatisticChangeMagnitude;
import soliloquy.specs.ruleset.entities.character.CharacterVariableStatisticType;
import soliloquy.specs.ruleset.entities.character.StatusEffectType;

/**
 * <b>StatisticMagnitudeEffectCalculation</b>
 * <p>
 * This class is used by {@link ActOnRoundEndAndCharacterTurn} to calculate the amount by which to
 * alter a given {@link soliloquy.specs.gamestate.entities.CharacterVariableStatistic} when
 * performing a given
 * {@link
 * soliloquy.specs.ruleset.entities.actonroundendandcharacterturn.EffectsCharacterOnRoundOrTurnChange}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface StatisticMagnitudeEffectCalculation {
    /**
     * Calculates an ultimate statistic change effect for a change of a given magnitude, after
     * potentially taking into account resistances (see
     * {@link VariableStatisticLossResistanceCalculation} and
     * {@link StatusEffectResistanceCalculation}).
     * <p>
     * This method is only for StatisticChangeMagnitudes of {@link CharacterVariableStatisticType}s.
     *
     * @param variableStatisticType The {@link CharacterVariableStatisticType} of the magnitude
     * @param magnitude             The magnitude of statistic change applied to the Character
     * @param sourceCurrentValue    The current value of the {@link CharacterVariableStatistic}
     *                              generating the effect
     * @param effectedMaxValue      The maximum value of the {@link CharacterVariableStatistic} to
     *                              effect
     * @param effectedCurrentValue  The maximum value of the {@link CharacterVariableStatistic} to
     *                              effect
     * @param character             The Character to whom the effect will transpire
     * @return The net statistic change effect
     * @throws IllegalArgumentException If and only if variableStatisticType is null, or magnitude
     *                                  is null or invalid, or character is null
     * @throws EntityDeletedException   If and only if character is deleted
     */
    <T extends Number> int getEffect(CharacterVariableStatisticType variableStatisticType,
                                     StatisticChangeMagnitude<T> magnitude,
                                     int sourceCurrentValue, int effectedMaxValue,
                                     int effectedCurrentValue, Character character)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * Calculates an ultimate statistic change effect for a change of a given magnitude, after
     * potentially taking into account resistances (see
     * {@link VariableStatisticLossResistanceCalculation} and
     * {@link StatusEffectResistanceCalculation}).
     * <p>
     * This method is only for StatisticChangeMagnitudes of {@link StatusEffectType}s.
     *
     * @param statusEffectType     The {@link CharacterVariableStatisticType} of the magnitude
     * @param magnitude            The magnitude of statistic change applied to the Character
     * @param levels               The current levels of the {@link StatusEffectType} for the
     *                             {@link Character} in question
     * @param effectedMaxValue     The maximum value of the {@link CharacterVariableStatistic} to
     *                             effect
     * @param effectedCurrentValue The maximum value of the {@link CharacterVariableStatistic} to
     *                             effect
     * @param character            The Character to whom the effect will transpire
     * @return The net statistic change effect
     * @throws IllegalArgumentException If and only if statusEffectType is null, or magnitude is
     *                                  null or invalid, or character is null
     * @throws EntityDeletedException   If and only if character is deleted
     */
    <T extends Number> int getEffect(StatusEffectType statusEffectType,
                                     StatisticChangeMagnitude<T> magnitude, int levels,
                                     int effectedMaxValue, int effectedCurrentValue,
                                     Character character)
            throws IllegalArgumentException, EntityDeletedException;
}
