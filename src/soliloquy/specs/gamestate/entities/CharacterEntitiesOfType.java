package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.ReadableCollection;
import soliloquy.specs.common.shared.HasId;

/**
 * <b>CharacterEntitiesOfType</b>
 * <p>
 * A collection of the statistics for a {@link Character} of a certain type (e.g.
 * {@link soliloquy.specs.ruleset.entities.CharacterDepletableStatisticType} or
 * {@link soliloquy.specs.ruleset.entities.CharacterStaticStatisticType}).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <TEntityType> The type of statistic (e.g. static or depletable) being contained here
 */
public interface CharacterEntitiesOfType<TEntityType extends HasId,
        TEntity extends CharacterEntityOfType<TEntityType>>
            extends Iterable<TEntity>, Deletable {
    /**
     * Broadly, an entity placed here will have the same default values as its corresponding fields
     * (i.e. booleans will default to false, ints to 0, etc.).
     * <p>
     * For {@link CharacterDepletableStatistic}s, the current value will be equivalent to the
     * maximum value.
     * <p>
     * If the entity has already been added, then nothing is changed.
     * @param entityType The type of entity to add to this {@link Character}
     * @throws IllegalArgumentException If and only if entityType is null
     */
    void add(TEntityType entityType) throws IllegalArgumentException;

    /**
     * @param entityType - The type of the entity to retrieve
     * @return The entity of the corresponding type, if present; otherwise, null
     * @throws IllegalArgumentException If and only if entityType is null
     */
    TEntity get(TEntityType entityType) throws IllegalArgumentException;

    /**
     * @return The number of entities in this collection
     */
    int size();

    /**
     * @param entityType - The type of entity to remove from this {@link Character}
     * @return True, if and only if the entity of the provided type was present
     * @throws IllegalArgumentException If and only if entityType is null
     */
    boolean remove(TEntityType entityType) throws IllegalArgumentException;

    /**
     * @param entityType - The type of statistic whose presence to verify
     * @return True, if and only if the item is present
     * @throws IllegalArgumentException If and only if statType is null
     */
    boolean contains(TEntityType entityType) throws IllegalArgumentException;

    /**
     * Clears all entities
     */
    void clear();

    /**
     * @return A collection of the entities present here
     */
    ReadableCollection<TEntity> representation();
}
