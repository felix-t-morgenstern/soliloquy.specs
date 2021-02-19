package soliloquy.specs.common.persistence;

import soliloquy.specs.common.infrastructure.Map;

/**
 * <b>PersistentMapHandler</b>
 * <p>
 * This class handles the persistence of {@link Map}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface PersistentMapHandler extends PersistentValueTypeHandler<Map> {
    /**
     * @param valueType - An interface name with fully qualified generic types
     * @return A Pair, to be used as an archetype in generated {@link Map}s
     * @throws IllegalArgumentException If and only if valueType is null, empty, or one of its
     * specified types is not a valid type
     */
    Map generateArchetype(String valueType) throws IllegalArgumentException;
}
