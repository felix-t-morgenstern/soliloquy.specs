package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.sprites.specs.ISprite;

public interface IWallSegmentType extends IGameEntity, ISoliloquyClass {
	ISprite getSprite();
}
