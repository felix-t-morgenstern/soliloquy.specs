package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.ruleset.entities.ItemType;

/**
 * <b>ExternalEntityValidator</b>
 * <p>
 * This class is intended to check whether entities coming in from save files are valid, e.g. save
 * files from the same Ruleset family but from different Games.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ExternalEntityValidator extends SoliloquyClass {
    /**
     * @param character The Character whose validity to check
     * @return True, if and only if character is a valid Character in this Game's Ruleset
     */
    boolean characterIsValid(Character character);

    /**
     * @param itemType The ItemType whose validity to check
     * @return True, if and only if type is a valid ItemType in this Game's Ruleset
     */
    boolean itemTypeIsValid(ItemType itemType);
}
