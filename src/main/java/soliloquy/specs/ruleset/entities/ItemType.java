package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasPluralName;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.graphics.assets.ImageAssetSet;
import soliloquy.specs.ruleset.entities.abilities.ActiveAbility;
import soliloquy.specs.ruleset.entities.abilities.PassiveAbility;
import soliloquy.specs.ruleset.entities.abilities.ReactiveAbility;

import java.util.List;
import java.util.function.Function;

/**
 * <b>ItemType</b>
 * <p>
 * An ItemType has an EquipmentType, it can have charges or be stacked (but not both)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ItemType extends HasDefaultTileOffsets, HasImageAssetSet, HasPluralName, HasId {
    /**
     * @return The EquipmentType (e.g. helmets, necklaces, mystical auras, makeup) of this ItemType;
     *         used to determine in which types of equipment slots this Item can be equipped
     */
    EquipmentType equipmentType();

    /**
     * @return A function which generates a description of this ItemType, and which takes a
     *         Character as its input (e.g. to calculate how much damage a sword will do)
     */
    Function<Character, String> descriptionFunction();

    /**
     * This is intended for item traits like sell value, weight, damage done, whether it is cursed,
     * etc.
     *
     * @return Collections of item traits, for various types of traits (strings, ints, booleans,
     *         etc.)
     */
    VariableCache traits();

    /**
     * A stackable ItemType would be something like "stone", where an Item of this ItemType can
     * have numberInStack of 3, meaning that Item represents three stones.
     *
     * @return True, if and only if instances of this ItemType can be "stacked" (i.e. where one
     *         instance of this Item class can represent multiple instances of the underlying
     *         "item".)
     */
    boolean isStackable();

    /**
     * @return The default number of items in the stack of an Item of this ItemType
     * @throws UnsupportedOperationException If this ItemType cannot be stacked
     */
    int defaultNumberInStack() throws UnsupportedOperationException;

    /**
     * @return True, if and only if Items of this ItemType have charges
     */
    boolean hasCharges();

    /**
     * @return The default number of charges (i.e. uses) an Item of this ItemType has
     * @throws UnsupportedOperationException If this ItemType does not have charges
     */
    int defaultCharges() throws UnsupportedOperationException;

    /**
     * @return This ItemType's default ActiveAbilities, e.g. Fireball, Heal Character
     */
    List<ActiveAbility> defaultActiveAbilities();

    /**
     * @return This ItemType's default ReactiveAbilities, e.g. Counter-attack, Absorb Mana
     */
    List<ReactiveAbility> defaultReactiveAbilities();

    /**
     * @return This ItemType's default PassiveAbilities, e.g. Resist Cold, Deflect Counter-attacks,
     *         Sex Appeal
     */
    List<PassiveAbility> defaultPassiveAbilities();

    // NB: Underlying HasImageAssetSet method is overriden to provide clearer description
    /**
     * The {@link soliloquy.specs.graphics.assets.ImageAsset} for an
     * {@link soliloquy.specs.gamestate.entities.Item} of this type can depend on the status of the
     * Item, e.g., whether it is on the ground, whether it is in inventory, how many charges it has,
     * etc.
     *
     * @return The ImageAssetSet for this Item
     */
    @Override
    ImageAssetSet imageAssetSet();
}
