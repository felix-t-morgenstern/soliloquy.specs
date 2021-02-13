package soliloquy.specs.common.infrastructure;

/**
 * <b>PersistentListHandler</b>
 * <p>
 * This class handles the persistence of {@link List}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface PersistentListHandler extends PersistentValueTypeHandler<List> {
    /**
     * @param valueTypes - Comma-delimited interface names with fully qualified generic types
     * @return A Pair, to be used as an archetype in generated {@link List}s
     * @throws IllegalArgumentException If and only if valueType is null, empty, or one of its
     * specified types is not a valid type
     */
    List generateArchetype(String valueTypes) throws IllegalArgumentException;
}
