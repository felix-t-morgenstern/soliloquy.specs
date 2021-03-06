package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.ruleset.entities.StatusEffectType;
import soliloquy.specs.ruleset.entities.abilities.AbilitySource;
import soliloquy.specs.ruleset.entities.Element;

/**
 * <b>CharacterStatusEffects</b>
 * <p>
 * It can return a set of all status effects whose values are non-zero, identified by status effect
 * type Id.
 * <p>
 * It can get the value of a specific status effect.
 * <p>
 * It can set the value of a specific status effect.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface CharacterStatusEffects extends Deletable {
	/**
	 * @param statusEffectType - The type of the Status Effect whose level to retrieve
	 * @return The current value of the specified StatusEffectType for this Character
	 * @throws IllegalStateException If this Character is deleted or dead
	 * @throws IllegalArgumentException If and only if statusEffectTypeId is null, empty, or does
	 * not correspond to a valid StatusEffectType
	 */
	Integer getStatusEffectLevel(StatusEffectType statusEffectType)
			throws IllegalStateException, IllegalArgumentException;
	
	/**
	 * @return A read-only Map, with an entry for every Status Effect whose value for this
	 * Character is not zero.
	 * @throws IllegalStateException If this Character is deleted or dead
	 */
	Map<StatusEffectType,Integer> representation() throws IllegalStateException;
	
	/**
	 * This is used for altering the value of a CharacterStatusEffect as part of an Ability, e.g.
	 * poisoning them, confusing them, etc.
	 * <p>
	 * <i>Intended usage is to identify the StatusEffectType by statusEffectTypeId, and then to
	 * call {@code alterCurrentValue}</i>
	 * <p>
	 * This is also where to specify behavior when this CharacterStatusEffect of that Character is
	 * altered
	 * @param type - The StatusEffectType to alter
	 * @param baseAmount - The base amount by which to alter this CharacterStatusEffect
	 * @param stopAtZero - True, if and only if any negative alterations should not go below zero,
	 * or if any positive alterations should not go above zero. For instance, Distraction might be
	 * the negative equivalent to Concentration; so an Ability called "Cure Distraction" should
	 * have "stopAtZero" set to true, so that Distraction is cured, without causing Concentration
	 * (i.e. positive values) to appear.
	 * @param element - An optional Element specifying the source of this CharacterStatusEffect
	 * alteration. (This might not be relevant--for instance, a Character might always resist an
	 * attempt at poisoning based on their resistance to the Poison element, regardless of what is
	 * specified here.) Can be null.
	 * @param abilitySource - A description of the source of the Ability, e.g. in case a Character 
	 * has specific resistances to specific Abilities, or Abilities used by a certain monster type.
	 * Can be null, in the case of effects without any associated Ability (e.g. a hazard found in 
	 * nature).
	 * @throws IllegalStateException If this Character is deleted or dead
	 * @throws IllegalArgumentException If statusEffectTypeId is null or does not correspond to the
	 * Id of a StatusEffectType, or if element is null
	 */
	void alterStatusEffect(StatusEffectType type, int baseAmount, boolean stopAtZero,
						   Element element, AbilitySource abilitySource)
					throws IllegalStateException, IllegalArgumentException;
	
	/**
	 * This sets the level of a status effect for a given Character, ignoring resistances.
	 * @param type - The StatusEffectType
	 * @param level - The level to which to set the Status Effect
	 * @throws IllegalStateException If this Character is deleted or dead
	 * @throws IllegalArgumentException If and only if statusEffectTypeId is null, empty, or does
	 * not correspond to a valid StatusEffectType
	 */
	void setStatusEffectLevel(StatusEffectType type, int level)
			throws IllegalStateException, IllegalArgumentException;
	
	/**
	 * Clears all Status Effects for this Character. (NB: This does not change whether the 
	 * Character is dead or deleted.)
	 * @throws IllegalStateException If this Character is deleted or dead
	 */
	void clearStatusEffects() throws IllegalStateException;
}
