package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ISoliloquyClass;

public interface ITileFixtureItems extends ISoliloquyClass {
    /**
     * <i>NB: This is only supposed to be a REPRESENTATION of the Items present in this TileFixture.
     * To add or remove Items, use the other methods specified.</i>
     * @return A Collection of the Items in this TileFixture.
     * @throws UnsupportedOperationException If this TileFixture's FixtureType is not a container
     * @throws IllegalStateException If this TileFixture has been deleted
     */
    ICollection<IItem> getContainedItemsRepresentation()
            throws UnsupportedOperationException, IllegalStateException;

    /**
     * @param item - The Item to add to this TileFixture
     * @throws IllegalArgumentException If and only if item is null, or item exists elsewhere
     * @throws IllegalStateException If this TileFixture has been deleted
     */
    void addContainedItem(IItem item) throws IllegalArgumentException, IllegalStateException;

    /**
     * @param item - The Item to remove from this TileFixture
     * @return True, if and only if the Item was present, and therefore removed
     * @throws IllegalArgumentException If and only if item is null
     * @throws IllegalStateException If this TileFixture has been deleted
     */
    boolean removeContainedItem(IItem item) throws IllegalArgumentException, IllegalStateException;

    /**
     * @param item - The Item whose presence to verify
     * @return True, if and only if item is present in this TileFixtureItems
     * @throws IllegalArgumentException If and only if item is null
     * @throws IllegalStateException If this TileFixture has been deleted
     */
    boolean containsContainedItem(IItem item)
            throws IllegalArgumentException, IllegalStateException;
}
