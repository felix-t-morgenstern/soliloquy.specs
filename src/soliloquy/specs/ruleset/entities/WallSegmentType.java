package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.sprites.entities.Sprite;

// TODO: Document (and perhaps expound upon) this interface
public interface WallSegmentType extends HasId {
	Sprite getSprite();
	boolean blocksWest();
	boolean blocksNorthwest();
	boolean blocksNorth();
}
