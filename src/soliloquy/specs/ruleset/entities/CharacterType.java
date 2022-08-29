package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasPluralName;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.gameevents.GameCharacterEvent;

/**
 * <b>CharacterType</b>
 * <p>
 * It has an Id, and it can generate a {@link Character Character} of this CharacterType on a
 * {@link Tile}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterType extends HasPluralName, HasId {
    /**
     * Generates a Character of this CharacterType
     *
     * @param tile   The Tile in which to place the new Character; can be null
     * @param params Parameters specifying how this Character is to be created (e.g. its Id,
     *               whether it is hidden, parameters adjusting dynamic attribute generation,
     *               etc.); can be null
     * @return The newly-created Character
     */
    Character generate(Tile tile, VariableCache params);

    /**
     * @return The default data for this CharacterType, including their default statistics,
     *         classifications, etc.
     */
    VariableCache defaultData();
}
