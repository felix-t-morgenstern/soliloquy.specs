package soliloquy.ruleset.gameentities.specs;

import soliloquy.gamestate.specs.ICharacter;
import soliloquy.sprites.specs.ISprite;

/**
 * <b>StatusEffectType</b>
 * <p>
 * It has a name and id.
 * <p>
 * It has Actions, which can be performed on each Character, at the start and end of their turn, and the start and end of the round.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IStatusEffectType extends IActOnCharacterOnTurnAndRound, IGameEntity {
	ISprite statusWindowIcon(int characterId);
	ISprite healthBarIcon(int characterId);
	int iconDisplayPriority();
	
	/**
	 * This is used for altering the value of a specified Character's CharacterVitalAttribute as part of an Ability, e.g. doing damage to a Character, draining their mana, etc.
	 * <p>
	 * <i>Intended usage is to call {@code vitalAttributeType().alterCurrentValue}</i>
	 * <p>
	 * This is also where to specify behavior when this CharacterStatusEffect of that Character changes
	 * @param character - The Character whose CharacterStatusEffect to alter
	 * @param statusEffectTypeId - The Id of the StatusEffectType to alter
	 * @param baseAmount - The base amount by which to alter this CharacterStatusEffect
	 * @param stopAtZero - True, if and only if any negative alterations should not go below zero, or if any positive alterations should not go above zero. For instance, Distraction might be the negative equivalent to Concentration; so an Ability called "Cure Distraction" should have "stopAtZero" set to true, so that Distraction is cured, without causing Concentration (i.e. positive values) to appear.
	 * @param bypassResistance - True, if and only if resistances are to be bypassed. This is primarily intended for restorative Abilities, e.g. Cure Poison should not be hampered by the target's Poison resistance.  
	 * @param element - An optional Element specifying the source of this CharacterStatusEffect alteration. (This might not be relevant--for instance, a Character might always resist an attempt at poisoning based on their resistance to the Poison element, regardless of what is specified here.) Can be null.
	 * @throws IllegalArgumentException If statusEffectTypeId is null or does not correspond to the Id of a StatusEffectType, or if character is null, dead, or deleted
	 */
	void alterStatusEffect(ICharacter character, String statusEffectTypeId, int baseAmount, boolean stopAtZero, boolean bypassResistance, IElement element) throws IllegalStateException, IllegalArgumentException;
}
