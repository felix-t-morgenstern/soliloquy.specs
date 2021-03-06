package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Map;
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
     * @return A Map representing the links between each present stat type and its current value
     */
    Map<CharacterVariableStatisticType, Integer> currentValues();

    /**
     * @return A Map representing the links between each present stat type and its maximum value
     */
    Map<CharacterVariableStatisticType, Integer> maxValues();
}
