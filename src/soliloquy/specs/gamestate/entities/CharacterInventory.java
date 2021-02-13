package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.List;

/**
 * <b>CharacterInventory</b>
 * <p>
 * This class handles Item present in a Character's inventory. It exists to handle invariants which
 * must be enforced, since a Character should know its Inventory, and Inventory items should know
 * their Character.
 * <p>
 * This class also supports providing a <i>representation</i> of the CharacterInventory for this
 * Character; i.e., a Map containing all of those Items. <u>Editing the Map provided by
 * getRepresentation will not change the Inventory for this Character.</u> To do that, use
 * the add and remove methods, also provided.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterInventory extends Iterable<Item>, Deletable {
    /**
     * <i>NB: This is only supposed to be a REPRESENTATION of the Items present in this Character's
     * inventory. To add or remove Items, use the other methods specified.</i>
     * @return A representation of this Character's inventory.
     * @throws IllegalStateException If this Character does not have a GameZone, or if this
     * Character has been deleted, or if it has no Id
     */
    List<Item> representation() throws IllegalStateException;

    /**
     * @param item - The Item to add to this Character's inventory
     * @throws IllegalArgumentException If and only if item is null, or is deleted, or exists
     * elsewhere
     * @throws IllegalStateException If this Character does not have a GameZone, or if this
     * Character has been deleted, or if it has no Id
     */
    void add(Item item) throws IllegalArgumentException, IllegalStateException;

    /**
     * @param item - The Item to remove from this Character's inventory
     * @return True, if and only if this Item was present in this Character's inventory, and was
     * therefore removed
     * @throws IllegalArgumentException If and only if item is null
     * @throws IllegalStateException If this Character does not have a GameZone, or if this
     * Character has been deleted, or if it has no Id
     */
    boolean remove(Item item) throws IllegalArgumentException,
            IllegalStateException;

    /**
     * @param item - The Item whose presence to verify
     * @return True, if and only if item is present in this CharacterInventory
     * @throws IllegalArgumentException If and only if item is null
     * @throws IllegalStateException If this Character does not have a GameZone, or if this
     * Character has been deleted, or if it has no Id
     */
    boolean contains(Item item) throws IllegalArgumentException, IllegalStateException;
}
