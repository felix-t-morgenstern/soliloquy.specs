package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Deletable;
import soliloquy.specs.gamestate.entities.EntityMemberOfType;
import soliloquy.specs.gamestate.entities.EntityMembersOfType;

import java.util.function.Function;

/**
 * <b>EntityMembersOfTypeFactory</b>
 * <p>
 * Creates a collection of entity members of a specified type
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface EntityMembersOfTypeFactory extends SoliloquyClass {
    /**
     * @param containingEntity The entity for whom to make an aggregated entity (e.g.
     *                         {@link soliloquy.specs.gamestate.entities.CharacterStatistic})
     * @param entityMemberTypeArchetype An archetype of the type of the entity members
     * @param entityMemberArchetype An archetype of the entity members
     * @param <TEntityMemberType> The type of the entity member being created
     * @param <TEntityMember> The entity member being created
     * @param <TEntity> The entity for which the members are created
     * @return The newly-created entity member
     * @throws IllegalArgumentException If and only if containingEntity or archetype are null
     * @throws UnsupportedOperationException If and only if no factory has been registered for the
     *                                       specified types
     */
    <TEntityMemberType extends HasId, TEntityMember extends EntityMemberOfType<TEntityMemberType>,
            TEntity extends Deletable>
    EntityMembersOfType<TEntityMemberType, TEntityMember, TEntity> make(
            TEntity containingEntity,
            TEntityMemberType entityMemberTypeArchetype,
            TEntityMember entityMemberArchetype)
            throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * @param entityFactory The factory to make new EntityMembersOfType of the specified types
     * @param entityMemberTypeArchetype An archetype of the type of the entity members
     * @param entityMemberArchetype An archetype of the entity members
     * @param entityArchetype An archetype of the containing entity
     * @param <TEntityMemberType> The type of the entity member being created
     * @param <TEntityMember> The entity member being created
     * @param <TEntity> The entity for which the members are created
     * @throws IllegalArgumentException If and only if factory or any of the archetype parameters
     * are null
     */
    <TEntityMemberType extends HasId, TEntityMember extends EntityMemberOfType<TEntityMemberType>,
            TEntity extends Deletable>
    void registerFactory(Function<TEntity,Function<TEntityMemberType,Function<VariableCache,
                                 TEntityMember>>> entityFactory,
                         TEntityMemberType entityMemberTypeArchetype,
                         TEntityMember entityMemberArchetype,
                         TEntity entityArchetype)
            throws IllegalArgumentException;
}
