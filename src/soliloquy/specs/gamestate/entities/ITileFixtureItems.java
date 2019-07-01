package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.IReadOnlyCollection;

/**
 * <b>TileFixtureItems</b>
 * <p>
 * This class handles Items contained in a TileFixture. It exists to handle invariants which must
 * be enforced, since a TileFixture should know its contained Items, and Items should know the
 * TileFixture in which they are contained.
 * <p>
 * This class also supports providing a <i>representation</i> of the Items in this TileFixture;
 * i.e., a Map containing all of those Items. <u>Editing the Map provided by
 * getContainedItemsRepresentation will not change the Items in this TileFixture.</u> To do that,
 * use the add and remove methods, also provided.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ITileFixtureItems extends IDeletable {
    /**
     * <i>NB: This is only supposed to be a REPRESENTATION of the Items present in this TileFixture.
     * To add or remove Items, use the other methods specified.</i>
     * @return A Collection of the Items in this TileFixture.
     * @throws UnsupportedOperationException If this TileFixture's FixtureType is not a container
     * @throws IllegalStateException If this TileFixture has been deleted
     */
    IReadOnlyCollection<IItem> representation()
            throws UnsupportedOperationException, IllegalStateException;

    /**
     * @param item - The Item to add to this TileFixture
     * @throws IllegalArgumentException If and only if item is null, or item exists elsewhere
     * @throws IllegalStateException If this TileFixture has been deleted
     */
    void add(IItem item) throws IllegalArgumentException, IllegalStateException;

    /**
     * @param item - The Item to remove from this TileFixture
     * @return True, if and only if the Item was present, and therefore removed
     * @throws IllegalArgumentException If and only if item is null
     * @throws IllegalStateException If this TileFixture has been deleted
     */
    boolean remove(IItem item) throws IllegalArgumentException, IllegalStateException;

    /**
     * @param item - The Item whose presence to verify
     * @return True, if and only if item is present in this TileFixtureItems
     * @throws IllegalArgumentException If and only if item is null
     * @throws IllegalStateException If this TileFixture has been deleted
     */
    boolean contains(IItem item)
            throws IllegalArgumentException, IllegalStateException;
}
