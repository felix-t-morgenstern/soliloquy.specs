package soliloquy.ruleset.gameentities.specs;

import soliloquy.gamestate.specs.ICharacter;
import soliloquy.sprites.specs.ISpriteSet;

/**
 * <b>Attribute</b>
 * <p>
 * An Attribute, which can be held by a Character (i.e. in {@link ICharacterAttributes})
 * <p>
 * This class determines whether a Character can adjust an Attribute by a specified amount, e.g. while leveling up\
 * <p>
 * It has a description, and a SpriteSet for graphical depictions
 * 
 * @author felix.t.morgenstern
 *
 */
public interface IAttribute extends IGameEntity {
	/**
	 * Intended use is for when Characters are adjusting stats (e.g. leveling up) to enforce both minimum stats (e.g. not allowing Strength to fall below 1) and Attribute requirements (e.g. preventing Swordplay from being increased beyond the value of Dexterity) 
	 * <p>
	 * This intended use is only intended for the <i>trained</i> Attribute values. It is not intended to have any bearing on modifiers from Items, CharacterStatusEffects, etc.
	 * @param character - The Character whom to check to see whether they can adjust this Attribute by the specified amount
	 * @param amount - The amount of the adjustment being checked
	 * @return True, if and only if the Character can adjust this Attribute by this amount
	 * @throws NullPointerException If character is null
	 */
	boolean charCanAdjust(ICharacter character, int amount) throws NullPointerException;
	
	/**
	 * @return The description of this Attribute
	 */
	String getDescription();
	
	/**
	 * @param description - The description to set for this Attribute
	 */
	void setDescription(String description);
	
	/**
	 * Intended use for this SpriteSet is for any icons or pictures associated with this Attribute.
	 * @return The SpriteSet for this Attribute (can be null)
	 */
	ISpriteSet getSpriteSet();
	
	/**
	 * Intended use for this SpriteSet is for any icons or pictures associated with this Attribute.
	 * @param spriteSet - The SpriteSet to set for this Attribute (can be null)
	 */
	void setSpriteSet(ISpriteSet spriteSet);
}
