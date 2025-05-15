package soliloquy.specs.audio.factories;

import soliloquy.specs.audio.entities.SoundType;

/**
 * <b>SoundType</b>
 * <p>
 * This class creates {@link SoundType} entities.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface SoundTypeFactory {
    /**
     * @param id                      The Id of the SoundType to be created
     * @param absolutePath            The absolute path of the filename corresponding to this
     *                                SoundType
     * @param defaultLoopingStopMs    The default loop stop position in milliseconds (NB: if this
     *                                value is null, it is assumed that
     *                                {@link soliloquy.specs.audio.entities.Sound}s of this type
     *                                will
     *                                not loop by default.)
     * @param defaultLoopingRestartMs The default loop restarting position in milliseconds (NB:
     *                                if this value is null, it is assumed that
     *                                {@link soliloquy.specs.audio.entities.Sound}s of this type
     *                                will restart at 0ms, if they loop.)
     * @return A SoundType with the provided values
     * @throws IllegalArgumentException If and only if id or path are null or empty, or if
     *                                  defaultLoopingStopMs or defaultLoopingRestartMs are negative
     */
    SoundType make(String id, String absolutePath, Integer defaultLoopingStopMs,
                   Integer defaultLoopingRestartMs) throws IllegalArgumentException;
}
