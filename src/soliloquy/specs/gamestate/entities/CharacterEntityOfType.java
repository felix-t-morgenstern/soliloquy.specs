package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.ruleset.entities.CharacterVariableStatisticType;

/**
 * <b>CharacterEntityOfType</b>
 * <p>
 * An entity, belonging to a Character, of a specific type (e.g.
 * {@link soliloquy.specs.ruleset.entities.abilities.ActiveAbilityType} or
 * {@link CharacterVariableStatisticType})
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <TEntityType> The type of this entity
 */
public interface CharacterEntityOfType<TEntityType extends HasId> extends GameEntity {
    /**
     * @return The type of this entity
     */
    TEntityType type();
}
