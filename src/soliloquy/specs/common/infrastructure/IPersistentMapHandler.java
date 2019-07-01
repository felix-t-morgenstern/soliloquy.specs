package soliloquy.specs.common.infrastructure;

/**
 * <b>PersistentMapHandler</b>
 * <p>
 * This class handles the persistence of {@link IMap}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface IPersistentMapHandler extends IPersistentValueTypeHandler<IMap> {
    /**
     * @param valueType - An interface name with fully qualified generic types
     * @return A Pair, to be used as an archetype in generated {@link IMap}s
     * @throws IllegalArgumentException If and only if valueType is null, empty, or one of its
     * specified types is not a valid type
     */
    IMap generateArchetype(String valueType) throws IllegalArgumentException;
}
