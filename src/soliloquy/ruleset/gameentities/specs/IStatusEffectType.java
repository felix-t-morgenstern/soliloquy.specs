package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IEntityUuid;
import soliloquy.common.specs.IPair;
import soliloquy.sprites.specs.ISprite;

/**
 * <b>StatusEffectType</b>
 * <p>
 * It has a name and id.
 * <p>
 * It has Actions, which can be performed on each Character, at the start and end of their turn,
 * and the start and end of the round.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IStatusEffectType extends IActOnCharacterOnTurnAndRound, IGameEntity {
	/**
	 * @param iconType - The type of icon to retrieve for a CharacterStatusEffect of this 
	 * StatusEffectType. Example icon types include: Status window icons, health bar icons, etc.
	 * @param characterId - The character for whom to determine the appropriate Icon
	 * @return A Pair, containing the appropriate icon, and an integer with its display priority.
	 * (An example use of display priorities is to have a very severe poisoning be displayed 
	 * before a mild burn, or to have petrification be displayed before being distracted.)
	 */
	IPair<ISprite,Integer> getIcon(String iconType, IEntityUuid characterId);
}
