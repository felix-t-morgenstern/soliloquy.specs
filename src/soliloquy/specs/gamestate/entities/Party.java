package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;

import java.util.List;

/**
 * <b>Party</b>
 * <p>
 * The Party stores a List of the player-controlled Characters; and characterStatisticTypes of the
 * Party, e.g. gold, military rank, group combat blessings
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Party extends SoliloquyClass {
    /**
     * @return A List of all player-controlled Characters
     */
    List<Character> characters();

    /**
     * @return A set of characterStatisticTypes of the Party, e.g. gold, military rank, group combat
     *         blessings
     */
    VariableCache attributes();
}
