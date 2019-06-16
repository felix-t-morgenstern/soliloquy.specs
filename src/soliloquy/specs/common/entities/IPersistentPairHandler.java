package soliloquy.specs.common.entities;

import soliloquy.specs.common.valueobjects.IPair;

/**
 * <b>PersistentPairHandler</b>
 * <p>
 * This class handles the persistence of {@link IPair}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface IPersistentPairHandler extends IPersistentValueTypeHandler<IPair> {
    /**
     * @param valueType - An interface name with fully qualified generic types
     * @return A Pair, to be used as an archetype in generated {@link IPair}s
     * @throws IllegalArgumentException If and only if valueType is null, empty, or one of its
     * specified types is not a valid type
     */
    IPair generateArchetype(String valueType) throws IllegalArgumentException;
}
