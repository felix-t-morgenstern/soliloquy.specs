package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.common.shared.HasUuid;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.graphics.assets.ImageAssetSet;
import soliloquy.specs.ruleset.entities.CharacterAIType;
import soliloquy.specs.ruleset.entities.CharacterStaticStatisticType;
import soliloquy.specs.ruleset.entities.CharacterType;
import soliloquy.specs.ruleset.entities.abilities.ActiveAbility;
import soliloquy.specs.ruleset.entities.abilities.PassiveAbility;
import soliloquy.specs.ruleset.entities.abilities.ReactiveAbility;
import soliloquy.specs.ruleset.valueobjects.CharacterClassification;

import java.util.List;
import java.util.Map;

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
 */
public interface Character extends TileEntity, HasName, HasUuid {
    /**
     * @return The CharacterType of this Character
     *         <p>
     *         This value may be null, e.g. in cases of PlayerCharacters
     * @throws EntityDeletedException If this Character has been deleted
     */
    CharacterType type() throws EntityDeletedException;

    /**
     * @return The Classifications of this Character, e.g. "undead", "elemental", etc.
     * @throws EntityDeletedException If this Character has been deleted
     */
    List<CharacterClassification> classifications() throws EntityDeletedException;

    /**
     * @return The proper pronouns for this Character. The key for the Map is the grammatical case
     *         in question (e.g. nominative, oblique, genitive, etc.). Every Character can choose
     *         their own
     *         pronouns.
     * @throws EntityDeletedException If this Character has been deleted
     */
    Map<String, String> pronouns() throws EntityDeletedException;

    // NB: This method is already defined on HasData, but the description here improves the API docs

    /**
     * Data can be traits relevant to combat or stats, e.g. experience points, Character level,
     * skill points
     * <p>
     * Data can be relevant to combat behavior, e.g. desired distance from enemies, preferred
     * abilities to use, etc.
     * <p>
     * Data may also be irrelevant to combat or stats, e.g. religion, alignment, race, nationality
     *
     * @return Traits of this Character
     * @throws EntityDeletedException If this Character has been deleted
     */
    VariableCache data() throws EntityDeletedException;

    /**
     * @return The stance of the Character; e.g. "combat-ready", "attacking", "near-death"; which
     *         is used to determine its current Sprite
     * @throws EntityDeletedException If this Character has been deleted
     */
    String getStance() throws EntityDeletedException;

    /**
     * @param stance The stance to set for this Character
     * @throws EntityDeletedException If this Character has been deleted
     */
    void setStance(String stance) throws EntityDeletedException;

    /**
     * @return The current direction of this Character, e.g. "NW", "S"
     * @throws EntityDeletedException If this Character has been deleted
     */
    String getDirection() throws EntityDeletedException;

    /**
     * @param direction The direction to set for this Character, e.g. "N", "NW"
     * @throws IllegalArgumentException If the provided direction is illegal, e.g. if it is null, a
     *                                  blank string, not a valid direction
     * @throws EntityDeletedException   If this Character has been deleted
     */
    void setDirection(String direction) throws IllegalArgumentException, EntityDeletedException;

    /**
     * @return The ImageAssetSet for this Character
     * @throws EntityDeletedException If this Character has been deleted
     */
    ImageAssetSet getImageAssetSet() throws EntityDeletedException;

    /**
     * @param imageAssetSet The ImageAssetSet to set for this Character
     * @throws IllegalArgumentException You <i>may</i> wish to throw this exception if the
     *                                  provided ImageAssetSet is null
     * @throws EntityDeletedException   If this Character has been deleted
     */
    void setImageAssetSet(ImageAssetSet imageAssetSet)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * @return This Character's AI script ID (to be looked up in GameState.characterAIs)
     * @throws EntityDeletedException If this Character has been deleted
     */
    CharacterAIType getAIType() throws EntityDeletedException;

    /**
     * <i>NB: This should still be set for PCs, since the player may lose control of PCs, e.g.
     * confusion, charming</i>
     *
     * @param characterAIType The AI script to assign to this Character
     * @throws IllegalArgumentException If characterAIType is null
     * @throws EntityDeletedException   If this Character has been deleted
     */
    void setAIType(CharacterAIType characterAIType)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * The index of this map is a type of triggering event, i.e. "onDeath", "onAttacked",
     * "onSeeParty", etc. The values are the collections of events fired for this Character when
     * the corresponding type of trigger occurs.
     *
     * @return A Map, describing events which occur for this Character, given various types of
     *         triggers
     */
    CharacterEvents events();

    /**
     * @return This Character's equipment slots, from which equipment can be accessed or modified
     * @throws EntityDeletedException If this Character has been deleted
     */
    CharacterEquipmentSlots equipmentSlots() throws EntityDeletedException;

    /**
     * @return This Character's inventory, from which inventory can be accessed or modified
     * @throws EntityDeletedException If this Character has been deleted
     */
    CharacterInventory inventory() throws EntityDeletedException;

    /**
     * @return This Character's variable statistics, e.g. health, mana
     * @throws EntityDeletedException If this Character has been deleted
     */
    CharacterVariableStatistics variableStatistics() throws EntityDeletedException;

    /**
     * @return This Character's static statistics, e.g. Intelligence, Swordplay, Etiquette
     * @throws EntityDeletedException If this Character has been deleted
     */
    EntityMembersOfType<CharacterStaticStatisticType,
            CharacterStatistic<CharacterStaticStatisticType>, Character> staticStatistics()
            throws EntityDeletedException;

    /**
     * @return This Character's current StatusEffects, e.g. poisoned, distracted, panicking
     * @throws EntityDeletedException If this Character has been deleted
     */
    CharacterStatusEffects statusEffects() throws EntityDeletedException;

    /**
     * @return A collection of this Character's PassiveAbilities; e.g., Exceptional Dodge, Friendly
     *         Demeanor, Large Poops; this is also used to add PassiveAbilities to the Character
     * @throws EntityDeletedException If this Character has been deleted
     */
    List<PassiveAbility> passiveAbilities() throws EntityDeletedException;

    /**
     * @return A collection of this Character's ActiveAbilities; e.g., Melee Attack, Fireball, Talk
     *         to Character; this is also used to add ActiveAbilities to the Character
     * @throws EntityDeletedException If this Character has been deleted
     */
    List<ActiveAbility> activeAbilities() throws EntityDeletedException;

    /**
     * @return A collection of this Character's ReactiveAbilities; e.g., Counter-attack, Absorb
     *         Mana; this is also used to add ReactiveAbilities to the Character
     * @throws EntityDeletedException If this Character has been deleted
     */
    List<ReactiveAbility> reactiveAbilities() throws EntityDeletedException;

    /**
     * <i>This method should return FALSE when a PC is charmed, confused, or otherwise only
     * temporarily uncontrolled by the player. Logic to determine whether the player controls any
     * particular PC should be handled by the logic fed into the
     * {@link soliloquy.specs.gamestate.entities.RoundManager}'s constructor by the Ruleset.
     *
     * @return True, if and only if this Character is controlled by the player
     * @throws EntityDeletedException If this Character has been deleted
     */
    boolean getPlayerControlled() throws EntityDeletedException;

    /**
     * @param playerControlled True, if and only if this Character is controlled by the player
     * @throws EntityDeletedException If this Character has been deleted
     */
    void setPlayerControlled(boolean playerControlled) throws EntityDeletedException;

    /**
     * Deletes this Character. (Calling this method will remove this Character from its GameZone's
     * Characters. It will also delete all contained entities, e.g. movementEvents, inventory, etc.)
     * <p>
     * This is different from killing this Character or setting them to be dead via setIsDead. In
     * those cases, the Character still exists in the GameZone's Characters, and may be revived;
     * when a Character is deleted, they do not exist anymore at all.
     *
     * @throws EntityDeletedException If this Character has been deleted
     */
    void delete() throws EntityDeletedException;
}
