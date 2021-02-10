package soliloquy.specs.ruleset.entities;

/**
 * <b>TileObject</b>
 * <p>
 * This is an object--either a {@link FixtureType} or an {@link ItemType}--which can exist on a
 * {@link soliloquy.specs.gamestate.entities.Tile}, and which has default offsets, defined by
 * percentages of the width and height of a Tile.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface HasDefaultTileOffsets {
    /**
     * A Tile's width is defined here as 1.0f
     * @return The default offset, in the percentage of the width of a Tile, at which TileFixtures
     * of this FixtureType are placed.
     */
    float defaultXTileWidthOffset();

    /**
     * A Tile's height is defined here as 1.0f
     * @return The default offset, in the percentage of the height of a Tile, at which TileFixtures
     * of this FixtureType are placed.
     */
    float defaultYTileHeightOffset();
}
