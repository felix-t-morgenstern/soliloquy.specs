package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.shared.HasId;

/**
 * <b>CharacterEntityOfType</b>
 * <p>
 * An entity, belonging to a Character, of a specific type (e.g.
 * {@link soliloquy.specs.ruleset.entities.abilities.ActiveAbilityType} or
 * {@link soliloquy.specs.ruleset.entities.CharacterDepletableStatisticType})
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <TEntityType> The type of this entity
 */
public interface CharacterEntityOfType<TEntityType extends HasId> extends Deletable {
    /**
     * @return The type of this entity
     */
    TEntityType type();
}
