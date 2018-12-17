package soliloquy.audio.specs;

import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>SoundsLibrary</b>
 * <p>
 * Can create a Sound of a given type.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ISoundsLibrary extends ISoliloquyClass {
	/**
	 * @param soundTypeId - The Id of the type of Sound to create
	 * @return The Id of the Sound created
	 * @throws IllegalArgumentException If and only if there exists no Sound with the specified soundTypeId
	 */
	int createSound(String soundTypeId) throws IllegalArgumentException;
}
