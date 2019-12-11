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
}
