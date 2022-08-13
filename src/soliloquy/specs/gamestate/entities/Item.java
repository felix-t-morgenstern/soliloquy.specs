package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.common.shared.HasPluralName;
import soliloquy.specs.common.shared.HasUuid;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.ruleset.entities.ItemType;
import soliloquy.specs.ruleset.entities.abilities.ActiveAbility;
import soliloquy.specs.ruleset.entities.abilities.PassiveAbility;
import soliloquy.specs.ruleset.entities.abilities.ReactiveAbility;

import java.util.List;

/**
 * <b>Item</b>
 * <p>
 * An Item is of an ItemType.
 * <p>
 * An Item can have a number of charges.
 * <p>
 * An Item can be located in one of these four locations: Character inventories,
 * CharacterEquipmentSlots, Tiles, and TileContainers.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Item extends TileEntity, HasTileOffsets, HasPluralName, HasUuid {
    /**
     * @return The ItemType of this Item
     * @throws IllegalStateException  If this Item is present in more than one place (i.e. an
     *                                Inventory, an EquipmentSlot, a Tile, or a TileContainer), or
     *                                if it has no Id.. It is legal
     *                                for an Item to have no locations, e.g. when it has not yet
     *                                been placed, or after it has been
     *                                removed from an EquipmentSlot.
     * @throws EntityDeletedException If this has been deleted
     */
    ItemType type() throws IllegalStateException, EntityDeletedException;

    /**
     * @return The number of charges left in this Item (If this Item does not have charges, this
     *         method will return null.)
     * @throws IllegalStateException  If this Item's ItemType does not allow it to have charges, if
     *                                this Item is present in more than one place (i.e. an
     *                                Inventory, an EquipmentSlot, a Tile, or
     *                                a TileContainer), or if it has no Id. It is legal for an Item
     *                                to have no locations, e.g.
     *                                when it has not yet been placed, or after it has been removed
     *                                from an EquipmentSlot.
     * @throws EntityDeletedException If this has been deleted
     */
    Integer getCharges() throws IllegalStateException, EntityDeletedException;

    /**
     * @param charges The charges to set for this Item
     * @throws UnsupportedOperationException If and only if this Item's type does not have charges
     * @throws IllegalArgumentException      If numberInStack is less than 0
     * @throws IllegalStateException         If this Item's ItemType does not allow it to have
     *                                       charges, if
     *                                       this Item is present in more than one place (i.e. an
     *                                       Inventory, an EquipmentSlot, a Tile, or
     *                                       a TileContainer), or if it has no Id. It is legal for
     *                                       an Item to have no locations, e.g.
     *                                       when it has not yet been placed, or after it has been
     *                                       removed from an EquipmentSlot.
     * @throws EntityDeletedException        If this has been deleted
     */
    void setCharges(int charges)
            throws UnsupportedOperationException, IllegalArgumentException, IllegalStateException,
            EntityDeletedException;

    /**
     * <b>NB: Stackable Items are treated such that one Item is equivalent to one stack. So, a
     * stack of 15 health potions would be a single Item, which would return 15 when this method is
     * called.</b>
     *
     * @return The number of Items of this type currently in this stack.
     * @throws IllegalStateException  If this Item's ItemType does not allow it to have charges, if
     *                                this Item is present in more than one place (i.e. an
     *                                Inventory, an EquipmentSlot, a Tile, or
     *                                a TileContainer), or if it has no Id. It is legal for an Item
     *                                to have no locations, e.g.
     *                                when it has not yet been placed, or after it has been removed
     *                                from an EquipmentSlot.
     * @throws EntityDeletedException If this has been deleted
     */
    Integer getNumberInStack() throws IllegalStateException, EntityDeletedException;

    /**
     * <b>NB: See {@link #getNumberInStack()} for an explanation of how stacked Items work.</b>
     *
     * @param numberInStack The number in this stack to set for this Item
     * @throws UnsupportedOperationException If this ItemType cannot be stacked
     * @throws IllegalArgumentException      If numberInStack is less than 1
     * @throws IllegalStateException         If this Item is not present in the TileItems,
     *                                       CharacterInventory, etc. to which it has been
     *                                       assigned,
     *                                       or if it has no Id. It is legal for
     *                                       an Item to have no locations, e.g. when it has not yet
     *                                       been placed, or after it has been
     *                                       removed from an EquipmentSlot.
     * @throws EntityDeletedException        If this has been deleted
     */
    void setNumberInStack(int numberInStack)
            throws UnsupportedOperationException, IllegalArgumentException, IllegalStateException,
            EntityDeletedException;

    /**
     * Splits a stackable Item into two Items; returns the new Item with a number taken from the
     * original Item's stack
     * <b>NB: See {@link #getNumberInStack()} for an explanation of how stacked Items work.</b>
     *
     * @param numberToTake The number of the item to take from the original Item's stack
     * @return The new Item, of the same ItemType, with numberInStack equal to numberToTake
     * @throws UnsupportedOperationException If this ItemType cannot be stacked
     * @throws IllegalArgumentException      If numberToTake is less than one, or if it is greater
     *                                       than or equal to getNumberInStack of this (i.e. the
     *                                       original) Item
     * @throws IllegalStateException         If this Item is not present in the TileItems,
     *                                       CharacterInventory, etc. to which it has been
     *                                       assigned,
     *                                       or if it has no Id. It is legal for
     *                                       an Item to have no locations, e.g. when it has not yet
     *                                       been placed, or after it has been
     *                                       removed from an EquipmentSlot.
     * @throws EntityDeletedException        If this has been deleted
     */
    Item takeFromStack(int numberToTake)
            throws UnsupportedOperationException, IllegalArgumentException, IllegalStateException,
            EntityDeletedException;

    /**
     * @return The Character in whose inventory this Item exists
     * @throws IllegalStateException  If this Item is not present in the TileItems,
     *                                CharacterInventory, etc. to which it has been assigned, or if
     *                                it has no Id, or if it has
     *                                been deleted. It is legal for an Item to have no locations,
     *                                e.g. when it has not yet been
     *                                placed, or after it has been removed from an EquipmentSlot.
     * @throws EntityDeletedException If this has been deleted
     */
    Character inventoryCharacter() throws IllegalStateException, EntityDeletedException;

    /**
     * @return A Pair containing the {@link Character} and the equipment slot type in which this
     *         Item is located; if this item isn't equipped to any Character, this method returns
     *         null.
     * @throws IllegalStateException  If this Item is not present in the TileItems,
     *                                CharacterInventory, etc. to which it has been assigned, or if
     *                                it has no Id. It is legal for
     *                                an Item to have no locations, e.g. when it has not yet been
     *                                placed, or after it has been
     *                                removed from an EquipmentSlot.
     * @throws EntityDeletedException If this has been deleted
     */
    Pair<Character, String> equipmentSlot() throws IllegalStateException, EntityDeletedException;

    /**
     * @return The {@link TileFixture} in which this Item is stored
     * @throws IllegalStateException  If this Item is not present in the TileItems,
     *                                CharacterInventory, etc. to which it has been assigned, or if
     *                                it has no Id. It is legal for
     *                                an Item to have no locations, e.g. when it has not yet been
     *                                placed, or after it has been
     *                                removed from an EquipmentSlot.
     * @throws EntityDeletedException If this has been deleted
     */
    TileFixture tileFixture() throws IllegalStateException, EntityDeletedException;

    // TODO: Verify whether EntityDeletedException is thrown

    /**
     * <b>NB: This method is intended to <u>only</u> be used by
     * {@link CharacterEquipmentSlots#equipItemToSlot}; it is intended to check whether the
     * CharacterEquipmentSlot assigned to this Item has this Item set as equipped.</b>
     *
     * @param character         The {@link Character} whose {@link CharacterEquipmentSlots}
     *                            which to
     *                          assign to this Item
     * @param equipmentSlotType The equipment slot type to which to assign this Item
     * @throws IllegalStateException  If the Item currently in this slot cannot be equipped to this
     *                                slot, or if the Character for this CharacterEquipmentSlot has
     *                                been deleted
     * @throws EntityDeletedException If this has been deleted
     */
    void assignEquipmentSlotAfterAddedToCharacterEquipmentSlot(
            Character character, String equipmentSlotType)
            throws IllegalStateException, IllegalArgumentException, EntityDeletedException;

    /**
     * <b>NB: This method is intended to <u>only</u> be used by {@link CharacterInventory#add} and
     * {@link CharacterInventory#remove}; it is intended to check whether the Character assigned to
     * this Item has this Item in its CharacterInventory.</b>
     *
     * @param character The {@link Character} whose {@link CharacterInventory} which to assign to
     *                  this Item
     * @throws IllegalStateException  If the Item currently in this slot cannot be equipped to this
     *                                slot, or if the Character for this CharacterEquipmentSlot has
     *                                been deleted
     * @throws EntityDeletedException If this has been deleted
     */
    void assignInventoryCharacterAfterAddedToCharacterInventory(
            Character character)
            throws IllegalStateException, IllegalArgumentException, EntityDeletedException;

    /**
     * <b>NB: This method is intended to <u>only</u> be used by {@link TileFixtureItems#add} and
     * {@link TileFixtureItems#remove}; it is intended to check whether the TileFixture assigned to
     * this Item has this Item in its contained items, prior to assignment.</b>
     *
     * @param tileFixture The {@link TileFixture} which to assign to this Item
     * @throws IllegalArgumentException If and only if tileFixture is null, or tileFixture does not
     *                                  contain this Item
     * @throws IllegalStateException    If the Item currently in this slot cannot be equipped to
     *                                  this
     *                                  slot, or if the Character for this CharacterEquipmentSlot
     *                                  has been deleted
     * @throws EntityDeletedException   If this has been deleted
     */
    void assignTileFixtureAfterAddedItemToTileFixtureItems(TileFixture tileFixture)
            throws IllegalArgumentException, IllegalStateException, EntityDeletedException;

    /**
     * @return A collection of this Item's PassiveAbilities; e.g., Exceptional Dodge, Friendly
     *         Demeanor, Large Poops; this is also used to add PassiveAbilities to the Item
     * @throws EntityDeletedException If this Item has been deleted
     */
    List<PassiveAbility> passiveAbilities() throws EntityDeletedException;

    /**
     * @return A collection of this Item's ActiveAbilities; e.g., Melee Attack, Fireball; this is
     *         also used to add ActiveAbilities to the Item
     * @throws EntityDeletedException If this Item has been deleted
     */
    List<ActiveAbility> activeAbilities() throws EntityDeletedException;

    /**
     * @return A collection of this Item's ReactiveAbilities; e.g., Counter-attack, Absorb Mana;
     *         this is also used to add ReactiveAbilities to the Item
     * @throws EntityDeletedException If this Item has been deleted
     */
    List<ReactiveAbility> reactiveAbilities() throws EntityDeletedException;
}
