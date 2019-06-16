package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.IHasId;
import soliloquy.specs.sprites.entities.ISprite;

// TODO: Document (and perhaps expound upon) this interface
public interface IWallSegmentType extends IHasId {
	ISprite getSprite();
}
