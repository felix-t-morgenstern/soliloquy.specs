package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IHasUuid;
import soliloquy.common.specs.IMap;
import soliloquy.ruleset.gameentities.specs.ICharacterAIType;
import soliloquy.ruleset.gameentities.specs.ICharacterClassification;
import soliloquy.ruleset.gameentities.specs.ICharacterEvent;
import soliloquy.ruleset.gameentities.specs.ICharacterType;
import soliloquy.sprites.specs.ISpriteSet;

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
public interface ICharacter extends IGameEntity, IHasUuid {
	/**
	 * @return The CharacterType of this Character
	 * <p>
	 * This value may be null, e.g. in cases of PlayerCharacters
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	ICharacterType characterType() throws IllegalStateException;
	
	/**
	 * @return The Classifications of this Character, e.g. "undead", "elemental", etc.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	ICollection<ICharacterClassification> classifications() throws IllegalStateException;
	
	/**
	 * @return The Tile in which this Character is located.
	 * <p>
	 * This method may return null if the Character is hidden or dead.
	 * @throws IllegalStateException If the Tile does not exist, or if the Tile does not have this
	 * Character present in its Collection of Characters, or if the Tile is null and the Character
	 * is neither hidden nor dead, or if this Character does not have a GameZone, or if this
	 * Character has been deleted, or if this Character has no Id
	 */
	ITile getTile() throws IllegalStateException;
	
	/**
	 * (NB: This method calls {@link ICharacter#setTile(ITile, int)} with a z-index of 0)
	 * @param tile - The Tile to which to move this Character
	 * @throws IllegalArgumentException If the location is illegal, e.g. if there is no Tile at
	 * that location, if loc is null, etc.
	 * <p>
	 * <i>If loc specifies a Tile with a different Character already present, you may wish to throw
	 * an IllegalArgumentException, or report a warning in the Logger.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setTile(ITile tile) throws IllegalArgumentException, IllegalStateException;

	/**
	 * (NB: If a Tile has multiple Characters at the same z-index, this will not cause an error, 
	 * but display order will be indeterminate)
	 * @param tile - The Tile to which to move this Character
	 * @param zIndex - The z-index to which to assign for this Character (used exclusively for 
	 * determining UI display order)
	 * @throws IllegalArgumentException If the location is illegal, e.g. if there is no Tile at
	 * that location, if loc is null, etc.
	 * <p>
	 * <i>If loc specifies a Tile with a different Character already present, you may wish to throw
	 * an IllegalArgumentException, or report a warning in the Logger.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setTile(ITile tile, int zIndex) throws IllegalArgumentException, IllegalStateException;
	
	/**
	 * @return The proper pronouns for this Character. The key for the Map is the grammatical case
	 * in question (e.g. nominative, oblique, genitive, etc.). Every Character can choose their own
	 * pronouns.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	IMap<String,String> pronouns() throws IllegalStateException;
	
	/**
	 * Traits can be relevant to combat or stats, e.g. experience points, Character level, skill
	 * points
	 * <p>
	 * Traits may also be irrelevant to combat or stats, e.g. religion, alignment, race,
	 * nationality
	 * <p>
	 * <i>This object is instantiated by {@link ICharacterType}. When it is instantiated, it should
	 * be set up so that the required traits are guaranteed to be present, and cannot be deleted.
	 * It should also be set up so that changes to certain traits, e.g. experience points or
	 * Character level, trigger custom behavior.</i>
	 * @return Traits of this Character
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	IGenericParamsSet traits() throws IllegalStateException;
	
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
	ISpriteSet getSpriteSet() throws IllegalStateException;
	
	/**
	 * @param spriteSet - The SpriteSet to set for this Character
	 * @throws IllegalArgumentException You <i>may</i> wish to throw this exception if the
	 * provided SpriteSet is null
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setSpriteSet(ISpriteSet spriteSet) throws IllegalArgumentException, IllegalStateException;
	
	/**
	 * @return This Character's AI script ID (to be looked up in GameState.characterAIs)
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	ICharacterAIType getAIType() throws IllegalStateException;
	
	/**
	 * <i>NB: This should still be set for PCs, since the player may lose control of PCs, e.g. 
	 * confusion, charming</i>
	 * @param characterAIType - The AI script to assign to this Character
	 * @throws IllegalArgumentException If characterAIType is null
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setAIType(ICharacterAIType characterAIType)
			throws IllegalArgumentException, IllegalStateException;
	
	/**
	 * @return Parameters affecting the behavior of this Character's AI; examples include preference
	 * for ranged combat, desired distance to allies, or disposition to flee.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	IGenericParamsSet characterAIParams() throws IllegalStateException;
	
	/**
	 * This is similar to
	 * {@link soliloquy.ruleset.gameentities.specs.ICharacterAIType#events}, except it
	 * is for events specific to this Character, instead of all Characters using that
	 * CharacterAIType. Intended use is for events which override or supplement normal behavior of 
	 * its AI script; i.e., you may want this Character to use the default AI, except you might 
	 * want it to explode when it dies.
	 * <p>
	 * The name indices of this Map are names of the events which trigger these CharacterAIEvents
	 * @return A Collection of CharacterAIEvents which occur when certain events occur, e.g. when
	 * the Character is killed, when the Character is close to death, when the demonic ritual is
	 * complete
	 */
	IMap<String,ICollection<ICharacterEvent>> characterEvents();
	
	/**
	 * @return This Character's equipment slots, from which equipment can be accessed or modified
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	ICharacterEquipmentSlots equipmentSlots() throws IllegalStateException;

	/**
	 * @return This Character's inventory, from which inventory can be accessed or modified
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	ICharacterInventory inventory() throws IllegalStateException;

	/**
	 * @return This Character's VitalAttributes, e.g. health, mana
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	IMap<String,ICharacterVitalAttribute> vitalAttributes() throws IllegalStateException;
	
	/**
	 * @return This Character's Attributes, e.g. Intelligence, Swordplay, Etiquette
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	IMap<String,ICharacterAttribute> attributes() throws IllegalStateException;
	
	/**
	 * @return This Character's current StatusEffects, e.g. poisoned, distracted, panicking
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	ICharacterStatusEffects statusEffects() throws IllegalStateException;
	
	/**
	 * @return A named Map of this Character's ActiveAbilities; e.g., Melee Attack, Fireball, Talk
	 * to Character; the Id is the AbilityTypeId
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	IMap<String,ICharacterAbility> activeAbilities() throws IllegalStateException;
	
	/**
	 * @return A named Map of this Character's ReactiveAbilities; e.g., Counter-attack, Absorb
	 * Mana; the Id is the AbilityTypeId
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	IMap<String,ICharacterAbility> reactiveAbilities() throws IllegalStateException;
	
	/**
	 * @return This Character's Aptitudes, e.g. Initiative, Resistance to Fire, Chance to Hit
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	IMap<String,ICharacterAptitude> aptitudes() throws IllegalStateException;
	
	/**
	 * <i>This method should return FALSE when a PC is charmed, confused, or otherwise only 
	 * temporarily uncontrolled by the player. Logic to determine whether the player controls any 
	 * particular PC should be handled //TODO: Specify where this should be handled
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
	 * @return True, if and only if this Character is hidden
	 * <p>
	 * Hidden Characters do not interact with the GameWorld; they exist only to appear (or
	 * reappear) later.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	boolean getHidden() throws IllegalStateException;
	
	/**
	 * @param hidden - Whether the Character will be set to be hidden
	 * <p>
	 * Hidden Characters do not interact with the GameWorld; they exist only to appear (or
	 * reappear) later.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setHidden(boolean hidden) throws IllegalStateException;
	
	/**
	 * @return True, if and only if this Character is dead
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	boolean getDead() throws IllegalStateException;
	
	/**
	 * If a Character is killed by setDead, they will not produce their default death
	 * Animations/Sounds, they will not drop Items, etc.
	 * @param dead - Whether the Character will be set to be dead
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setDead(boolean dead) throws IllegalStateException;
	
	/**
	 * Deletes this Character. (Calling this method will remove this Character from its GameZone's
	 * Characters.)
	 * <p>
	 * This is different from killing this Character or setting them to be dead via setIsDead. In
	 * those cases, the Character still exists in the GameZone's Characters, and may be revived;
	 * when a Character is deleted, they do not exist anymore at all.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void delete() throws IllegalStateException;
}
