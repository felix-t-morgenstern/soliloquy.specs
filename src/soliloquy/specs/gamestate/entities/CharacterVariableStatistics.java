package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.ReadableMap;
import soliloquy.specs.ruleset.entities.CharacterVariableStatisticType;

/**
 * <b>CharacterVariableStatistics</b>
 * <p>
 * A collection of {@link CharacterVariableStatistic}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterVariableStatistics
        extends CharacterEntitiesOfType<CharacterVariableStatisticType,
        CharacterVariableStatistic> {
    /**
     * @return A read-only map linking each present stat type to its current value
     */
    ReadableMap<CharacterVariableStatisticType, Integer> currentValues();

    /**
     * @return A read-only map linking each present stat type to its maximum value
     */
    ReadableMap<CharacterVariableStatisticType, Integer> maxValues();
}
