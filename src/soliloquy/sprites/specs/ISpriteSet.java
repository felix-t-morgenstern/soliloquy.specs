package soliloquy.sprites.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

// TODO: Document this interface
public interface ISpriteSet extends ISoliloquyClass {
	ISprite getSprite(String type);
	
	ISprite getSprite(String type, String direction);
	
	/** 
	 * The idea is that a graphical transformation may be something like IncreaseSize, ShiftRed, Vibrate, etc.
	 * <p>
	 * The integer value would then be the magnitude (or presence/absence) of the change.
	 * @return The set of String-Integer combinations, where each String is the name of a potential graphical transformation, and the integer is its value.
	 */
	IMap<String,Integer> graphicalTransformations();
}
