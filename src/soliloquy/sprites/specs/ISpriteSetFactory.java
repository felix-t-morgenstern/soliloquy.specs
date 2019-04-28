package soliloquy.sprites.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.sprites.spritefactory.specs.ISpriteParams;

// TODO: Document this interface
public interface ISpriteSetFactory extends ISoliloquyClass {
	// NB: The Map's index is to specify SpriteSet "type", and the inner Map is to specify
	// "direction". The String value is the Id of the Sprite type used for that SpriteSet.
	void registerSpriteSetType(String spriteSetTypeId, IMap<String,IMap<Integer,String>> params)
			throws IllegalArgumentException;

	boolean containsSpriteSetType(String spriteSetTypeId) throws IllegalArgumentException;

	boolean removeSpriteSetType(String spriteSetTypeId) throws IllegalArgumentException;

	ISpriteSet make(String spriteSetTypeId) throws IllegalArgumentException;
}
