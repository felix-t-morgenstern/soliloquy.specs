package soliloquy.specs.ruleset.gameconcepts;

/**
 * <b>RoundEndHandling</b>
 * <p>
 * This class runs a round.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RoundEndHandling {
    /**
     * Handles end-of-round
     * {@link
     * soliloquy.specs.ruleset.entities.actonroundendandcharacterturn.EffectsCharacterOnRoundOrTurnChange.EffectsOnCharacter}s.
     *
     * @param advancingRounds True, if and only if multiple rounds are being advanced at one time
     *                        (see
     *                        {@link soliloquy.specs.gamestate.entities.RoundManager#advanceRounds}
     */
    void runRoundEnd(boolean advancingRounds);
}
