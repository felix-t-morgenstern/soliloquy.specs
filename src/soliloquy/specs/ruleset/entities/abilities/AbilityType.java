package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.gamestate.entities.GameEntity;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;

/**
 * <b>AbilityType</b>
 * <p>
 * A common set of behaviors for ActiveAbilityTypes and ReactiveAbilityTypes
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface AbilityType extends HasName, HasId {
	/**
	 * Returns a string describing the Ability.
	 * @param params Used to help describe the effects of the Ability (e.g. the damage it will do)
	 * @return The full description of the Ability.
	 * @throws IllegalStateException If this AbilityType has no Id
	 */
	String description(VariableCache params) throws IllegalStateException;
}
