package soliloquy.specs.sprites.entities;

import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.common.shared.HasId;

// TODO: Document this interface
public interface SpriteSet extends HasId {
	Sprite getSprite(String type);
	
	Sprite getSprite(String type, String direction);
	
	/** 
	 * The idea is that a graphical transformation may be something like IncreaseSize, ShiftRed,
	 * Vibrate, etc.
	 * <p>
	 * The integer value would then be the magnitude (or presence/absence) of the change.
	 * @return The set of String-Integer combinations, where each String is the name of a potential
	 * graphical transformation, and the integer is its value.
	 */
	Map<String,Integer> graphicalTransformations();
}
