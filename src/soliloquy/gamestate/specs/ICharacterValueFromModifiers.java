package soliloquy.gamestate.specs;

import soliloquy.common.specs.IMap;

/**
 * <b>CharacterValueFromModifiers</b>
 * <p>
 * Describes a CharacterValue (e.g. an Attribute, like Wisdom), whose ultimate value is the sum of various modifiers
 * <p>
 * Such modifiers include "Base value", "Amount trained", "Bonuses from items", "Bonuses from other base and trained Attributes", etc.
 * <p>
 * <i><u>Algorithmic calculation vs. storing static values</u></i>
 * <p>
 * As a developer, you will have to decide whether these values are calculated algorithmically, or whether they are stored as static values. If they are stored algorithmically, you will have to throw UnsupportedOperationException on all Map operations which add, alter, or remove items will throw UnsupportedOperationException.
 * <p>
 * If you decide to calculate the values algorithmically, you will only need one instance of this class for every type of value you wish to calculate. Otherwise, you will need one instance of this class for every value for every Character.
 * <p>
 * Additionally, if you decide to store the Characters' values statically (rather than calculate them algorithmically), you will need to occasionally check for errors.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterValueFromModifiers extends IMap<String,Integer> {
	/**
	 * If values are being calculated algorithmically, this class will have to be set properly before each use. If values are being stored as static values, the Character must be initialized once and only once.
	 * @param character - The Character whose value to calculate
	 * @throws IllegalStateException If character is null, or character has been deleted, or character is dead
	 * @throws UnsupportedOperationException If CharacterValueFromModifiers is being implemented as a static storage of values, and the Character has already been initialized
	 */
	void setCharacter(ICharacter character) throws IllegalStateException, UnsupportedOperationException;
	
	/**
	 * This is intended to identify the Character whose value is being calculated.
	 * @return The Id of the Character whose value is being described
	 * @throws IllegalStateException If a Character has not been specified, or if the Character has been deleted, or if the Character is dead
	 */
	ICharacter getCharacter() throws IllegalStateException;
	
	/**
	 * @return The Id of the type of value (e.g. the AttributeType Id, AptitudeType Id, etc.)
	 */
	String valueTypeId();
	
	/**
	 * @return The total value, resulting from all modifiers
	 * @throws IllegalStateException If CharacterValueFromModifiers is being calculated algorithmically, and the Character is either undefined, deleted, or dead
	 */
	int totalValue() throws IllegalStateException;
}
