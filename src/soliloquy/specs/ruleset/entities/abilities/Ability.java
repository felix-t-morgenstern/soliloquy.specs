package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Item;

/**
 * <b>Ability</b>
 * <p>
 * A common set of behaviors for ActiveAbilityTypes and ReactiveAbilityTypes
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Ability extends HasName, HasId {
	/**
	 * Returns a string describing the Ability.
	 * @param source The Character source of the Ability, used to determine its effectiveness
	 * @return The full description of the Ability.
	 * @throws IllegalStateException If this Ability has no Id
	 */
	String description(Character source) throws IllegalStateException;

	/**
	 * Returns a string describing the Ability.
	 * @param source The Item source of the Ability, used to determine its effectiveness
	 * @return The full description of the Ability.
	 * @throws IllegalStateException If this Ability has no Id
	 */
	String description(Item source) throws IllegalStateException;
}
