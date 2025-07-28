package soliloquy.specs.common.persistence;

import java.util.List;
import java.util.Set;

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
     * @param clazz       The class whose TypeHandler to add
     * @throws IllegalArgumentException If and only if clazz or typeHandler are null
     */
    <T> void addTypeHandler(Class<T> clazz, TypeHandler<T> typeHandler)
            throws IllegalArgumentException;

    /**
     * @param clazz The class whose TypeHandler to remove
     * @return True, if and only if a TypeHandler of that type existed
     */
    <T> boolean removeTypeHandler(Class<T> clazz);

    /**
     * It is presumed that class names will come from {@link Class#getCanonicalName()}. This method
     * accepts String inputs to facilitate its use by {@link TypeHandler#read(String)} to retrieve
     * the proper TypeHandler for a given type, stored in text.
     *
     * @param className The name of the class whose TypeHandler to retrieve
     * @return The TypeHandler of the specified class
     * @throws IllegalArgumentException If and only if a TypeHandler of this class does not exist
     */
    <T> TypeHandler<T> getTypeHandler(String className) throws IllegalArgumentException;

    /**
     * @return A new Set of all the Types handled
     */
    Set<Class> typesHandled();
}
