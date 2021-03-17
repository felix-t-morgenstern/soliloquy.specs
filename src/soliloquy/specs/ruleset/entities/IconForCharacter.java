package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.graphics.assets.ImageAsset;

/**
 * <b>IconForCharacter</b>
 * <p>
 * This interface contains a method to determine the specific icon for a specific entity type for a
 * specific Character, as well as that icon's display priority.
 * <p>
 * Examples: The icon a character has for the CharacterVariableStatisticType of "Health" might
 * change as that Character becomes more damaged.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IconForCharacter<TStatisticType> {
	/**
	 * @param statisticType - The type of statistic to retrieve for this Character
	 * @param iconType - The type of icon to retrieve for a CharacterStatusEffect of this
	 * StatusEffectType. Example icon types include: Status window icons, health bar icons, etc.
	 * @param character - The character for whom to determine the appropriate icon
	 * @return A Pair, containing the appropriate icon, and an integer with its display priority.
	 * (An example use of display priorities is to have a very severe poisoning be displayed 
	 * before a mild burn, or to have petrification be displayed before being distracted.)
	 */
	Pair<ImageAsset,Integer> getIcon(TStatisticType statisticType, String iconType,
									 Character character);
}
