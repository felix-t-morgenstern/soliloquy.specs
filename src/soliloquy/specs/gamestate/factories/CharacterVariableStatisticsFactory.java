package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.CharacterVariableStatistics;

/**
 * <b>CharacterEntitiesOfTypeFactory</b>
 * <p>
 * Creates a collection of variable statistics for a given  {@link Character}
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterVariableStatisticsFactory extends SoliloquyClass {
    CharacterVariableStatistics make(Character character);
}
