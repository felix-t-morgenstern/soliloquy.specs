package soliloquy.specs.gamestate.entities.timers;

import soliloquy.specs.common.shared.SoliloquyClass;

import java.util.List;

/**
 * <b>RoundBasedTimerManager</b>
 * <p>
 * This class manages turn-based timers, i.e., registering, deregistering, and firing them.
 *
 * @author felix.t.morgenstern
 */
public interface RoundBasedTimerManager extends SoliloquyClass {
    /**
     * If the timer is already present, it is not added again.
     *
     * @param oneTimeRoundBasedTimer The one-time turn-based timer to register
     * @throws IllegalArgumentException If and only if oneTimeRoundBasedTimer is null
     */
    void registerOneTimeRoundBasedTimer(OneTimeRoundBasedTimer oneTimeRoundBasedTimer)
            throws IllegalArgumentException;

    /**
     * @param oneTimeRoundBasedTimer The one-time turn-based timer to deregister
     * @throws IllegalArgumentException If and only if oneTimeRoundBasedTimer is null
     */
    void deregisterOneTimeRoundBasedTimer(OneTimeRoundBasedTimer oneTimeRoundBasedTimer)
            throws IllegalArgumentException;

    /**
     * If the timer is already present, it is not added again.
     *
     * @param recurringRoundBasedTimer The recurring turn-based timer to register
     * @throws IllegalArgumentException If and only if oneTimeRoundBasedTimer is null
     */
    void registerRecurringRoundBasedTimer(RecurringRoundBasedTimer recurringRoundBasedTimer)
            throws IllegalArgumentException;

    /**
     * @param recurringRoundBasedTimer The recurring turn-based timer to deregister
     * @throws IllegalArgumentException If and only if oneTimeRoundBasedTimer is null
     */
    void deregisterRecurringRoundBasedTimer(RecurringRoundBasedTimer recurringRoundBasedTimer)
            throws IllegalArgumentException;

    /**
     * This method fires the appropriate RoundBasedTimers based on the number of rounds elapsed.
     * This method also handles the deregistering of OneTimeRoundBasedTimers as they fire. This
     * method is intended to be called by
     * {@link soliloquy.specs.gamestate.entities.RoundManager#advanceRounds}.
     *
     * @param previousRound The previous round, which is currently ending
     * @param newRound      The new round, which begins <i>after</i> this class fires the specified
     *                      Timers
     * @throws IllegalArgumentException If and only if previousRound is the same as or greater than
     *                                  newRound
     */
    void fireTimersForRoundsElapsed(int previousRound, int newRound)
            throws IllegalArgumentException;

    /**
     * @return A List representing the One-Time Timers currently in effect
     */
    List<OneTimeRoundBasedTimer> oneTimeRoundBasedTimersRepresentation();

    /**
     * @return A List representing the Recurring Timers currently in effect
     */
    List<RecurringRoundBasedTimer> recurringRoundBasedTimersRepresentation();
}
