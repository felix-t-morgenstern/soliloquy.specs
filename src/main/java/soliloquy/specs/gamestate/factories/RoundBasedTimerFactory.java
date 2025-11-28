package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.entities.Consumer;
import soliloquy.specs.gamestate.entities.RoundManager;
import soliloquy.specs.gamestate.entities.timers.OneTimeRoundBasedTimer;
import soliloquy.specs.gamestate.entities.timers.RecurringRoundBasedTimer;

/**
 * <b>RoundBasedTimerFactory</b>
 * <p>
 * Generates a RoundBasedTimer, given its type Id.
 * <p>
 * When a RoundBasedTimer of any type is created, it is added to the {@link RoundManager}.
 *
 * @author felix.t.morgenstern
 */
public interface RoundBasedTimerFactory {
    /**
     * @param timerId          The Id of the RoundBasedTimer to instantiate
     * @param action           Action to perform when RoundBasedTimer fires
     * @param roundWhenGoesOff The round on which the OneTimeRoundBasedTimer fires
     * @param priority         The priority of the firing of this RoundBasedTimer relative to
     *                         others; higher
     *                         value implies higher priority
     * @return The OneTimeRoundBasedTimer
     * @throws IllegalArgumentException If and only if timerTypeId doesn't correspond to a valid
     *                                  TimerType,
     *                                  or if roundWhenGoesOff is less than 1, or if
     *                                  roundWhenGoesOff has already elapsed.
     */
    OneTimeRoundBasedTimer makeOneTimeTimer(String timerId, Consumer action, int roundWhenGoesOff,
                                            int priority)
            throws IllegalArgumentException;

    /**
     * @param timerId     The Id of the RoundBasedTimer to instantiate
     * @param action      Action to perform when RoundBasedTimer fires
     * @param roundModulo The number of turns between each time this RecurringRoundBasedTimer will
     *                    fire
     * @param roundOffset The turns offset from when (roundNumber mod roundModulo()) is 0 on which
     *                    this RecurringRoundBasedTimer will fire
     * @param priority    The priority of the firing of this RoundBasedTimer relative to others;
     *                    higher
     *                    value implies higher priority
     * @return The RecurringRoundBasedTimer
     * @throws IllegalArgumentException If and only if timerTypeId doesn't correspond to a valid
     *                                  TimerType, or if roundsBetweenFiring is less than 1, or if
     *                                  roundsBeforeFiring is less than 1
     *                                  or greater than roundsBetweenFiring
     */
    RecurringRoundBasedTimer makeRecurringTimer(String timerId, Consumer action, int roundModulo,
                                                int roundOffset, int priority)
            throws IllegalArgumentException;
}
