package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.infrastructure.Collection;
import soliloquy.specs.common.infrastructure.GenericParamsSet;
import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasPluralName;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Tile;

/**
 * <b>CharacterType</b>
 * <p>
 * It has an Id, and it can generate a {@link Character Character} of this CharacterType on a
 * {@link Tile}.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface CharacterType extends HasPluralName, HasId {
	/**
	 * Generates a Character of this CharacterType
	 * @param tile - The Tile in which to place the new Character; can be null
	 * @param params - Parameters specifying how this Character is to be created (e.g. its Id,
	 *                  whether it is hidden, parameters adjusting dynamic attribute generation,
	 *                  etc.); can be null
	 * @return The newly-created Character
	 */
	Character generate(Tile tile, GenericParamsSet params);

	/**
	 * The name keys of this Map are names of the movementEvents which trigger these Actions
	 * @return A Collection of Actions which occur from the Character of this type when certain
	 * movementEvents occur, e.g. when the Character is killed, when the Character is close to death, when
	 * the demonic ritual is complete
	 */
	Map<String, Collection<Action<Character>>> events();
}
