package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.GenericParamsSet;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.EntityUuid;
import soliloquy.specs.gamestate.entities.Item;
import soliloquy.specs.ruleset.entities.ItemType;

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
     * @param itemType - The type of Item to create
     * @param data - The data for the newly-created Item; may be null
     * @return The newly-created Item
     * @throws IllegalArgumentException If type is null
     */
    Item make(ItemType itemType, GenericParamsSet data) throws IllegalArgumentException;

    /**
     * @param itemType - The type of Item to create
     * @param data - The data for the newly-created Item; may be null
     * @param id - The id of the Item to create
     * @return The newly-created Item
     * @throws IllegalArgumentException If type or id is null
     */
    Item make(ItemType itemType, GenericParamsSet data, EntityUuid id) throws IllegalArgumentException;
}
