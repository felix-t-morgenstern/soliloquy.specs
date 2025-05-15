package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.RoundManager;
import soliloquy.specs.ruleset.entities.character.CharacterAIType;

import java.util.Map;

/**
 * <b>TurnHandling</b>
 * <p>
 * This class runs the turn for a provided Character.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TurnHandling {
    /**
     * @param character       The Character whose turn to run
     * @param turnData        The turn-specific data for this Character (see
     *                        {@link RoundManager#characterRoundData}
     * @param advancingRounds True, if and only if multiple rounds are being advanced at one time
     *                        (see {@link RoundManager#advanceRounds}). If true, the
     *                        {@link CharacterAIType} for the Character in question will not fire;
     *                        and if it is player-controlled, control will not be handed over to the
     *                        player.
     * @throws IllegalArgumentException If and only if character is null
     */
    void runTurn(Character character, Map<String, Object> turnData, boolean advancingRounds)
            throws IllegalArgumentException;
}
