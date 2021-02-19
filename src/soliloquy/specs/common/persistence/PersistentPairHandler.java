package soliloquy.specs.common.persistence;

import soliloquy.specs.common.infrastructure.Pair;

/**
 * <b>PersistentPairHandler</b>
 * <p>
 * This class handles the persistence of {@link Pair}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface PersistentPairHandler extends PersistentValueTypeHandler<Pair> {
    /**
     * @param valueTypes - Comma-delimited interface names with fully qualified generic types
     * @return A Pair, to be used as an archetype in generated {@link Pair}s
     * @throws IllegalArgumentException If and only if valueType is null, empty, or one of its
     * specified types is not a valid type
     */
    Pair generateArchetype(String valueTypes) throws IllegalArgumentException;
}
