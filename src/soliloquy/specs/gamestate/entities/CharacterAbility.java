package soliloquy.specs.gamestate.entities;

import soliloquy.specs.ruleset.entities.abilities.AbilityType;

/**
 * <b>CharacterAbility</b>
 * <p>
 * This is an Ability possessed by a Character.
 * <p>
 * It may be hidden, in which case it cannot be used and does not appear.
 * <p>
 * It may be disabled, in which case it cannot be used, but it still appears in the UI, and is
 * perhaps greyed out.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface CharacterAbility<TAbilityType extends AbilityType> extends Deletable {
	/**
	 * @return True, if and only if this Ability is hidden (and is thus unusable) for this
	 * Character
	 */
	boolean getIsHidden();
	
	/**
	 * @param isHidden - Whether this Ability will be hidden (and is thus unusable) for this
	 * Character
	 */
	void setIsHidden(boolean isHidden);
	
	/**
	 * @return True, if and only if this Ability is disabled (and is thus unusable) for this
	 * Character
	 */
	boolean getIsDisabled();
	
	/**
	 * @param isDisabled - Whether this Ability will be disabled (and is thus unusable) for this
	 * Character
	 */
	void setIsDisabled(boolean isDisabled);
	
	/**
	 * @return The type of the Ability
	 */
	TAbilityType abilityType();
}
