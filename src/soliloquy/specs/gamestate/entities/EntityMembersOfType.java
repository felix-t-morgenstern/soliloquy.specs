package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.ruleset.entities.CharacterVariableStatisticType;

/**
 * <b>EntityMembersOfType</b>
 * <p>
 * A collection of the statistics for a {@link Character} or {@link Item} of a certain type (e.g.
 * {@link CharacterVariableStatisticType} or
 * {@link soliloquy.specs.ruleset.entities.CharacterStaticStatisticType}).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <TEntityMemberType> The type of statistic (e.g. static or variable) being contained here
 */
// NB: TEntity exists to facilitate genericization of constructor params
public interface EntityMembersOfType<TEntityMemberType extends HasId,
        TEntityMember extends EntityMemberOfType<TEntityMemberType>,
        TEntity extends Deletable>
            extends Iterable<TEntityMember>, Deletable {
    /**
     * Broadly, an entity placed here will have the same default values as its corresponding fields
     * (i.e. booleans will default to false, ints to 0, etc.).
     * <p>
     * For {@link CharacterVariableStatistic}s, the current value will be equivalent to the
     * maximum value.
     * <p>
     * If the entity has already been added, then nothing is changed.
     * <p>
     * <i>NB: This method creates a EntityMemberOfType with no data. To instantiate the
     * EntityMemberOfType with data, cf {@link #add(HasId, VariableCache)}</i>.
     * @param entityType The type of entity to add to this {@link Character} or {@link Item}
     * @throws IllegalArgumentException If and only if entityType is null
     * @throws EntityDeletedException If and only if the parent entity (e.g. the Character or Item)
     * has been deleted
     */
    void add(TEntityMemberType entityType) throws IllegalArgumentException, EntityDeletedException;

    /**
     * Broadly, an entity placed here will have the same default values as its corresponding fields
     * (i.e. booleans will default to false, ints to 0, etc.).
     * <p>
     * For {@link CharacterVariableStatistic}s, the current value will be equivalent to the
     * maximum value.
     * <p>
     * If the entity has already been added, then nothing is changed.
     * @param entityType The type of entity to add to this {@link Character}
     * @throws IllegalArgumentException If and only if entityType is null
     * @throws EntityDeletedException If and only if the parent entity (e.g. the Character or Item)
     * has been deleted
     */
    void add(TEntityMemberType entityType, VariableCache data)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param entityType - The type of the entity to retrieve
     * @return The entity of the corresponding type, if present; otherwise, null
     * @throws IllegalArgumentException If and only if entityType is null
     * @throws EntityDeletedException If and only if the parent entity (e.g. the Character or Item)
     * has been deleted
     */
    TEntityMember get(TEntityMemberType entityType) throws IllegalArgumentException, EntityDeletedException;

    /**
     * @return The number of entities in this collection
     */
    int size();

    /**
     * @param entityType - The type of entity to remove from this {@link Character}
     * @return True, if and only if the entity of the provided type was present
     * @throws IllegalArgumentException If and only if entityType is null
     * @throws EntityDeletedException If and only if the parent entity (e.g. the Character or Item)
     * has been deleted
     */
    boolean remove(TEntityMemberType entityType) throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param entityType - The type of statistic whose presence to verify
     * @return True, if and only if the item is present
     * @throws IllegalArgumentException If and only if statType is null
     * @throws EntityDeletedException If and only if the parent entity (e.g. the Character or Item)
     * has been deleted
     */
    boolean contains(TEntityMemberType entityType)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * Clears all entities
     * @throws EntityDeletedException If and only if the parent entity (e.g. the Character or Item)
     * has been deleted
     */
    void clear() throws EntityDeletedException;

    /**
     * @return A List of the entities present here
     * @throws EntityDeletedException If and only if the parent entity (e.g. the Character or Item)
     * has been deleted
     */
    List<TEntityMember> representation() throws EntityDeletedException;
}
