package soliloquy.specs.common.entities;

import soliloquy.specs.common.shared.IHasOneGenericParam;

/**
 * <b>PersistentValueTypeHandler</b>
 * <p>
 * This object translates objects of the specified type (e.g. Integers) into a String, and from a
 * String back into an object of the specified type.
 * <p>
 * It is intended to aid in saving values to a save file, and reading them back from that save
 * file.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <T> The type of object which is read from a String and turned back into a String by this
 * handler
 */
public interface IPersistentValueTypeHandler<T> extends IHasOneGenericParam<T> {
	/**
	 * @param serializedValue - A String representation of the value to be read
	 * @return The translation of the String into the value type specified
	 * @throws IllegalArgumentException If serializedValue is null
	 */
	T read(String serializedValue) throws IllegalArgumentException;
	
	/**
	 * @param value - The value to be translated into a String
	 * @return The String representation of the value of the type specified
	 */
	String write(T value);
}
