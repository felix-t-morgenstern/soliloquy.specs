package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.sprites.entities.SpriteSet;

/**
 * <b>Element</b>
 * <p>
 * An Element is type of effect which can occur to a Character, e.g. fire, ice, healing, poison,
 * unblockable
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Element extends HasId {
	/**
	 * @param character - The Character whose resistance to this Element is checked
	 * @return The resistance to this Element for character
	 */
	double getResistance(Character character);
	
	/**
	 * @return A SpriteSet to describe this element (e.g. icons, buttons, etc.)
	 */
	SpriteSet spriteSet();
}
