package soliloquy.specs.gamestate.entities.abilities;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Item;

/**
 * <b>AbilitySource</b>
 * <p>
 * Specifies the Item, Character, or Tile which used the Ability. (One and only one of these values
 * should be non-null.)
 * <p>
 * (A lot of the work of classes implementing this interface will be to enforce invariants.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface AbilitySource extends SoliloquyClass {
    /**
     * @return The Item from which this {@link soliloquy.specs.ruleset.entities.abilities.Ability}
     *         originated; if null, then this Ability did not originate from an Item.
     * @throws IllegalStateException If the specified Item does not have this Ability, or if this
     *                               AbilitySource has more than one source specified
     */
    Item item() throws IllegalStateException;

    /**
     * @return The Character from which this
     *         {@link soliloquy.specs.ruleset.entities.abilities.Ability} originated; if null, then
     *         this Ability did not originate from a Character.
     * @throws IllegalStateException If the specified Character does not have this Ability
     */
    Character character() throws IllegalStateException;

    /**
     * @return Other data associated with the firing of the relevant
     *         {@link soliloquy.specs.ruleset.entities.abilities.Ability}
     */
    VariableCache data();
}
