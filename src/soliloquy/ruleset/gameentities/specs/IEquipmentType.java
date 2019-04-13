package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IHasId;
import soliloquy.common.specs.IHasPluralName;

/**
 * <b>EquipmentType</b>
 * <p>
 * This class is a property of {@link IItemType}s. It is intended to be used by
 * {@link soliloquy.gamestate.specs.ICharacterEquipmentSlot #canEquipItemToSlot(IItem)}, to
 * determine whether an ItemType of this EquipmentType can be equipped to a CharacterEquipmentSlot.
 * <p>
 * Examples include helmets, necklaces, mystical auras, makeup, etc.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IEquipmentType extends IHasId, IHasPluralName {
}
