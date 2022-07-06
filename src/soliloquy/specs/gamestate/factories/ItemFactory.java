package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Item;
import soliloquy.specs.ruleset.entities.ItemType;

import java.util.UUID;

/**
 * <b>ItemFactory</b>
 * <p>
 * This class creates Items
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ItemFactory extends SoliloquyClass {
    /**
     * @param itemType The type of Item to create
     * @param data The data for the newly-created Item; may be null
     * @return The newly-created Item
     * @throws IllegalArgumentException If type is null
     */
    Item make(ItemType itemType, VariableCache data) throws IllegalArgumentException;

    /**
     * @param itemType The type of Item to create
     * @param data The data for the newly-created Item; may be null
     * @param uuid The uuid of the Item to create
     * @return The newly-created Item
     * @throws IllegalArgumentException If type or uuid is null
     */
    Item make(ItemType itemType, VariableCache data, UUID uuid) throws IllegalArgumentException;
}
