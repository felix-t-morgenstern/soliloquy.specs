package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.ReadableCollection;
import soliloquy.specs.common.infrastructure.ReadableMap;

/**
 * <b>TileFixtures</b>
 * <p>
 * This class handles TileWallSegments present on a Tile. It exists to handle invariants which must
 * be enforced, since a Tile should know its TileWallSegments, and TileWallSegments should know
 * their Tile. To be more specific, every TileWallSegment on a Tile should know that it belongs to
 * that Tile, and vice-versa.
 * <p>
 * This class also supports providing a <i>representation</i> of the TileWallSegments on this Tile;
 * i.e., a Map containing all of those TileWallSegments. <u>Editing the Map provided by
 * getRepresentation will not change the TileWallSegments on the Tile.</u> To do
 * that, use the add and remove methods, also provided.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileWallSegments extends Deletable {
    /**
     * <i>NB: This is only supposed to be a REPRESENTATION of the TileWallSegments on this Tile. To
     * add or remove a TileWallSegment, use the other methods specified.</i>
     * @return A representation of the TileWallSegments on this Tile.
     * @throws IllegalStateException If this TileWallSegments or its Tile have been deleted
     */
    ReadableMap<TileWallSegmentDirection, ReadableCollection<TileWallSegment>> representation()
            throws IllegalStateException;

    /**
     * @param tileWallSegmentDirection - The direction the TileWallSegment will face
     * @param tileWallSegment - The {@link TileWallSegment} to add to this Tile
     * @throws IllegalArgumentException If and only if tileWallSegment is null, or if
     * tileWallSegmentDirection is null, UNKNOWN, or NOT_FOUND
     * @throws IllegalStateException If this TileWallSegments or its Tile have been deleted
     */
    void add(TileWallSegmentDirection tileWallSegmentDirection, TileWallSegment tileWallSegment)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param tileWallSegment - The TileWallSegment to remove from this Tile
     * @return True, if and only if this TileWallSegment was present in this Tile, and was
     * therefore removed
     * @throws IllegalArgumentException If and only if tileWallSegment is null
     * @throws IllegalStateException If this TileWallSegments or its Tile have been deleted
     */
    boolean remove(TileWallSegment tileWallSegment)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param tileWallSegment - The TileWallSegment whose presence to verify
     * @return True, if and only if tileWallSegment is present in this TileWallSegments
     * @throws IllegalArgumentException If and only if tileWallSegment is null
     * @throws IllegalStateException If this TileWallSegments or its Tile have been deleted
     */
    boolean contains(TileWallSegment tileWallSegment)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param tileWallSegment - The {@link TileWallSegment} whose {@link TileWallSegmentDirection}
     *                        to retrieve
     * @return The {@link TileWallSegmentDirection} of the specified {@link TileWallSegment}
     * (Returns {@link TileWallSegmentDirection#NOT_FOUND} if tileWallSegment is not present.)
     * @throws IllegalArgumentException If and only if tileWallSegment is null
     * @throws IllegalStateException If this TileWallSegments or its Tile have been deleted
     */
    TileWallSegmentDirection getDirection(TileWallSegment tileWallSegment)
            throws IllegalArgumentException, IllegalStateException;
}
