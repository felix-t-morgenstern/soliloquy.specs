package soliloquy.specs.gamestate.entities.shared;

import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.ruleset.entities.shared.HasDefaultTileOffsets;

public interface HasTileOffsets {
    /**
     * (NB: The default value is initially defined in
     * {@link HasDefaultTileOffsets#defaultTileOffset()}
     *
     * @return The offset of this object from the center of its Tile
     * @throws IllegalStateException  If this object has no type
     * @throws EntityDeletedException If this object has been deleted
     */
    Vertex getTileOffset() throws IllegalStateException, EntityDeletedException;

    /**
     * This value can effectively be anything; having values that are much greater than 0f or 1f
     * are generally discouraged, though, since objects should generally visually appear on the
     * Tiles in which they are located.
     * <p>
     * See {@link HasDefaultTileOffsets#defaultTileOffset()} for information on tile offsets.
     *
     * @param tileOffset The offset of this entity, defined in terms of the width and height
     *                   (respectively) of a Tile
     * @throws IllegalArgumentException If and only if tileOffset is null
     * @throws IllegalStateException    If this object has no type
     * @throws EntityDeletedException   If this object has been deleted
     */
    void setTileOffset(Vertex tileOffset)
            throws IllegalArgumentException, IllegalStateException, EntityDeletedException;
}
