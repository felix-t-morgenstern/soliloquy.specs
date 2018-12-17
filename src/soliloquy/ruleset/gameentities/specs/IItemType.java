package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ICoordinate;
import soliloquy.common.specs.IFunction;
import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IHasId;
import soliloquy.common.specs.IHasPluralName;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.gamestate.specs.ICharacter;
import soliloquy.gamestate.specs.ICharacterEquipmentSlot;
import soliloquy.gamestate.specs.IItem;
import soliloquy.gamestate.specs.ITile;
import soliloquy.ruleset.gameentities.abilities.specs.IActiveAbility;
import soliloquy.ruleset.gameentities.abilities.specs.IPassiveAbility;
import soliloquy.ruleset.gameentities.abilities.specs.IReactiveAbility;
import soliloquy.sprites.specs.ISprite;

/**
 * <b>ItemType</b>
 * <p>
 * An ItemType has an EquipmentType, it can have charges or be stacked (but not both), 
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IItemType extends IGameEntity, IHasPluralName, IHasId, ISoliloquyClass {
	/**
	 * Creates an Item of this ItemType on the specified Tile
	 * @param tile - The Tile on which to create the Item
	 * @param tilePixelOffset - An offset, in pixels, added to the result of defaultTilePixelOffset, by which the new Item will be placed to the right and above the bottom-left corner of the Tile; can be null
	 * @param zLoc - The z index of the new Item, to be compared against other Items already on this Tile; can be null
	 * @param params - Parameters regarding how this new Item will be created (e.g. its number of charges, its enchantments, its condition), can be null
	 * @return The newly-created Item
	 * @throws IllegalArgumentException If tile is null
	 */
	IItem generateOnTile(ITile tile, ICoordinate tilePixelOffset, Integer zLoc, IGenericParamsSet params) throws IllegalArgumentException;
	
	/**
	 * Creates an Item of this ItemType in the specified Character's inventory
	 * @param character - The Character in whose inventory to place the new Item
	 * @param params - Parameters regarding how this new Item will be created (e.g. its number of charges, its enchantments, its condition), can be null
	 * @return The newly-created Item
	 * @throws IllegalArgumentException If character is null or deleted
	 */
	IItem generateInInventory(ICharacter character, IGenericParamsSet params) throws IllegalArgumentException;
	
	/**
	 * Creates an Item of this ItemType in the specified CharacterEquipmentSlot
	 * @param characterEquipmentSlot - The CharacterEquipmentSlot in which to place the new Item
	 * @param params - Parameters regarding how this new Item will be created (e.g. its number of charges, its enchantments, its condition), can be null
	 * @return The newly-created Item
	 * @throws IllegalArgumentException If characterEquipmentSlot is null, if the Character owning this characterEquipmentSlot is invalid or deleted, or characterEquipmentSlot is already occupied, or the Item cannot be equipped to characterEquipmentSlot
	 */
	IItem generateInEquipment(ICharacterEquipmentSlot characterEquipmentSlot, IGenericParamsSet params) throws IllegalArgumentException;
	
	/**
	 * @return The EquipmentType (e.g. helmets, necklaces, mystical auras, makeup) of this ItemType; used to determine in which types of equipment slots this Item can be equipped
	 */
	IEquipmentType getEquipmentType();
	
	/**
	 * @return A function which generates a description of this ItemType, and which takes a Character as its input (e.g. to calculate how much damage a sword will do)
	 */
	IFunction<ICharacter,String> getDescriptionFunction();
	
	/**
	 * @param descriptionFunction - The function to set for this ItemType which generates a description of this ItemType, and which takes a Character as its input (e.g. to calculate how much damage a sword will do)
	 */
	void setDescriptionFunction(IFunction<ICharacter,String> descriptionFunction);
	
	/**
	 * This is intended for item traits like sell value, weight, whether it is cursed, etc. 
	 * @return Collections of item traits, for various types of traits (strings, ints, booleans, etc.) 
	 */
	IGenericParamsSet traits();
	
	/**
	 * A stackable ItemType would be something like "stone", where an Item of this ItemType can have numerInStack of 3, meaning that Item represents three stones.
	 * @return True, if and only if instances of this ItemType can be "stacked" (i.e. where one instance of this Item class can represent multiple instances of the underlying "item".)
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
	 * @return The default offset, in pixels, from the bottom-left corner of the Tile on which this Item is placed
	 */
	ICoordinate defaultTilePixelOffset();
	
	/**
	 * @return This ItemType's ActiveAbilities, e.g. Fireball, Heal Character
	 */
	ICollection<IActiveAbility> activeAbilities();

	/**
	 * @return This Item's ReactiveAbilities, e.g. Counter-attack, Absorb Mana
	 */
	ICollection<IReactiveAbility> reactiveAbilities();

	/**
	 * @return This Item's PassiveAbilities, e.g. Resist Cold, Deflect Counter-attacks, Sex Appeal
	 */
	ICollection<IPassiveAbility> passiveAbilities();
	
	/**
	 * The Sprite returned can depend on the status of the item, e.g. whether it is on the ground, whether it is in inventory, how many charges it has, etc.
	 * @return The Sprite for this Item
	 */
	ISprite sprite();
}
