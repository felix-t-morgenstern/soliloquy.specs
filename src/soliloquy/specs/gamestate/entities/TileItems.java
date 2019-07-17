package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.ReadOnlyMap;

public interface TileItems extends Deletable {
    /**
     * <i>NB: This is only supposed to be a REPRESENTATION of the Items present on this Tile. To
     * add or remove Items, use the other methods specified.</i>
     * @return A numbered Map of Items, where the keys of this Map are Items present on
     * this Tile, and the numerical values of the Map corresponds to the Z order of Items on this
     * Tile
     */
    ReadOnlyMap<Item,Integer> representation() throws IllegalStateException;

    /**
     * (NB: This method simply calls {@link #add(Item, int)} with a zIndex of 0)
     * @param item The Item to add onto this Tile
     * @throws IllegalArgumentException If and only if item is null
     */
    void add(Item item) throws IllegalArgumentException;

    /**
     * (NB: If multiple Items have the same z-index, this will not cause an error; the z-index only
     * controls display order on the UI. However, if multiple Items have the same z-index, then
     * display order will be indeterminate.)
     * @param item The Item to add onto this Tile
     * @param zIndex The z-index for this Item. (NB: This only determines display order. If
     *               multiple Items are on the same Tile, that is not considered an error.)
     * @throws IllegalArgumentException If and only if item is null
     */
    void add(Item item, int zIndex) throws IllegalArgumentException;

    /**
     * @param item - The Item to remove
     * @return True, if and only if the Item was present, and therefore removed
     * @throws IllegalArgumentException If and only if item is null
     */
    boolean remove(Item item) throws IllegalArgumentException;

    /**
     * @param item - The Item whose presence to verify
     * @return True, if and only if item is present on this Tile
     * @throws IllegalArgumentException If and only if item is null
     */
    boolean contains(Item item) throws IllegalArgumentException;
}
