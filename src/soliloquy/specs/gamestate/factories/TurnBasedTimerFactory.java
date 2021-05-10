package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.timers.OneTimeTurnBasedTimer;
import soliloquy.specs.gamestate.entities.timers.RecurringTurnBasedTimer;
import soliloquy.specs.gamestate.entities.RoundManager;

/**
 * <b>TurnBasedTimerFactory</b>
 * <p>
 * Generates a TurnBasedTimer, given its type Id.
 * <p>
 * When a TurnBasedTimer of any type is created, it is added to the {@link RoundManager}.
 * 
 * @author felix.t.morgenstern
 *
 */
public interface TurnBasedTimerFactory extends SoliloquyClass {
	/**
	 * @param timerId The Id of the TurnBasedTimer to instantiate
	 * @param action Action to perform when TurnBasedTimer fires
	 * @param roundWhenGoesOff The round on which the OneTimeTurnBasedTimer fires
	 * @param priority The priority of the firing of this TurnBasedTimer relative to others; higher
	 *                    value implies higher priority
	 * @return The OneTimeTurnBasedTimer
	 * @throws IllegalArgumentException If and only if timerTypeId doesn't correspond to a valid
	 * TimerType,
	 * or if roundWhenGoesOff is less than 1, or if roundWhenGoesOff has already elapsed.
	 */
	OneTimeTurnBasedTimer makeOneTimeTimer(String timerId, Action action, long roundWhenGoesOff,
										   int priority)
			throws IllegalArgumentException;
	
	/**
	 * @param timerId The Id of the TurnBasedTimer to instantiate
	 * @param action Action to perform when TurnBasedTimer fires
	 * @param roundModulo The number of turns between each time this RecurringTurnBasedTimer will
	 *                       fire
	 * @param roundOffset The turns offset from when (roundNumber mod roundModulo()) is 0 on which
	 *                       this RecurringTurnBasedTimer will fire
	 * @param priority The priority of the firing of this TurnBasedTimer relative to others; higher
	 *                    value implies higher priority
	 * @return The RecurringTurnBasedTimer
	 * @throws IllegalArgumentException If and only if timerTypeId doesn't correspond to a valid
	 * TimerType, or if roundsBetweenFiring is less than 1, or if roundsBeforeFiring is less than 1
	 * or greater than roundsBetweenFiring
	 */
	RecurringTurnBasedTimer makeRecurringTimer(String timerId, Action action, int roundModulo,
											   int roundOffset, int priority)
			throws IllegalArgumentException;
}
