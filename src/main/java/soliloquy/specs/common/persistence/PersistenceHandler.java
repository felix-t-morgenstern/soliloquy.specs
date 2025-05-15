package soliloquy.specs.common.persistence;

import java.util.List;

/**
 * <b>PersistenceHandler</b>
 * <p>
 * This class takes string representations of a persistent value (e.g. an integer, a collection of
 * Strings, some JSON blob, etc.), and transforms them into persistent values of the proper type in
 * Java; and vice-versa.
 * <p>
 * This class contains TypeHandlers, which translate specific string representations of values to
 * the actual value and vice-versa. If you want to process a type which is not yet available in the
 * PersistenceHandler, you will have to create a TypeHandler for that type, and register it
 * with this class.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface PersistenceHandler {
    /**
     * @param typeHandler The TypeHandler to be added
     * @throws IllegalArgumentException If typeHandler is null
     */
    void addTypeHandler(TypeHandler typeHandler) throws IllegalArgumentException;

    /**
     * @param type The String representation of the type of the TypeHandler to remove
     * @return True, if and only if a TypeHandler of that type existed
     */
    boolean removeTypeHandler(String type);

    /**
     * @param type The String representation of the type of the TypeHandler to be retrieved
     * @return The TypeHandler of the specified type
     * @throws IllegalArgumentException If a TypeHandler of this type does not exist
     */
    <T> TypeHandler<T> getTypeHandler(String type) throws IllegalArgumentException;

    /**
     * @return A new List of the parameter types with registered TypeHandlers in this
     *         PersistenceHandler
     */
    List<String> typesHandled();
}
