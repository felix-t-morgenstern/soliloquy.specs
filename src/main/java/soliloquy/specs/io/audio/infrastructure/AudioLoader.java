package soliloquy.specs.io.audio.infrastructure;

import java.util.Map;

/**
 * <b>AudioLoader</b>
 * <p>
 * This class is used to identify a directory, and load its audio files into
 * {@link soliloquy.specs.io.audio.Audio#getSoundType}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface AudioLoader {
    /**
     * Generated SoundTypes are automatically added to a repository fed into this class' constructor
     *
     * @param relativePath           The relative path, from the code source of this very class,
     *                               specifying the folder from which to draw up new SoundTypes.
     * @param idsForFilenames        The Ids corresponding to all filenames to be searched for
     *                               within the directory identified by relativePath
     * @param defaultLoopStopMsById  The millisecond mark at which provided SoundTypes default to
     *                               stopping their loops and move to the provided restarting Ms
     *                               (see next param)
     * @param defaultLoopRestartByMs The millisecond mark at which provided SoundTypes default to
     *                               resuming their loops once they have stopped one repetition
     * @throws IllegalArgumentException If and only if relativePath or idsForFilenames are null, or
     *                                  defaultLoopStopMsById is null, or defaultLoopRestartByMs is
     *                                  null
     */
    void loadFromDirectory(String relativePath, Map<String, String> idsForFilenames,
                           Map<String, Integer> defaultLoopStopMsById,
                           Map<String, Integer> defaultLoopRestartByMs)
            throws IllegalArgumentException;
}
