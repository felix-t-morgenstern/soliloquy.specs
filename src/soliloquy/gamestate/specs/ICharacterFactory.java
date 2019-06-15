package soliloquy.gamestate.specs;

import soliloquy.common.specs.IEntityUuid;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.ruleset.gameentities.specs.ICharacterType;

/**
 * <b>ICharacterFactory</b>
 * <p>
 * This class is responsible for taking a {@link ICharacterType} and generating a blank
 * {@link ICharacter} of that type.
 * <p>
 * <i>NB: {@link ICharacterType} is responsible for calling {@link #make}, and then setting values
 * such as base attributes, equipment slots, inventory items, etc. This is necessary to allow
 * CharacterTypes to be generated dynamically, without forcing a specific pattern of  value
 * generation.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ICharacterFactory extends ISoliloquyClass {
	/**
	 * This method creates a {@link ICharacter} with a randomly-generated {@link IEntityUuid}. To
	 * provide a specific IEntityUuid, use {@link #make(ICharacterType, IEntityUuid)}.
	 * @param characterType - The {@link ICharacterType} of which to make a new {@link ICharacter}
	 * @return The newly-created {@link ICharacter}
	 * @throws IllegalArgumentException If and only if characterType is null
	 */
	ICharacter make(ICharacterType characterType) throws IllegalArgumentException;

	/**
	 * @param characterType - The {@link ICharacterType} of which to make a new {@link ICharacter}
	 * @param entityUuid - The id for the newly-created {@link ICharacter}
	 * @return The newly-created {@link ICharacter}
	 * @throws IllegalArgumentException If and only if characterType or entityUuid is null
	 */
	ICharacter make(ICharacterType characterType, IEntityUuid entityUuid)
			throws IllegalArgumentException;
}
