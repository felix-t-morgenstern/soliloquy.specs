package soliloquy.audio.specs;

import soliloquy.common.specs.IMap;

/**
 * <b>SoundsPlaying</b>
 * <p>
 * A Numbered Set of all Sounds playing. (Sounds are identified by their Numerical Ids.)
 * <p>
 * <i>Note that this includes Sounds which are currently paused, but not Sounds which have been stopped.</i>
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ISoundsPlaying extends IMap<Integer,ISound> {
}
