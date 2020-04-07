package soliloquy.specs.audio.infrastructure;

import soliloquy.specs.common.shared.SoliloquyClass;

import java.util.Map;
import java.util.Set;

/**
 * <b>AudioLoader</b>
 * <p>
 * This class is used to identify a directory, and load its audio files into
 * {@link soliloquy.specs.audio.Audio#soundTypes}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface AudioLoader extends SoliloquyClass {
    /**
     * @return A (mutable) Set of filetypes which can be recognized as audio files (e.g. "mp3",
     * "wav")
     */
    Set<String> filetypes();

    /**
     * Specifies the default looping stop positions (in ms) for the provided SoundType Ids. (NB:
     * Where the default loop stopping ms position is 0, this implies that Sounds of that type do
     * not loop by default.)
     * <p>
     * Additionally, if defaultLoopingStopMsForIds contains any Ids already set, those previous
     * values are overwritten.
     * @param defaultLoopingStopMsForIds - A Map, where the keys are SoundType Ids, and the values
     *                                   are the default loop stopping millisecond positions.
     * @throws IllegalArgumentException If and only if defaultLoopingStopMsForIds is null
     */
    void setDefaultLoopingStopMsForIds(Map<String,Integer> defaultLoopingStopMsForIds)
            throws IllegalArgumentException;

    /**
     * Specifies the default looping restarting positions (in ms) for the provided SoundType Ids.
     * (NB: Where the default loop restarting ms position is 0, this implies that Sounds of that
     * type default to restarting their loops from the very beginning, if they loop.)
     * <p>
     * Additionally, if defaultLoopingRestartMsForIds contains any Ids already set, those previous
     * values are overwritten.
     * @param defaultLoopingRestartMsForIds - A Map, where the keys are SoundType Ids, and the
     *                                      values are the default loop restarting millisecond
     *                                      positions.
     * @throws IllegalArgumentException If and only if defaultLoopingRestartMsForIds is null
     */
    void setDefaultLoopingRestartMsForIds(Map<String,Integer> defaultLoopingRestartMsForIds)
            throws IllegalArgumentException;

    /**
     * Any filenames whose extensions match those specified in {@link #filetypes()} are checked
     * against idsForFilenames; for any matches, new SoundTypes are generated, using the looping
     * information specified by setDefaultLoopingStopMsForIds and setDefaultLoopingRestartMsForIds,
     * and added to {@link soliloquy.specs.audio.Audio#soundTypes}.
     * @param relativePath The relative path, from the code source of this very class, specifying
     *                     the folder from which to draw up new SoundTypes.
     * @param idsForFilenames - The Ids corresponding to all filenames to be searched for within
     *                        the directory identified by relativePath
     * @throws IllegalArgumentException If and only if relativePath or idsForFilenames are null
     */
    void loadFromDirectory(String relativePath, Map<String,String[]> idsForFilenames)
            throws IllegalArgumentException;
}
