package soliloquy.specs.gamestate.entities.timers;

/**
 * <b>RecurringRoundBasedTimer</b>
 * <p>
 * Recurring timers are determined by performing a modulo function on the number of the current
 * Round.
 * <p>
 * So, for instance, if roundModulo() returns 3, then the RecurringRoundBasedTimer will fire on
 * every third
 * turn.
 * <p>
 * There is also an offset. So, if roundModulo() returns 3 and roundOffset() returns 1, the
 * RecurringRoundBasedTimer will fire on rounds 1, 4, 7, etc.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RecurringRoundBasedTimer extends RoundBasedTimer {
    /**
     * @return The number of turns between each time this RecurringRoundBasedTimer fires
     */
    int roundModulo();

    /**
     * @return The turns offset from when (roundNumber mod roundModulo()) is 0 on which this
     *         RecurringRoundBasedTimer fires
     */
    int roundOffset();
}
