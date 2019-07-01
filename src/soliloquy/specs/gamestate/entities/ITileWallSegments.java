package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.IReadOnlyCollection;

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
public interface ITileWallSegments extends IDeletable {
    /**
     * <i>NB: This is only supposed to be a REPRESENTATION of the Items present in this Character's
     * inventory. To add or remove Items, use the other methods specified.</i>
     * @return A representation of this Character's inventory.
     * @throws IllegalStateException If this Character does not have a GameZone, or if this
     * Character has been deleted, or if it has no Id
     */
    IReadOnlyCollection<ITileWallSegment> representation() throws IllegalStateException;

    /**
     * @param tileWallSegment - The TileWallSegment to add to this Tile
     * @throws IllegalArgumentException If and only if tileWallSegment is null, or exists elsewhere
     * @throws IllegalStateException If this Character does not have a GameZone, or if this
     * Character has been deleted, or if it has no Id
     */
    void add(ITileWallSegment tileWallSegment)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param tileWallSegment - The TileWallSegment to remove from this Tile
     * @return True, if and only if this TileWallSegment was present in this Tile, and was
     * therefore removed
     * @throws IllegalArgumentException If and only if tileWallSegment is null
     * @throws IllegalStateException If this Character does not have a GameZone, or if this
     * Character has been deleted, or if it has no Id
     */
    boolean remove(ITileWallSegment tileWallSegment)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param tileWallSegment - The TileWallSegment whose presence to verify
     * @return True, if and only if tileWallSegment is present in this TileWallSegments
     * @throws IllegalArgumentException If and only if tileWallSegment is null
     * @throws IllegalStateException If tileWallSegment has been deleted
     */
    boolean contains(ITileWallSegment tileWallSegment)
            throws IllegalArgumentException, IllegalStateException;
}
