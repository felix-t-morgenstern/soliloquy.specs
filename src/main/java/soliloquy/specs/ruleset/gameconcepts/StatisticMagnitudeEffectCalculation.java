package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.ruleset.entities.actonroundendandcharacterturn.StatisticChangeMagnitude;
import soliloquy.specs.ruleset.entities.character.StaticStatisticType;
import soliloquy.specs.ruleset.entities.character.StatisticType;
import soliloquy.specs.ruleset.entities.character.VariableStatisticType;
import soliloquy.specs.ruleset.entities.character.StatusEffectType;

/**
 * <b>StatisticMagnitudeEffectCalculation</b>
 * <p>
 * This class is used by {@link TurnHandling} and {@link RoundEndHandling} to calculate the amount
 * by which to alter a given {@link VariableStatisticType} for a given {@link Character} when
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
     * potentially taking into account resistances (see {@link DamageResistanceCalculation}).
     * <p>
     * This method is only for StatisticChangeMagnitudes of {@link StaticStatisticType}s.
     *
     * @param statisticType The {@link VariableStatisticType} of the magnitude
     * @param magnitude     The magnitude of statistic change applied to the Character
     * @param character     The Character to whom the effect will transpire
     * @return The net statistic change effect
     * @throws IllegalArgumentException If and only if statisticType is null, or magnitude
     *                                  is null or invalid, or character is null
     * @throws EntityDeletedException   If and only if character is deleted
     */
    <T extends Number> int getEffect(StatisticType statisticType,
                                     StatisticChangeMagnitude<T> magnitude, Character character)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * Calculates an ultimate statistic change effect for a change of a given magnitude, after
     * potentially taking into account resistances (see {@link DamageResistanceCalculation} and
     * {@link StatusEffectResistanceCalculation}).
     * <p>
     * This method is only for StatisticChangeMagnitudes of {@link StatusEffectType}s.
     *
     * @param statusEffectType The {@link VariableStatisticType} of the magnitude
     * @param magnitude        The magnitude of statistic change applied to the Character
     * @param character        The Character to whom the effect will transpire
     * @return The net statistic change effect
     * @throws IllegalArgumentException If and only if statusEffectType is null, or magnitude is
     *                                  null or invalid, or character is null
     * @throws EntityDeletedException   If and only if character is deleted
     */
    <T extends Number> int getEffect(StatusEffectType statusEffectType,
                                     StatisticChangeMagnitude<T> magnitude, Character character)
            throws IllegalArgumentException, EntityDeletedException;
}
