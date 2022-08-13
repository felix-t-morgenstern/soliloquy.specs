package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Item;
import soliloquy.specs.gamestate.entities.Tile;

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
     *
     * @param source  The source Character of the ActiveAbility
     * @param targets The target(s) of the ActiveAbility
     * @param params  The parameters regarding the effects (e.g. damage healed, chance-to-hit) of
     *                the ActiveAbility
     */
    void use(Character source, List<Pair<Character, Tile>> targets, VariableCache params);

    /**
     * Uses this ActiveAbility against some target(s)
     *
     * @param source  The source Item of the ActiveAbility
     * @param targets The target(s) of the ActiveAbility
     * @param params  The parameters regarding the effects (e.g. damage healed, chance-to-hit) of
     *                the ActiveAbility
     */
    void use(Item source, List<Pair<Character, Tile>> targets, VariableCache params);
}
