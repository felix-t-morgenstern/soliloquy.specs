package soliloquy.ruleset.gameentities.abilities.specs;

import soliloquy.gamestate.specs.ICharacter;
import soliloquy.gamestate.specs.IItem;
import soliloquy.gamestate.specs.ITile;

/**
 * <b>AbilitySource</b>
 * <p>
 * Specifies the Item, Character, or Tile which used the Ability. (One and only one of these values should be non-null.)
 * <p>
 * (A lot of the work of classes implementing this interface will be to enforce invariants.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IAbilitySource {
	/**
	 * @return The Ability corresponding to this AbilitySource
	 * @throws IllegalStateException If no Ability has been initialized, or if the Ability does not have this AbilitySource
	 */
	IAbility ability() throws IllegalStateException;
	
	/**
	 * @param ability - The Ability to which to initialize this AbilitySource
	 * @throws IllegalArgumentException If ability is null or if the specified Ability does not have this AbilitySource
	 * @throws UnsupportedOperationException If this AbilitySource has already had its Ability initialized
	 */
	void initializeAbility(IAbility ability) throws IllegalArgumentException, UnsupportedOperationException;
	
	/**
	 * This method will be called by an Item's Abilities when it receives the Ability corresponding to this AbilitySource.
	 * @param item - The Item that is the source of this Ability
	 * @throws IllegalArgumentException If item is null or the Item does not have this Ability
	 * @throws UnsupportedOperationException If the AbilitySource has already been initialized with a source
	 */
	void initializeItemSource(IItem item) throws IllegalArgumentException, UnsupportedOperationException;
	
	/**
	 * @return The Item from which this Ability originated
	 * @throws IllegalStateException If the specified Item does not have this Ability, or if this AbilitySource has more than one source specified
	 */
	IItem item() throws IllegalStateException;

	/**
	 * This method will be called by a Character's Abilities when it receives the Ability corresponding to this AbilitySource.
	 * @param item - The Character that is the source of this Ability
	 * @throws IllegalArgumentException If character is null or the Character does not have this Ability
	 * @throws UnsupportedOperationException If the AbilitySource has already been initialized with a source
	 */
	void initializeCharacterSource(ICharacter character) throws IllegalArgumentException, UnsupportedOperationException;
	
	/**
	 * @return The Character from which this Ability originated
	 * @throws IllegalStateException If the specified Character does not have this Ability, or if this AbilitySource has more than one source specified
	 */
	ICharacter character() throws IllegalStateException;

	/**
	 * This method will be called by a Tile's Abilities when it receives the Ability corresponding to this AbilitySource.
	 * @param item - The Character that is the source of this Ability
	 * @throws IllegalArgumentException If tile is null or the Tile does not have this Ability
	 * @throws UnsupportedOperationException If the AbilitySource has already been initialized with a source
	 */
	void initializeTileSource(ITile tile) throws IllegalArgumentException, UnsupportedOperationException;
	
	/**
	 * @return The Tile from which this Ability originated
	 * @throws IllegalStateException If this AbilitySource has more than one source specified
	 */
	ITile tile() throws IllegalStateException;
}
