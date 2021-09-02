package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.ruleset.entities.CharacterVariableStatisticType;
import soliloquy.specs.ruleset.entities.abilities.ActiveAbility;

/**
 * <b>EntityMemberOfType</b>
 * <p>
 * An entity of a specific type (e.g.
 * {@link ActiveAbility} or
 * {@link CharacterVariableStatisticType}), belonging to another entity, e.g. a Character or Item
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <TEntityType> The type of this entity
 */
public interface EntityMemberOfType<TEntityType extends HasId> extends GameEntity {
    /**
     * @return The type of this entity
     * @throws EntityDeletedException If and only if this entity or its parent entity (e.g.
     * Character or Item) has been deleted
     */
    TEntityType type() throws EntityDeletedException;
}
