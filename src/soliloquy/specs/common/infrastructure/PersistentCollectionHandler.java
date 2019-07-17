package soliloquy.specs.common.infrastructure;

/**
 * <b>PersistentCollectionHandler</b>
 * <p>
 * This class handles the persistence of {@link Collection}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface PersistentCollectionHandler extends PersistentValueTypeHandler<Collection> {
    /**
     * @param valueType - An interface name with fully qualified generic types
     * @return A Pair, to be used as an archetype in generated {@link Collection}s
     * @throws IllegalArgumentException If and only if valueType is null, empty, or one of its
     * specified types is not a valid type
     */
    Collection generateArchetype(String valueType) throws IllegalArgumentException;
}
