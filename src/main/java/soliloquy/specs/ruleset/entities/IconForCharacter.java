package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.valueobjects.Pair;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.graphics.assets.ImageAsset;

/**
 * <b>IconForCharacter</b>
 * <p>
 * This interface contains a method to determine the specific icon for a specific entity type for a
 * specific Character, as well as that icon's display priority.
 * <p>
 * Examples: The icon a character has for the VariableStatisticType of "Health" might
 * change as that Character becomes more damaged.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface IconForCharacter {
    /**
     * @param iconType  The type of icon to retrieve for a
     *                  {@link soliloquy.specs.ruleset.entities.character.StatusEffectType} or
     *                  {@link soliloquy.specs.ruleset.entities.character.VariableStatisticType}.
     *                  Example icon types include: Status window icons, health bar icons, etc.
     * @param character The character for whom to determine the appropriate icon
     * @return A Pair, containing the appropriate icon, and an integer with its display priority.
     *         (An example use of display priorities is to have a very severe poisoning be
     *         displayed before a mild burn, or to have petrification be displayed before being
     *         distracted.)
     * @throws IllegalArgumentException If and only if iconType is null or empty, or character is
     *                                  null
     */
    Pair<ImageAsset, Integer> getIcon(String iconType, Character character)
            throws IllegalArgumentException;
}
