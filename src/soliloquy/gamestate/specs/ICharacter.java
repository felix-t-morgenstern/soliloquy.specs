package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IHasUuid;
import soliloquy.common.specs.IMap;
import soliloquy.ruleset.gameentities.specs.ICharacterClassification;
import soliloquy.ruleset.gameentities.specs.ICharacterType;
import soliloquy.ruleset.gameentities.specs.IGameEntity;
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
	 * @param gameZone - The GameZone to which to move this Character
	 * @throws IllegalArgumentException If gameZone is null
	 * @throws IllegalStateException If this Character has been deleted, or if it has no Id
	 */
	void setGameZone(IGameZone gameZone) throws IllegalArgumentException, IllegalStateException;
	
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
	 * @throws IllegalStateException If this Character does not have an AI script
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	String getAITypeId() throws IllegalStateException, IllegalStateException;
	
	/**
	 * @param characterAIId - The ID of the AI script to assign to this Character
	 * @throws IllegalArgumentException If ai is null
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setAITypeId(String characterAITypeId) throws IllegalArgumentException, IllegalStateException;
	
	/**
	 * @return Parameters affecting the behavior of this Character's AI; examples include preference
	 * for ranged combat, desired distance to allies, or disposition to flee.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	IGenericParamsSet characterAIParams() throws IllegalStateException;
	
	/**
	 * @return This Character's equipment
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	IMap<String,ICharacterEquipmentSlot> equipment() throws IllegalStateException;
	
	/**
	 * @return This Character's inventory
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	IMap<Integer,IItem> inventory() throws IllegalStateException;
	
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
	IMap<String,ICharacterValueFromModifiers> attributes() throws IllegalStateException;
	
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
	IMap<String,ICharacterValueFromModifiers> aptitudes() throws IllegalStateException;
	
	/**
	 * @return True, if and only if this Character is a PlayerCharacter
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	boolean isPC() throws IllegalStateException;
	
	/**
	 * @return True, if and only if this Character is hidden
	 * <p>
	 * Hidden Characters do not interact with the GameWorld; they exist only to appear (or
	 * reappear) later.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	boolean isHidden() throws IllegalStateException;
	
	/**
	 * @param isHidden - Whether the Character will be set to be hidden
	 * <p>
	 * Hidden Characters do not interact with the GameWorld; they exist only to appear (or
	 * reappear) later.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setHidden(boolean isHidden) throws IllegalStateException;
	
	/**
	 * @return True, if and only if this Character is dead
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	boolean isDead() throws IllegalStateException;
	
	/**
	 * If a Character is killed by setIsDead, they will not produce their default death
	 * Animations/Sounds, they will not drop Items, etc.
	 * @param isDead - Whether the Character will be set to be dead
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void setIsDead(boolean isDead) throws IllegalStateException;
	
	/**
	 * Killing a Character is different from setting a Character to be dead through setIsDead. If a
	 * Character is killed via kill, they will display their normal death Animations/Sounds, they
	 * will drop their Items, etc.
	 * <p>
	 * Killing a Character by kill is intended to trigger an event in the Character's AI script,
	 * e.g. "KILLED" 
	 * @param killer - The Character who killed this Character. This value can be null.
	 * @throws IllegalStateException If this Character does not have a GameZone, or if this
	 * Character has been deleted, or if it has no Id
	 */
	void kill(ICharacter killer) throws IllegalStateException;
	
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
