package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.ruleset.entities.actonroundendandcharacterturn.EffectsCharacterOnRoundOrTurnChange;
import soliloquy.specs.ruleset.entities.character.CharacterVariableStatisticType;

/**
 * <b>ActOnRoundEndAndCharacterTurn</b>
 * <p>
 * This class performs {@link EffectsCharacterOnRoundOrTurnChange} actions for all of a
 * {@link Character}'s {@link CharacterVariableStatisticType}s and
 * {@link soliloquy.specs.gamestate.entities.CharacterStatusEffects} for the three phases in which
 * those two entities can take effect: At the end of a round (aka at the start of the next round),
 * at the start of that Character's turn, or at the end of that Character's turn.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ActOnRoundEndAndCharacterTurn {
    /**
     * See {@link EffectsCharacterOnRoundOrTurnChange#onRoundEnd()} for more information.
     *
     * @param character The character for whom to perform all the end-of-round effects.
     * @throws IllegalArgumentException If and only if character is null
     * @throws EntityDeletedException   If and only if character has been deleted
     */
    void roundEnd(Character character) throws IllegalArgumentException, EntityDeletedException;

    /**
     * See {@link EffectsCharacterOnRoundOrTurnChange#onTurnStart()} for more information.
     *
     * @param character The character for whom to perform all the start-of-turn effects.
     * @throws IllegalArgumentException If and only if character is null
     * @throws EntityDeletedException   If and only if character has been deleted
     */
    void turnStart(Character character) throws IllegalArgumentException, EntityDeletedException;

    /**
     * See {@link EffectsCharacterOnRoundOrTurnChange#onTurnEnd()} for more information.
     *
     * @param character The character for whom to perform all the end-of-turn effects.
     * @throws IllegalArgumentException If and only if character is null
     * @throws EntityDeletedException   If and only if character has been deleted
     */
    void turnEnd(Character character) throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param character      The Character whom to effect
     * @param turns          The number of turns for which to effect the Character
     * @param turnHasStarted Whether the Character's turn has already started in this round
     * @param turnHasEnded   Whether the Character's turn has already ended in this round
     * @throws IllegalArgumentException If and only if character is null, or turns is 0 or fewer
     * @throws EntityDeletedException   If and only if character has been deleted
     */
    void affectOverMultipleTurns(Character character, int turns, boolean turnHasStarted,
                                 boolean turnHasEnded)
            throws IllegalArgumentException, EntityDeletedException;
}
