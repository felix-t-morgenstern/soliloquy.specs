package soliloquy.specs.gamestate.entities.timers;

/**
 * <b>OneTimeRoundBasedTimer</b>
 * <p>
 * This is a RoundBasedTimer which goes off once, and is then disposed of.
 *
 * @author felix.t.morgenstern
 */
public interface OneTimeRoundBasedTimer extends RoundBasedTimer {
    /**
     * This RoundBasedTimer will go off when the round is elapsed, via Round.advanceRounds().
     * <i>This means that this Timer will fire at the <u>end</u> of the specified round.</i>
     *
     * @return The round on which this RoundBasedTimer will fire
     */
    int roundWhenGoesOff();
}
