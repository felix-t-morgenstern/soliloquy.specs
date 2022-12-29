package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.valueobjects.Pair;
import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Item;
import soliloquy.specs.gamestate.entities.Tile;

import java.util.List;

/**
 * <b>ActiveAbility</b>
 * <p>
 * It can be used on a target(s), given a source, and parameters regarding its effects
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ActiveAbility extends Ability {
    /**
     * Uses this ActiveAbility against some target(s)
     * <p>
     * This method is intended to calculate the potency of this Ability by looking up some
     * property(s) of the Character, e.g. {@link Character#staticStatistics()}
     *
     * @param source  The source Character of the ActiveAbility
     * @param targets The target(s) of the ActiveAbility
     * @param params  The parameters regarding the effects (e.g. damage healed, chance-to-hit) of
     *                the ActiveAbility
     */
    void use(Character source, List<Pair<Character, Tile>> targets, VariableCache params);

    /**
     * Uses this ActiveAbility against some target(s)
     * <p>
     * This method is intended to calculate the potency of this Ability by looking up some
     * property(s) of the Item, e.g. {@link Item#data()}
     *
     * @param source  The source Item of the ActiveAbility
     * @param targets The target(s) of the ActiveAbility
     * @param params  The parameters regarding the effects (e.g. damage healed, chance-to-hit) of
     *                the ActiveAbility
     */
    void use(Item source, List<Pair<Character, Tile>> targets, VariableCache params);
}
