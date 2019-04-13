package soliloquy.ruleset.gameentities.abilities.specs;

import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IGlobalAccess;
import soliloquy.gamestate.specs.IGameEntity;

/**
 * <b>Ability</b>
 * <p>
 * A common set of behaviors for ActiveAbilities and Reactive Abilities
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IAbility extends IGameEntity, IGlobalAccess {
	/**
	 * If this Ability belongs to a Character or an Item, its AbilitySource <b>must</b> point back
	 * to that Character or Item
	 * @return The entity to which this Ability belongs
	 * @throws IllegalStateException If the source has not been initialized; or the source for this
	 * Ability is a Character or an Item, but that source does not have this Ability; or if this
	 * Ability has been deleted
	 */
	IAbilitySource source() throws IllegalStateException;
	
	/**
	 * @param source - The entity to which this Ability will belong
	 * @throws IllegalArgumentException If the AbilitySource is invalid
	 * @throws IllegalStateException If this Ability has been deleted
	 * @throws UnsupportedOperationException If this Ability has already had its source initialized
	 */
	void initializeSource(IAbilitySource source) throws IllegalArgumentException, IllegalStateException, UnsupportedOperationException;
	
	/**
	 * The Id corresponding to the type of this Ability
	 * @return The Id of the AbilityType corresponding to this Ability
	 * @throws IllegalStateException If this Ability has been deleted
	 */
	String abilityTypeId() throws IllegalStateException;
	
	/**
	 * (It is expected that Items and Characters will use different means of determining ability
	 * effectiveness.)
	 * @return Any parameters specifying the Ability (e.g. its effectiveness). This is particularly
	 * useful for items, whose effects don't depend completely on Character stats.
	 * @throws IllegalStateException If this Ability has been deleted
	 */
	IGenericParamsSet abilityParams() throws IllegalStateException;
	
	/**
	 * Only considered for Items' Abilities
	 * @return True, if and only if the Ability only applies (i.e. has effect or can be used) when
	 * its corresponding Item is equipped
	 * @throws UnsupportedOperationException If this Ability does not belong to an Item
	 * @throws IllegalStateException If this Ability has been deleted
	 */
	boolean getOnlyWhenEquipped() throws UnsupportedOperationException, IllegalStateException;
	
	/**
	 * Only considered for Items' Abilities
	 * @param onlyWhenEquipped - Whether this Item's Ability will take effect only when that Item
	 * is equipped
	 * @throws UnsupportedOperationException If this Ability does not belong to an Item
	 * @throws IllegalStateException If this Ability has been deleted
	 */
	void setOnlyWhenEquipped(boolean onlyWhenEquipped) throws UnsupportedOperationException, IllegalStateException;
}
