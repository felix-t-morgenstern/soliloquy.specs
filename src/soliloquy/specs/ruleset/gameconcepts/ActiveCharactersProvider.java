package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.gamestate.entities.Character;

/**
 * <b>ActiveCharactersProvider</b>
 * <p>
 * This class provides a List of active Characters, paired with the round-specific data for
 * those Characters at the top of a round. Intended use is with
 * {@link soliloquy.specs.gamestate.entities.RoundManager#endActiveCharacterTurn}. Characters are
 * added to ActiveCharactersProvider when they are generated; and at the top of each round, by
 * adding every Character present in the current
 * {@link soliloquy.specs.gamestate.entities.GameZone}.
 */
public interface ActiveCharactersProvider {
    // TODO: Specify where Characters are added or removed from the list of active Characters

    /**
     * NB: This is simply a <i>representation</i> of the active Characters
     *
     * @return A List of active Characters, in order of their turn priority, each paired with
     *         round-specific data, corresponding with their data at the start of a round. (See
     *         {@link soliloquy.specs.gamestate.entities.RoundManager#characterQueueRepresentation}
     *         for
     *         more information on the Character queue within a given round. Characters are added
     *         to
     *         ActiveCharactersProvider when they are generated; and at the top of each round, by
     *         adding
     *         every Character present in the current
     *         {@link soliloquy.specs.gamestate.entities.GameZone}.
     *         It may be possible for Characters to be withheld from activeCharacters by setting
     *         some value
     *         in their data, but that is specific to an individual ruleset.
     */
    List<Pair<Character, VariableCache>> activeCharacters();
}
