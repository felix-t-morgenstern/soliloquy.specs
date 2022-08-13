package soliloquy.specs.audio.entities;

import soliloquy.specs.common.shared.HasId;

/**
 * <b>SoundType</b>
 * <p>
 * This entity maps a SoundType Id to a filename pointing to an audio file.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface SoundType extends HasId {
    /**
     * @return The absolute path of the filename of the sound file corresponding to this SoundType
     */
    String absolutePath();

    /**
     * @return The default millisecond position at which a Sound of this type, when looping, will
     *         stop playing and restart at some point in the Sound (cf {@link
     *         #defaultLoopingRestartMs}).
     *         Can be null; if so, implies that SoundType is not looping by default.
     */
    Integer defaultLoopingStopMs() throws IllegalStateException;

    /**
     * @return The default millisecond position at which a Sound of this type, when looping, will
     *         restart at the start position in the loop (cf {@link #defaultLoopingStopMs}). Can be
     *         null;
     *         if so, implies that default looping restartMs is 0.
     */
    Integer defaultLoopingRestartMs() throws IllegalStateException;
}
