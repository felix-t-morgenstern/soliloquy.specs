package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IHasId;
import soliloquy.gamestate.specs.ICharacter;
import soliloquy.sprites.specs.ISpriteSet;

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
public interface IElement extends IHasId {
	/**
	 * @param character - The Character whose resistance to this Element is checked
	 * @return The resistance to this Element for character
	 */
	double getResistance(ICharacter character);
	
	/**
	 * @return A SpriteSet to describe this element (e.g. icons, buttons, etc.)
	 */
	ISpriteSet spriteSet();
}
