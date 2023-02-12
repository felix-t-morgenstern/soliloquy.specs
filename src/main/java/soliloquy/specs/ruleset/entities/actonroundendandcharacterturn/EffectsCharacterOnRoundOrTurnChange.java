package soliloquy.specs.ruleset.entities.actonroundendandcharacterturn;

import soliloquy.specs.common.shared.HasPriority;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.Pair;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.ruleset.entities.character.StatisticType;
import soliloquy.specs.ruleset.entities.character.VariableStatisticType;
import soliloquy.specs.ruleset.entities.character.StatusEffectType;
import soliloquy.specs.ruleset.gameconcepts.RoundEndHandling;

import java.util.List;

/**
 * <b>EffectsCharacterOnRoundOrTurnChange</b>
 * <p>
 * This describes the effects that a {@link StatisticType} or {@link StatusEffectType} has on a
 * {@link Character#getVariableStatisticCurrentValue} at the end of a round, or the start or end of
 * that {@link Character}'s turn.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface EffectsCharacterOnRoundOrTurnChange extends SoliloquyClass {
    /**
     * @return The effect(s) this entity has on a Character at the end of a round. Can be null.
     */
    RoundEndEffectsOnCharacter onRoundEnd();

    /**
     * @return The effect(s) this entity has on a Character at the start of their turn. Can be
     *         null.
     */
    EffectsOnCharacter onTurnStart();

    /**
     * @return The effect(s) this entity has on a Character at the end of their turn. Can be null.
     */
    EffectsOnCharacter onTurnEnd();

    interface EffectsOnCharacter extends HasPriority {
        /**
         * @return The magnitude of change that this entity has on one or more
         *         {@link VariableStatisticType}s. It is assumed that this will never be
         *         null.
         */
        @SuppressWarnings("rawtypes")
        List<StatisticChangeMagnitude> magnitudes();

        /**
         * After the {@link #magnitudes()} of this entity are calculated into an ultimate effect on
         * the Character, if any of the ultimate effects are non-zero, this function is called. It
         * is intended to perform various UI tasks to indicate the damage/healing/etc. After this
         * function is called, the {@link Character#getVariableStatisticCurrentValue} in question is
         * actually altered.
         *
         * @param effects         The effects of the magnitudes, in order
         * @param character       The Character with the current statistic or status effect
         * @param advancingRounds True, if and only if multiple rounds are being advanced at one
         *                        time (see
         *                        {@link
         *                        soliloquy.specs.gamestate.entities.RoundManager#advanceRounds}
         * @throws IllegalArgumentException If and only if effects or character is null
         */
        void accompanyEffect(int[] effects, Character character, boolean advancingRounds)
                throws IllegalArgumentException;

        /**
         * This function takes in the current level of this entity, then uses that level to
         * determine some other series of actions to take, possibly on the Character. This function
         * can be left undefined.
         *
         * @param effects         The effects of the magnitudes, in order
         * @param character       The Character with the current statistic or status effect
         * @param advancingRounds True, if and only if multiple rounds are being advanced at one
         *                        time (see
         *                        {@link
         *                        soliloquy.specs.gamestate.entities.RoundManager#advanceRounds}
         * @throws IllegalArgumentException If and only if effects or character is null
         */
        void otherEffects(int[] effects, Character character, boolean advancingRounds)
                throws IllegalArgumentException;
    }

    interface RoundEndEffectsOnCharacter extends EffectsOnCharacter {
        /**
         * This is to be used by {@link RoundEndHandling#runRoundEnd}. After running all the
         * effects on all Characters provided by
         * {@link soliloquy.specs.ruleset.gameconcepts.ActiveCharactersProvider} at the end of the
         * round, this method will be called with a list of every effect inflicted on all
         * Characters. The intent is for this RoundEndEffectsOnCharacter to display all the
         * accompanying UI effects simultaneously, rather than serially.
         *
         * @param allEffects      All the effects generated by this RoundEndEffectsOnCharacter for
         *                        every Character.
         * @param advancingRounds True, if and only if multiple rounds are being advanced at one
         *                        time (see
         *                        {@link
         *                        soliloquy.specs.gamestate.entities.RoundManager#advanceRounds}
         * @throws IllegalArgumentException If and only if allEffects is null, or contains any null
         *                                  entries, or if any of its entries have null items.
         */
        void accompanyAllEffects(List<Pair<int[], Character>> allEffects, boolean advancingRounds)
                throws IllegalArgumentException;
    }
}
