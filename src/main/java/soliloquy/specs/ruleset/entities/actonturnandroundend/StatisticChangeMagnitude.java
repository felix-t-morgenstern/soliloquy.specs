package soliloquy.specs.ruleset.entities.actonturnandroundend;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.Pair;

/**
 * <b>StatisticChangeMagnitude</b>
 * <p>
 * A StatisticChangeMagnitude is the degree to which a given
 * {@link soliloquy.specs.gamestate.entities.CharacterVariableStatistic} will be impacted by the
 * level of a given {@link soliloquy.specs.ruleset.entities.StatusEffectType} or
 * {@link soliloquy.specs.gamestate.entities.CharacterStatistic}.
 *
 * @param <TValue> The numerical type of this magnitude. <i>If {@link #amountType()} is Value, then
 *                 this will be Integer; otherwise, if it is Percent, of either the
 *                 {@link soliloquy.specs.gamestate.entities.CharacterVariableStatistic}'s current
 *                 or maximum it will be a Float.</i>
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface StatisticChangeMagnitude<TValue extends Number> extends SoliloquyClass {
    /**
     * @return The type of effect, see {@link EffectType}
     */
    EffectType effectType();

    /**
     * @return The type of the amount returned, see {@link AmountType}
     */
    AmountType amountType();

    /**
     * The second value can be less than or greater than the first, and it can be null. If it is
     * null, it is assumed that a flat amount is added per level.
     * <br>
     * An example of this is poison, which might deal 1-5 damage per level of poisoning. In that
     * case, that {@link soliloquy.specs.ruleset.entities.StatusEffectType}'s
     * StatisticChangeMagnitude would have a perLevelRange of [-1, -5].
     *
     * @return The range of values to add to this magnitude per level of the given
     *         {@link soliloquy.specs.ruleset.entities.StatusEffectType} or
     *         {@link soliloquy.specs.gamestate.entities.CharacterStatistic}. If null, then there is
     *         no magnitude added per level.
     */
    Pair<TValue, TValue> perLevelRange();

    /**
     * The second value can be less than or greater than the first, and it can be null. If it is
     * null, it is assumed that a flat amount is added per level.
     * <br>
     * An example of this might be sickness, which might reduce health by 5-10%, so long as the
     * {@link soliloquy.specs.gamestate.entities.Character} has any amount of sickness. In that
     * case, that {@link soliloquy.specs.ruleset.entities.StatusEffectType}'s
     * StatisticChangeMagnitude would have an absoluteRange of [-0.05, -0.1].
     *
     * @return The range of values to add once to this magnitude, if there is any amount of the
     *         {@link soliloquy.specs.gamestate.entities.CharacterVariableStatistic} or
     *         {@link soliloquy.specs.ruleset.entities.StatusEffectType} present whatsoever on the
     *         {@link soliloquy.specs.gamestate.entities.Character} in question. If null, then there
     *         is no absolute magnitude added.
     */
    Pair<TValue, TValue> absoluteRange();

    enum EffectType {
        /**
         * A magnitude that is an Alteration effects the CharacterVariableStatistic without taking
         * resistances into account
         */
        ALTERATION(1),
        /**
         * A magnitude that is Damage is reduced according to
         * {@link soliloquy.specs.ruleset.gameconcepts.VariableStatisticLossResistanceCalculation}
         * before effecting the CharacterVariableStatistic
         */
        DAMAGE(2);

        private final int VALUE;

        EffectType(int value) {
            VALUE = value;
        }

        public int getValue() {
            return VALUE;
        }

        public static EffectType fromValue(int value) {
            switch (value) {
                case 1:
                    return ALTERATION;
                case 2:
                    return DAMAGE;
                default:
                    throw new IllegalArgumentException("StatisticChangeMagnitude.EffectType" +
                            ".fromValue: value(" + value + ") does not correspond to valid enum " +
                            "type");
            }
        }
    }

    enum AmountType {
        /**
         * A magnitude whose AmountType is Value will impact the corresponding
         * {@link soliloquy.specs.gamestate.entities.CharacterVariableStatistic} by a flat amount.
         */
        VALUE(1),
        /**
         * A magnitude whose AmountType is Percent Of Current will impact the corresponding
         * {@link soliloquy.specs.gamestate.entities.CharacterVariableStatistic} by a percentage of
         * its current value.
         */
        PERCENT_OF_CURRENT(2),
        /**
         * A magnitude whose AmountType is Percent Of Maximum will impact the corresponding
         * {@link soliloquy.specs.gamestate.entities.CharacterVariableStatistic} by a percentage of
         * its maximum value.
         */
        PERCENT_OF_MAXIMUM(3);

        private final int ENUM_VALUE;

        AmountType(int value) {
            ENUM_VALUE = value;
        }

        public int getValue() {
            return ENUM_VALUE;
        }

        public static AmountType fromValue(int value) {
            switch (value) {
                case 1:
                    return VALUE;
                case 2:
                    return PERCENT_OF_CURRENT;
                case 3:
                    return PERCENT_OF_MAXIMUM;
                default:
                    throw new IllegalArgumentException("StatisticChangeMagnitude.AmountType" +
                            ".fromValue: value(" + value + ") does not correspond to valid enum " +
                            "type");
            }
        }
    }
}
