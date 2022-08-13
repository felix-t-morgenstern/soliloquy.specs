package soliloquy.specs.gamestate.entities;

import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.ruleset.entities.FixtureType;

public interface HasTileOffsets {
    /**
     * (NB: The default value is initially defined in {@link FixtureType#defaultXTileWidthOffset}
     *
     * @return The x offset, where a Tile's width is defined as 1.0f
     * @throws IllegalStateException  If it has no FixtureType
     * @throws EntityDeletedException If this TileFixture has been deleted
     */
    float getXTileWidthOffset() throws IllegalStateException, EntityDeletedException;

    /**
     * (NB: The default value is initially defined in {@link FixtureType#defaultYTileHeightOffset}
     *
     * @return The x offset, where a Tile's height is defined as 1.0f
     * @throws IllegalStateException  If it has no FixtureType
     * @throws EntityDeletedException If this TileFixture has been deleted
     */
    float getYTileHeightOffset() throws IllegalStateException, EntityDeletedException;

    /**
     * This value can effectively be anything; having values that are much greater than 0f or 1f
     * are generally discouraged, though, since objects should generally visually appear on the
     * Tiles in which they are located.
     *
     * @param xTileWidthOffset The x offset of this entity, defined in terms of the width of a Tile
     * @throws IllegalStateException  If it has no FixtureType
     * @throws EntityDeletedException If this TileFixture has been deleted
     */
    void setXTileWidthOffset(float xTileWidthOffset)
            throws IllegalStateException, EntityDeletedException;

    /**
     * This value can effectively be anything; having values that are much greater than 0f or 1f
     * are generally discouraged, though, since objects should generally visually appear on the
     * Tiles in which they are located.
     *
     * @param yTileHeightOffset The x offset of this entity, defined in terms of the width of a
     *                          Tile
     * @throws IllegalStateException  If it has no FixtureType
     * @throws EntityDeletedException If this TileFixture has been deleted
     */
    void setYTileHeightOffset(float yTileHeightOffset)
            throws IllegalStateException, EntityDeletedException;
}
