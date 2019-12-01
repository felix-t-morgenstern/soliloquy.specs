package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Collection;
import soliloquy.specs.common.infrastructure.GenericParamsSet;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.common.shared.HasUuid;
import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.gamestate.entities.gameevents.GameCharacterEvent;
import soliloquy.specs.ruleset.entities.abilities.ActiveAbilityType;
import soliloquy.specs.ruleset.entities.abilities.ReactiveAbilityType;
import soliloquy.specs.ruleset.entities.CharacterAIType;
import soliloquy.specs.ruleset.valueobjects.CharacterClassification;
import soliloquy.specs.ruleset.entities.CharacterType;
import soliloquy.specs.sprites.entities.SpriteSet;

/**
 * <b>Character</b>
 * <p>
 * A Character which exists in the GameWorld.
 * <p>
 * Characters exist in a GameZone; they may have a Tile; they may have a Type; they may have
 * CharacterClassifications; they may have inventory and equipment; they may have Aptitudes,
 * Attributes, VitalAttributes and StatusEffects; they have AI scripts; they may have Abilities;
 * they may be hidden; and they may be dead. 
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Character extends GameEntity, HasName, HasUuid {
	/**
	 * @return The CharacterType of this Character
	 * <p>
	 * This value may be null, e.g. in cases of PlayerCharacters
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	CharacterType characterType() throws IllegalStateException;
	
	/**
	 * @return The Classifications of this Character, e.g. "undead", "elemental", etc.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	Collection<CharacterClassification> classifications() throws IllegalStateException;
	
	/**
	 * @return The proper pronouns for this Character. The key for the Map is the grammatical case
	 * in question (e.g. nominative, oblique, genitive, etc.). Every Character can choose their own
	 * pronouns.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	Map<String,String> pronouns() throws IllegalStateException;
	
	/**
	 * Data can be traits relevant to combat or stats, e.g. experience points, Character level,
	 * skill points
	 * <p>
	 * Data can be relevant to combat behavior, e.g. desired distance from enemies, preferred
	 * abilities to use, etc.
	 * <p>
	 * Data may also be irrelevant to combat or stats, e.g. religion, alignment, race, nationality
	 * @return Traits of this Character
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	GenericParamsSet data() throws IllegalStateException;

	/**
	 * @return The Tile on which this Character sits
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	Tile tile() throws IllegalStateException;
	
	/**
	 * @return The stance of the Character; e.g. "combat-ready", "attacking", "near-death"; which
	 * is used to determine its current Sprite
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	String getStance() throws IllegalStateException;
	
	/**
	 * @param stance - The stance to set for this Character
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setStance(String stance) throws IllegalStateException;
	
	/**
	 * @return The current direction of this Character, e.g. "NW", "S"
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	String getDirection() throws IllegalStateException;
	
	/**
	 * @param direction - The direction to set for this Character, e.g. "N", "NW"
	 * @throws IllegalArgumentException If the provided direction is illegal, e.g. if it is null, a
	 * blank string, not a valid direction
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setDirection(String direction) throws IllegalArgumentException, IllegalStateException;
	
	/**
	 * @return The SpriteSet for this Character
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	SpriteSet getSpriteSet() throws IllegalStateException;
	
	/**
	 * @param spriteSet - The SpriteSet to set for this Character
	 * @throws IllegalArgumentException You <i>may</i> wish to throw this exception if the
	 * provided SpriteSet is null
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setSpriteSet(SpriteSet spriteSet) throws IllegalArgumentException, IllegalStateException;
	
	/**
	 * @return This Character's AI script ID (to be looked up in GameState.characterAIs)
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	CharacterAIType getAIType() throws IllegalStateException;
	
	/**
	 * <i>NB: This should still be set for PCs, since the player may lose control of PCs, e.g. 
	 * confusion, charming</i>
	 * @param characterAIType - The AI script to assign to this Character
	 * @throws IllegalArgumentException If characterAIType is null
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setAIType(CharacterAIType characterAIType)
			throws IllegalArgumentException, IllegalStateException;

	/**
	 * The index of this map is a type of triggering event, i.e. "onDeath", "onAttacked",
	 * "onSeeParty", etc. The values are the collections of events fired for this Character when
	 * the corresponding type of trigger occurs.
	 * @return A Map, describing events which occur for this Character, given various types of
	 * triggers
	 */
	CharacterEvents events();
	
	/**
	 * @return This Character's equipment slots, from which equipment can be accessed or modified
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	CharacterEquipmentSlots equipmentSlots() throws IllegalStateException;

	/**
	 * @return This Character's inventory, from which inventory can be accessed or modified
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	CharacterInventory inventory() throws IllegalStateException;

	/**
	 * @return This Character's depletable statistics, e.g. health, mana
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	Map<String, CharacterDepletableStatistic> depletableStatistics() throws IllegalStateException;
	
	/**
	 * @return This Character's Attributes, e.g. Intelligence, Swordplay, Etiquette
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	Map<String, CharacterStatistic> statistics() throws IllegalStateException;
	
	/**
	 * @return This Character's current StatusEffects, e.g. poisoned, distracted, panicking
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	CharacterStatusEffects statusEffects() throws IllegalStateException;
	
	/**
	 * @return A named Map of this Character's ActiveAbilities; e.g., Melee Attack, Fireball, Talk
	 * to Character; the Id is the AbilityTypeId
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	Map<String, CharacterAbility<ActiveAbilityType>> activeAbilities()
			throws IllegalStateException;
	
	/**
	 * @return A named Map of this Character's ReactiveAbilities; e.g., Counter-attack, Absorb
	 * Mana; the Id is the AbilityTypeId
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	Map<String, CharacterAbility<ReactiveAbilityType>> reactiveAbilities()
			throws IllegalStateException;
	
	/**
	 * <i>This method should return FALSE when a PC is charmed, confused, or otherwise only 
	 * temporarily uncontrolled by the player. Logic to determine whether the player controls any 
	 * particular PC should be handled by the logic fed into the
	 * {@link soliloquy.specs.gamestate.entities.RoundManager}'s constructor by the Ruleset.
	 * @return True, if and only if this Character is controlled by the player
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	boolean getPlayerControlled() throws IllegalStateException;
	
	/**
	 * @param playerControlled - True, if and only if this Character is controlled by the player
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setPlayerControlled(boolean playerControlled) throws IllegalStateException;
	
	/**
	 * Deletes this Character. (Calling this method will remove this Character from its GameZone's
	 * Characters. It will also delete all contained entities, e.g. movementEvents, inventory, etc.)
	 * <p>
	 * This is different from killing this Character or setting them to be dead via setIsDead. In
	 * those cases, the Character still exists in the GameZone's Characters, and may be revived;
	 * when a Character is deleted, they do not exist anymore at all.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void delete() throws IllegalStateException;

	/**
	 * <b>NB: This method is intended to <b><u>only</u></b> be used by {@link TileCharacters#add}
	 * and {@link TileCharacters#remove}; it is intended to check whether the Tile assigned to this
	 * Character has this Character on it, prior to assignment.</b>
	 * @param tile - The Tile to which to assign to this Character
	 * @throws IllegalArgumentException If and only if tile is null, or tile does not contain this
	 * Character
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void assignToTileAfterAddingToTileCharacters(Tile tile)
			throws IllegalArgumentException, IllegalStateException;
}
