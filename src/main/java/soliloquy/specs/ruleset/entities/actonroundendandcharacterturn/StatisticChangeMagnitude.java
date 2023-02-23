package soliloquy.specs.ruleset.entities.actonroundendandcharacterturn;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.Pair;
import soliloquy.specs.ruleset.entities.Element;
import soliloquy.specs.ruleset.entities.character.VariableStatisticType;
import soliloquy.specs.ruleset.entities.character.StatusEffectType;
import soliloquy.specs.ruleset.gameconcepts.DamageResistanceCalculation;

/**
 * <b>StatisticChangeMagnitude</b>
 * <p>
 * A StatisticChangeMagnitude is the degree to which a given
 * {@link soliloquy.specs.gamestate.entities.Character#getVariableStatisticCurrentValue} will be
 * impacted by the level of a given {@link StatusEffectType} or variable statistic.
 *
 * @param <TValue> The numerical type of this magnitude. <i>If {@link #amountType()} is Value, then
 *                 this will be Integer; otherwise, if it is Percent, of either the
 *                 {@link VariableStatisticType}'s current or maximum it will be a
 *                 Float.</i>
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface StatisticChangeMagnitude<TValue extends Number> extends SoliloquyClass {
    /**
     * @return The VariableStatisticType effected by a change of this magnitude
     */
    VariableStatisticType effectedStatisticType();

    /**
     * @return The Element of this effect on the target Character. Can be null.
     */
    Element element();

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
     * case, that {@link StatusEffectType}'s
     * StatisticChangeMagnitude would have a perLevelRange of [-1, -5].
     *
     * @return The range of values to add to this magnitude per level of the given
     *         {@link StatusEffectType} or {@link VariableStatisticType}. If null, then
     *         there is no magnitude added per level.
     */
    Pair<TValue, TValue> perLevelRange();

    /**
     * The second value can be less than or greater than the first, and it can be null. If it is
     * null, it is assumed that a flat amount is added per level.
     * <br>
     * An example of this might be sickness, which might reduce health by 5-10%, so long as the
     * {@link soliloquy.specs.gamestate.entities.Character} has any amount of sickness. In that
     * case, that {@link StatusEffectType}'s
     * StatisticChangeMagnitude would have an absoluteRange of [-0.05, -0.1].
     *
     * @return The range of values to add once to this magnitude, if there is any amount of the
     *         {@link VariableStatisticType} or {@link StatusEffectType} present whatsoever
     *         on the {@link soliloquy.specs.gamestate.entities.Character} in question. If null,
     *         then there is no absolute magnitude added.
     */
    Pair<TValue, TValue> absoluteRange();

    enum EffectType {
        /**
         * A magnitude that is an Alteration effects the CharacterVariableStatistic without taking
         * resistances into account
         */
        ALTERATION(1),
        /**
         * A magnitude that is Damage is reduced according to {@link DamageResistanceCalculation}
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
            return switch (value) {
                case 1 -> ALTERATION;
                case 2 -> DAMAGE;
                default ->
                        throw new IllegalArgumentException("StatisticChangeMagnitude.EffectType" +
                                ".fromValue: value(" + value + ") does not correspond to valid " +
                                "enum type");
            };
        }
    }

    enum AmountType {
        /**
         * A magnitude whose AmountType is Value will impact the corresponding
         * {@link soliloquy.specs.gamestate.entities.Character#getVariableStatisticCurrentValue} by
         * a flat amount.
         */
        VALUE(1),
        /**
         * A magnitude whose AmountType is Percent Of Current will impact the corresponding
         * {@link soliloquy.specs.gamestate.entities.Character#getVariableStatisticCurrentValue} by
         * a percentage of its current value.
         */
        PERCENT_OF_CURRENT(2),
        /**
         * A magnitude whose AmountType is Percent Of Maximum will impact the corresponding
         * {@link soliloquy.specs.gamestate.entities.Character#getVariableStatisticCurrentValue} by
         * a percentage of its maximum value.
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
            return switch (value) {
                case 1 -> VALUE;
                case 2 -> PERCENT_OF_CURRENT;
                case 3 -> PERCENT_OF_MAXIMUM;
                default ->
                        throw new IllegalArgumentException("StatisticChangeMagnitude.AmountType" +
                                ".fromValue: value(" + value + ") does not correspond to valid " +
                                "enum " +
                                "type");
            };
        }
    }
}
