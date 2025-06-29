package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.WallSegment;
import soliloquy.specs.gamestate.entities.WallSegmentOrientation;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.io.graphics.assets.ImageAsset;

/**
 * <b>WallSegmentType</b>
 * <p>
 * This is a type of {@link WallSegment}, which exists on a {@link Tile}, at a given height. It
 * can block progress north (e.g. a wall on the north edge of a Tile), west (e.g. a wall on the
 * west edge of a Tile), or northwest (e.g. a corner piece, preventing diagonal movement). It has
 * an ImageAssetSet, allowing it to support things like whether it is fully vertically visible, or
 * whether only a small portion is displayed, to prevent the wall from obscuring the player's view
 * of the room the party is in.
 * <p>
 * It is worth noting that WallSegments can only be on the west, northwest, or north edges of a
 * Tile. If you want a WallSegment on the south edge of a Tile, place it on the north edge of the
 * Tile to the south of that initial Tile.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface WallSegmentType extends HasId, HasName {
    /**
     * @return The orientation of this Segment (i.e., horizontal, vertical, corner)
     * @throws EntityDeletedException If this WallSegment has been deleted
     */
    WallSegmentOrientation orientation() throws EntityDeletedException;

    /**
     * This method allows this class to support things like whether it is fully vertically visible,
     * or whether only a small portion is displayed, to prevent the wall from obscuring the player's
     * view of the room the party is in.
     *
     * @return The ImageAssetSet for this WallSegmentType
     */
    ImageAsset imageAsset();

    /**
     * @return True, if and only if a WallSegment of this type blocks movement
     */
    boolean blocksMovement();

    /**
     * @return True, if and only if a WallSegment of this type blocks sight
     */
    boolean blocksSight();
}
