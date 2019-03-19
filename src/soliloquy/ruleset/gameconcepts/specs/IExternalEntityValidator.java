package soliloquy.ruleset.gameconcepts.specs;

import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.gamestate.specs.ICharacter;
import soliloquy.ruleset.gameentities.specs.IItemType;

/**
 * <b>ExternalEntityValidator</b>
 * <p>
 * This class is intended to check whether entities coming in from save files are valid, e.g. save
 * files from the same Ruleset family but from different Games.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IExternalEntityValidator extends ISoliloquyClass {
	/**
	 * @param character - The Character whose validity to check
	 * @return True, if and only if character is a valid Character in this Game's Ruleset
	 */
	boolean characterIsValid(ICharacter character);

	/**
	 * @param itemType - The ItemType whose validity to check
	 * @return True, if and only if itemType is a valid ItemType in this Game's Ruleset
	 */
	boolean itemTypeIsValid(IItemType itemType);
}
