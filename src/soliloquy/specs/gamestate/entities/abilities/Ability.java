package soliloquy.specs.gamestate.entities.abilities;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasGlobalAccess;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.gamestate.entities.GameEntity;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;

/**
 * <b>Ability</b>
 * <p>
 * This class is represents an Ability, possessed by either a
 * {@link soliloquy.specs.gamestate.entities.Character} or an
 * {@link soliloquy.specs.gamestate.entities.Item}.
 * <p>
 * This class defines a common set of behaviors for ActiveAbilities and Reactive Abilities.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Ability extends GameEntity, HasName, HasGlobalAccess {
	/**
	 * (NB: All Abilities must belong to either a Character or an Item)
	 * @return The entity to which this Ability belongs
	 * @throws IllegalStateException If the source has not been initialized; or the source for this
	 * Ability is a Character or an Item, but that source does not have this Ability
	 * @throws EntityDeletedException if this Ability has been deleted
	 */
	AbilitySource source() throws IllegalStateException, EntityDeletedException;
	
	/**
	 * (It is expected that Items and Characters will use different means of determining ability
	 * effectiveness.)
	 * @return Any parameters specifying the Ability (e.g. its effectiveness). This is particularly
	 * useful for items, whose effects don't depend completely on Character stats.
	 * @throws EntityDeletedException If this Ability has been deleted
	 */
	VariableCache abilityParams() throws EntityDeletedException;
	
	/**
	 * Only considered for Items' Abilities
	 * @return True, if and only if the Ability only applies (i.e. has effect or can be used) when
	 * its corresponding Item is equipped
	 * @throws UnsupportedOperationException If this Ability does not belong to an Item
	 * @throws EntityDeletedException If this Ability has been deleted
	 */
	boolean getOnlyWhenEquipped() throws UnsupportedOperationException, EntityDeletedException;
	
	/**
	 * Only considered for Items' Abilities
	 * @param onlyWhenEquipped Whether this Item's Ability will take effect only when that Item is
	 *                         equipped
	 * @throws UnsupportedOperationException If this Ability does not belong to an Item
	 * @throws EntityDeletedException If this Ability has been deleted
	 */
	void setOnlyWhenEquipped(boolean onlyWhenEquipped)
			throws UnsupportedOperationException, EntityDeletedException;
}
