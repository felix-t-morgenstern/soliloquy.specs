package soliloquy.specs.gamestate.entities;

import soliloquy.specs.ruleset.entities.IAttributeType;

/**
 * <b>CharacterAttribute</b>
 * <p>
 * An Attribute, for a specific Character.
 * <p>
 * This Attribute is intended for base Character stats/abilities, but not skills; e.g. Strength or 
 * Intimidate, but not Magic Missile. (Ability with Magic Missile would, instead, be a {@link 
 * ICharacterAptitude}.)
 * <p>
 * This {@link ICharacterValueFromModifiers} is intended to use an // TODO: Make a IAttributeCalculator class; add link here
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterAttribute extends ICharacterValueFromModifiers {
	/**
	 * @return The type of Attribute whose effective value will be calculated for this Character
	 */
	IAttributeType attribute();
}
