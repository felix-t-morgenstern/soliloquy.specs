package soliloquy.common.specs;

/**
 * <b>PersistentCollectionHandler</b>
 * <p>
 * This class handles the persistence of {@link ICollection}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface IPersistentCollectionHandler extends IPersistentValueTypeHandler<ICollection> {
    /**
     * @param valueType - An interface name with fully qualified generic types
     * @return A Pair, to be used as an archetype in generated {@link ICollection}s
     * @throws IllegalArgumentException If and only if valueType is null, empty, or one of its
     * specified types is not a valid type
     */
    ICollection generateArchetype(String valueType) throws IllegalArgumentException;
}
