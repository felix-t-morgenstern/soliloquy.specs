package soliloquy.specs.audio.factories;

import soliloquy.specs.audio.entities.Sound;
import soliloquy.specs.common.infrastructure.ReadableMap;
import soliloquy.specs.common.valueobjects.EntityUuid;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>SoundFactory</b>
 * <p>
 * Can create a Sound of a given type. Intended use is to contain an internal reference to a
 * {@link soliloquy.specs.common.infrastructure.Registry} of
 * {@link soliloquy.specs.audio.entities.SoundType}s.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface SoundFactory extends SoliloquyClass {
	/**
	 * @param soundTypeId - The Id of the type of Sound to make
	 * @return The Sound made, with a randomly-generated {@link EntityUuid}
	 * as its Id
	 * @throws IllegalArgumentException If and only if there exists no Sound with the specified
	 * soundTypeId
	 */
	Sound make(String soundTypeId) throws IllegalArgumentException;

	/**
	 * @param soundTypeId - The Id of the type of Sound to make
	 * @param entityUuid - The {@link soliloquy.specs.common.valueobjects.EntityUuid} of the Sound
	 *                      to make
	 * @return The Sound made, with the specified
	 * {@link soliloquy.specs.common.valueobjects.EntityUuid} as its Id
	 * @throws IllegalArgumentException If and only if there exists no Sound with the specified
	 * soundTypeId
	 */
	Sound make(String soundTypeId, EntityUuid entityUuid) throws IllegalArgumentException;
}
