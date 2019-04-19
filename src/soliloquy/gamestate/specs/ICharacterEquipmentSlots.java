package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>CharacterEquipmentSlots</b>
 * <p>
 * This class handles CharacterEquipmentSlots present on a Character. It exists to handle
 * invariants which must be enforced, since a Character should know its CharacterEquipmentSlots,
 * and CharacterEquipmentSlots should know their Character. To be more specific, every
 * CharacterEquipmentSlot on a Character should know that it belongs to that Character, and
 * vice-versa.
 * <p>
 * This class also supports providing a <i>representation</i> of the CharacterEquipmentSlots on
 * this Character; i.e., a Map containing all of those CharacterEquipmentSlots. <u>Editing the Map
 * provided by getCharacterEquipmentSlotsRepresentation will not change the CharacterEquipmentSlots
 * on the Character.</u> To do that, use the add and remove methods, also provided.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ICharacterEquipmentSlots extends ISoliloquyClass {
    /**
     * <i>NB: This is only supposed to be a REPRESENTATION of the CharacterEquipmentSlots present
     * on this Character. To add or remove CharacterEquipmentSlots, use the other methods
     * specified.</i>
     * @return A Collection of CharacterEquipmentSlots for this Character
     * @throws IllegalStateException If this Character does not have a GameZone, or if this
     * Character has been deleted, or if it has no Id
     */
    ICollection<ICharacterEquipmentSlot> getCharacterEquipmentSlotsRepresentation()
            throws IllegalStateException;

    /**
     * @param characterEquipmentSlot The CharacterEquipmentSlot to add for this Character
     * @throws IllegalArgumentException If and only if characterEquipmentSlot is null
     * @throws IllegalStateException If this Character does not have a GameZone, or if this
     * Character has been deleted, or if it has no Id
     */
    void addCharacterEquipmentSlot(ICharacterEquipmentSlot characterEquipmentSlot)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param characterEquipmentSlot - The CharacterEquipmentSlot to remove
     * @return True, if and only if the CharacterEquipmentSlot was present, and therefore removed
     * @throws IllegalArgumentException If and only if characterEquipmentSlot is null
     * @throws IllegalStateException If this Character does not have a GameZone, or if this
     * Character has been deleted, or if it has no Id
     */
    boolean removeCharacterEquipmentSlot(ICharacterEquipmentSlot characterEquipmentSlot)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param characterEquipmentSlot - The CharacterEquipmentSlot whose presence to verify
     * @return True, if and only if characterEquipmentSlot is present in this
     * CharacterEquipmentSlots
     * @throws IllegalArgumentException If and only if characterEquipmentSlot is null
     * @throws IllegalStateException If this Character does not have a GameZone, or if this
     * Character has been deleted, or if it has no Id
     */
    boolean containsCharacterEquipmentSlot(ICharacterEquipmentSlot characterEquipmentSlot)
            throws IllegalArgumentException, IllegalStateException;
}
