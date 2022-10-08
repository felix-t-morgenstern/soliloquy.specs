package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.TileWallSegment;
import soliloquy.specs.graphics.assets.ImageAsset;

/**
 * <b>WallSegmentType</b>
 * <p>
 * This is a type of {@link TileWallSegment}, which exists on a {@link Tile}, at a given height. It
 * can block progress north (e.g. a wall on the north edge of a Tile), west (e.g. a wall on the
 * west edge of a Tile), or northwest (e.g. a corner piece, preventing diagonal movement). It has
 * an ImageAssetSet, allowing it to support things like whether it is fully vertically visible, or
 * whether only a small portion is displayed, to prevent the wall from obscuring the player's view
 * of the room the party is in.
 * <p>
 * It is worth noting that TileWallSegments can only be on the west, northwest, or north edges of a
 * Tile. If you want a TileWallSegment on the south edge of a Tile, place it on the north edge of
 * the Tile to the south of that initial Tile.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface WallSegmentType extends HasId, HasName {
    /**
     * This method allows this class to support things like whether it is fully vertically visible,
     * or whether only a small portion is displayed, to prevent the wall from obscuring the
     * player's view of the room the party is in.
     *
     * @return The ImageAssetSet for this WallSegmentType
     */
    ImageAsset imageAsset();

    /**
     * @return True, if and only if a TileWallSegment of this type blocks movement to the west
     */
    boolean blocksWest();

    /**
     * @return True, if and only if a TileWallSegment of this type blocks movement to the northwest
     */
    boolean blocksNorthwest();

    /**
     * @return True, if and only if a TileWallSegment of this type blocks movement to the north
     */
    boolean blocksNorth();
}
