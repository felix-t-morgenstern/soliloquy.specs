package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.common.valueobjects.Coordinate2d;
import soliloquy.specs.gamestate.entities.GameZone;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.WallSegment;
import soliloquy.specs.gamestate.entities.WallSegmentDirection;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.graphics.assets.ImageAsset;

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
     * A north-facing Segment goes between the north edge of one Tile and the south edge of another.
     * A west-facing Segment goes between the west edge of one Tile and the east edge of another. A
     * northwest-facing Segment goes in a corner between up to four Tiles. C.f.
     * {@link GameZone#getSegments} for an explanation of how direction corresponds with location.
     *
     * @return The direction of this Segment
     * @throws EntityDeletedException If this WallSegment has been deleted
     */
    WallSegmentDirection direction() throws EntityDeletedException;

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
