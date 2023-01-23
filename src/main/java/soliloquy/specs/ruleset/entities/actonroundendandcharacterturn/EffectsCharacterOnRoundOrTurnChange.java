package soliloquy.specs.ruleset.entities.actonroundendandcharacterturn;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.ruleset.entities.character.CharacterVariableStatisticType;
import soliloquy.specs.ruleset.entities.character.StatusEffectType;

import java.util.List;

/**
 * <b>EffectsCharacterOnRoundOrTurnChange</b>
 * <p>
 * This describes the effects that a {@link CharacterVariableStatisticType} or
 * {@link StatusEffectType} has on a
 * {@link soliloquy.specs.gamestate.entities.CharacterVariableStatistic} at the end of a round, or
 * the start or end of that {@link Character}'s turn.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface EffectsCharacterOnRoundOrTurnChange extends SoliloquyClass {
    /**
     * @return The effect(s) this entity has on a Character at the end of a round. Can be null.
     */
    EffectsOnCharacter onRoundEnd();

    /**
     * @return The effect(s) this entity has on a Character at the start of their turn. Can be
     *         null.
     */
    EffectsOnCharacter onTurnStart();

    /**
     * @return The effect(s) this entity has on a Character at the end of their turn. Can be null.
     */
    EffectsOnCharacter onTurnEnd();

    interface EffectsOnCharacter {
        /**
         * @return The priority for this entity to take effect. Entities with higher priority take
         *         effect sooner.
         */
        int priority();

        /**
         * @return The magnitude of change that this entity has on one or more
         *         {@link CharacterVariableStatisticType}s. It is assumed that this will never be
         *         null.
         */
        @SuppressWarnings("rawtypes")
        List<StatisticChangeMagnitude> magnitudes();

        /**
         * After the {@link #magnitudes()} of this entity are calculated into an ultimate effect on
         * the Character, if any of the ultimate effects are non-zero, this function is called. It
         * is intended to perform various UI tasks to indicate the damage/healing/etc. After this
         * function is called, the
         * {@link soliloquy.specs.gamestate.entities.CharacterVariableStatistic} in question is
         * actually altered.
         * <p>
         * It is assumed that this function will never be undefined.
         *
         * @param effects   The effects of the magnitudes, in order
         * @param character The Character with the current statistic or status effect
         * @throws IllegalArgumentException If and only if effects or character is null
         */
        void accompanyEffect(int[] effects, Character character) throws IllegalArgumentException;

        /**
         * This function takes in the current level of this entity, then uses that level to
         * determine some other series of actions to take, possibly on the Character. This function
         * can be left undefined.
         *
         * @param effects   The effects of the magnitudes, in order
         * @param character The Character with the current statistic or status effect
         * @throws IllegalArgumentException If and only if effects or character is null
         */
        void otherEffects(int[] effects, Character character) throws IllegalArgumentException;
    }
}
