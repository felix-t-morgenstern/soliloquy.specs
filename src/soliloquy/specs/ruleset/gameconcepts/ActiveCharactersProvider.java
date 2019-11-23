package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.common.infrastructure.ReadableCollection;
import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.gamestate.entities.Character;

/**
 * <b>ActiveCharactersProvider</b>
 * <p>
 * This class provides a Collection of active Characters, paired with the round-specific data for
 * those Characters at the top of a round. Intended use is with
 * {@link soliloquy.specs.gamestate.entities.RoundManager#endActiveCharacterTurn}.
 */
public interface ActiveCharactersProvider {
    /**
     * @return A Collection of active Characters, in order of their turn priority, each paired with
     * round-specific data, corresponding with their data at the start of a round. (See
     * {@link soliloquy.specs.gamestate.entities.RoundManager#characterQueueRepresentation} for
     * more information on the Character queue within a given round.
     */
    ReadableCollection<Pair<Character, VariableCache>> activeCharacters();
}
