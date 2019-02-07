package soliloquy.sprites.specs;

import soliloquy.common.specs.IMap;

/**
 * <b>GraphicalTransformations</b>
 * <p>
 * This is a set of String-Integer combinations, where each String is the name of a potential graphical transformation, and the integer is its value.
 * <p>
 * The idea is that a graphical transformation may be something like IncreaseSize, ShiftRed, Vibrate, etc.
 * <p>
 * The integer value would then be the magnitude (or presence/absence) of the change.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IGraphicalTransformations extends IMap<String,Integer> {
	// TODO: Document this class more thoroughly.
}
