package soliloquy.audio.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>SoundFactory</b>
 * <p>
 * Can create a Sound of a given type.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ISoundFactory extends ISoliloquyClass {
	/**
	 * @param soundTypeId - The Id of the type of Sound to make
	 * @return The Sound made, with a randomly-generated {@link soliloquy.common.specs.IEntityUuid} as its Id
	 * @throws IllegalArgumentException If and only if there exists no Sound with the specified soundTypeId
	 */
	ISound make(String soundTypeId) throws IllegalArgumentException;
	
	/**
	 * <i>(NB: This method overwrites previous mappings held in this class.)
	 * @param soundTypesToFilenamesMap - The mappings of sound types to filenames to add to this SoundFactory
	 * @throws IllegalArgumentException If and only if soundTypesToFilenamesMap is null, or any of the sound types or filenames are null or empty
	 */
	void registerSoundTypes(IMap<String,String> soundTypesToFilenamesMap) throws IllegalArgumentException;
}
