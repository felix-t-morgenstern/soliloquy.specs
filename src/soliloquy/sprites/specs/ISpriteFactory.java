package soliloquy.sprites.specs;

import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.sprites.spritefactory.specs.ISpriteParams;

// TODO: Document this interface
public interface ISpriteFactory extends ISoliloquyClass {
	void registerSpriteType(String spriteTypeId, ISpriteParams params)
			throws IllegalArgumentException;

	boolean containsSpriteType(String spriteTypeId) throws IllegalArgumentException;

	boolean removeSpriteType(String spriteTypeId) throws IllegalArgumentException;

	ISprite make(String spriteTypeId) throws IllegalArgumentException;
}
