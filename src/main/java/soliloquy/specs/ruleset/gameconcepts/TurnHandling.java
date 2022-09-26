package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.CharacterVariableStatistic;

/**
 * <b>TurnHandling</b>
 * <p>
 * This class processes the effects taken on
 * {@link CharacterVariableStatistic}s and
 * {@link soliloquy.specs.gamestate.entities.CharacterStatusEffects} (c.f.
 * {@link soliloquy.specs.ruleset.entities.ActOnCharacterOnTurnAndRound}) at the start of a
 * {@link soliloquy.specs.gamestate.entities.Character}'s turn, or at the end of their turn.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TurnHandling {
    /**
     * Runs the actions (c.f.
     * {@link soliloquy.specs.ruleset.entities.ActOnCharacterOnTurnAndRound}) for a Character at
     * the start of a turn, for a given number of turns, all at once. (Processing all of them at
     * once is intended to fire events for multiple turn starts at one time, when multiple rounds
     * are elapsed at one time; c.f.
     * {@link soliloquy.specs.gamestate.entities.RoundManager#advanceRounds}.)
     *
     * @param character     The Character for whom to process start-of-round actions
     * @param numberOfTurns The number of rounds for which to fire turn start events for
     *                      character
     * @throws IllegalArgumentException If and only if character is null, or numberOfTurns is less
     *                                  than 1
     */
    void onTurnStart(Character character, int numberOfTurns) throws IllegalArgumentException;

    /**
     * Runs the actions (c.f.
     * {@link soliloquy.specs.ruleset.entities.ActOnCharacterOnTurnAndRound}) for a Character at
     * the end of a turn, for a given number of turns, all at once. (Processing all of them at once
     * is intended to fire events for multiple turn starts at one time, when multiple rounds are
     * elapsed at one time; c.f.
     * {@link soliloquy.specs.gamestate.entities.RoundManager#advanceRounds}.)
     *
     * @param character     The Character for whom to process end-of-round actions
     * @param numberOfTurns The number of rounds for which to fire turn end events for character
     * @throws IllegalArgumentException If and only if character is null, or numberOfTurns is less
     *                                  than 1
     */
    void onTurnEnd(Character character, int numberOfTurns) throws IllegalArgumentException;
}
