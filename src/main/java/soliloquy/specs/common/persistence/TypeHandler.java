package soliloquy.specs.common.persistence;

/**
 * <b>TypeHandler</b>
 * <p>
 * This object translates objects of the specified type (e.g., Integers) into a String, and from a
 * String back into an object of the specified type. It is intended to aid in saving values to a
 * save file, and reading them back from that save file.
 *
 * @param <T> The type of object which is read from a String and turned back into a String by this
 *            handler
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TypeHandler<T> {
    /**
     * @param serializedValue A String representation of the value to be read
     * @return The translation of the String into the value type specified
     * @throws IllegalArgumentException If serializedValue is null
     */
    <TInstance extends T> TInstance read(String serializedValue) throws IllegalArgumentException;

    /**
     * @param value The value to be translated into a String
     * @return The String representation of the value of the type specified
     */
    String write(T value);
}
