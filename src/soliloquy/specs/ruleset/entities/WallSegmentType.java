package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.TileWallSegment;
import soliloquy.specs.graphics.assets.Sprite;

// TODO: Document (and perhaps expound upon) this interface
public interface WallSegmentType extends HasId {
	TileWallSegment generate(Tile tile);

	Sprite sprite();

	boolean blocksWest();

	boolean blocksNorthwest();

	boolean blocksNorth();
}
