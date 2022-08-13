package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.common.infrastructure.Pair;

/**
 * <b>TileWallSegments</b>
 * <p>
 * This class handles TileWallSegments present on a Tile. It exists to handle invariants which must
 * be enforced, since a Tile should know its TileWallSegments, and TileWallSegments should know
 * their Tile. To be more specific, every TileWallSegment on a Tile should know that it belongs to
 * that Tile, and vice-versa.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileWallSegments
        extends Iterable<Pair<TileWallSegmentDirection,
        Pair<TileWallSegment, TileWallSegmentDimensions>>>, Deletable {
    /**
     * <i>NB: This is only supposed to be a REPRESENTATION of the TileWallSegments on this Tile. To
     * add or remove a TileWallSegment, use the other methods specified.</i>
     *
     * @return A representation of the TileWallSegments on this Tile.
     * @throws IllegalStateException If this TileWallSegments or its Tile have been deleted
     */
    Map<TileWallSegmentDirection, Map<TileWallSegment, TileWallSegmentDimensions>>
    representation()
            throws IllegalStateException;

    /**
     * @param direction The direction the TileWallSegment will face
     * @param segment   The {@link TileWallSegment} to add to this Tile
     * @param height    The height of the newly-added segment
     * @throws IllegalArgumentException If and only if segment is null, or if direction is null,
     *                                  UNKNOWN, or NOT_FOUND
     * @throws IllegalStateException    If this TileWallSegments or its Tile have been deleted
     */
    void add(TileWallSegmentDirection direction, TileWallSegment segment, int height)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param direction The direction the TileWallSegment will face
     * @param segment   The {@link TileWallSegment} to add to this Tile
     * @param height    The height of the newly-added segment
     * @param zIndex    The z index of the TileWallSegment to be added
     * @throws IllegalArgumentException If and only if segment is null, or if direction is null,
     *                                  UNKNOWN, or NOT_FOUND
     * @throws IllegalStateException    If this TileWallSegments or its Tile have been deleted
     */
    void add(TileWallSegmentDirection direction, TileWallSegment segment, int height, int zIndex)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param segment The TileWallSegment whose z index to retrieve
     * @return The z index of the provided segment; if not present, then returns null
     * @throws IllegalArgumentException If and only if tileWallSegment is null
     * @throws IllegalStateException    If this TileWallSegments or its Tile have been deleted
     */
    Integer getZIndex(TileWallSegment segment)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param segment The TileWallSegment whose z index to set
     * @param zIndex  The z index to set for segment
     * @throws IllegalArgumentException If and only if tileWallSegment is null, or not present in
     *                                  this object
     * @throws IllegalStateException    If this TileWallSegments or its Tile have been deleted
     */
    void setZIndex(TileWallSegment segment, int zIndex)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param segment The TileWallSegment whose z index to retrieve
     * @return The height of the provided segment; if not present, then returns null
     * @throws IllegalArgumentException If and only if tileWallSegment is null
     * @throws IllegalStateException    If this TileWallSegments or its Tile have been deleted
     */
    Integer getHeight(TileWallSegment segment)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param segment The TileWallSegment whose z index to set
     * @param height  The height to set for segment
     * @throws IllegalArgumentException If and only if tileWallSegment is null, or not present in
     *                                  this object
     * @throws IllegalStateException    If this TileWallSegments or its Tile have been deleted
     */
    void setHeight(TileWallSegment segment, int height)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param tileWallSegment The TileWallSegment to remove from this Tile
     * @return True, if and only if this TileWallSegment was present in this Tile, and was
     *         therefore removed
     * @throws IllegalArgumentException If and only if tileWallSegment is null
     * @throws IllegalStateException    If this TileWallSegments or its Tile have been deleted
     */
    boolean remove(TileWallSegment tileWallSegment)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param tileWallSegment The TileWallSegment whose presence to verify
     * @return True, if and only if tileWallSegment is present in this TileWallSegments
     * @throws IllegalArgumentException If and only if tileWallSegment is null
     * @throws IllegalStateException    If this TileWallSegments or its Tile have been deleted
     */
    boolean contains(TileWallSegment tileWallSegment)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @return The number of TileWallSegments on this Tile
     * @throws IllegalStateException If this TileWallSegments or its Tile have been deleted
     */
    int size() throws IllegalStateException;

    /**
     * @param direction The direction for which to retrieve the number of wall segments
     * @return The number of TileWallSegments on this Tile in the specified direction
     * @throws IllegalStateException If this TileWallSegments or its Tile have been deleted
     */
    int size(TileWallSegmentDirection direction) throws IllegalStateException;

    /**
     * @param tileWallSegment The {@link TileWallSegment} whose {@link TileWallSegmentDirection}
     *                        to retrieve
     * @return The {@link TileWallSegmentDirection} of the specified {@link TileWallSegment}
     *         (Returns {@link TileWallSegmentDirection#NOT_FOUND} if tileWallSegment is not
     *         present.)
     * @throws IllegalArgumentException If and only if tileWallSegment is null
     * @throws IllegalStateException    If this TileWallSegments or its Tile have been deleted
     */
    TileWallSegmentDirection getDirection(TileWallSegment tileWallSegment)
            throws IllegalArgumentException, IllegalStateException;
}
