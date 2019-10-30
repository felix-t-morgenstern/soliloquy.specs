package soliloquy.specs.gamestate.entities;

import soliloquy.specs.ruleset.entities.AptitudeType;

/**
 * <b>CharacterAptitude</b>
 * <p>
 * An Aptitude, for a specific Character.
 * <p>
 * This Attribute is intended for base Character skills, e.g. Magic Missile.
 * <p>
 * This {@link CharacterValueFromModifiers} is intended to use an // TODO: Make a IAptitudeCalculator class; add link here
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface CharacterAptitude extends CharacterValueFromModifiers {
	/**
	 * @return The type of the aptitude being calculated
	 */
	AptitudeType aptitudeType();
}
