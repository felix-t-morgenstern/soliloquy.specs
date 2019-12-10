package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.ReadableMap;
import soliloquy.specs.ruleset.entities.CharacterDepletableStatisticType;

/**
 * <b>CharacterDepletableStatistics</b>
 * <p>
 * A collection of {@link CharacterDepletableStatistic}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterDepletableStatistics
        extends CharacterEntitiesOfType<CharacterDepletableStatisticType,
            CharacterDepletableStatistic> {
    /**
     * @return A read-only map linking each present stat type to its current value
     */
    ReadableMap<CharacterDepletableStatisticType, Integer> currentValues();

    /**
     * @return A read-only map linking each present stat type to its maximum value
     */
    ReadableMap<CharacterDepletableStatisticType, Integer> maxValues();

    /**
     * @param statType - The type of stat whose current value to retrieve
     * @return The current value of the provided stat type
     * @throws IllegalArgumentException If and only if statType is null
     */
    int getCurrentValue(CharacterDepletableStatisticType statType) throws IllegalArgumentException;

    /**
     * @param statType - The type of stat whose maximum value to retrieve
     * @return The maximum value of the provided stat type
     * @throws IllegalArgumentException If and only if statType is null
     */
    int getMaxValue(CharacterDepletableStatisticType statType) throws IllegalArgumentException;
}
