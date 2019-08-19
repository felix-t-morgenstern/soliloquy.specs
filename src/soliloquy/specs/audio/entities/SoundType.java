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
    public String filename();
}
