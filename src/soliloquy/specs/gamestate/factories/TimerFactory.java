package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.OneTimeTimer;
import soliloquy.specs.gamestate.entities.RecurringTimer;
import soliloquy.specs.gamestate.entities.RoundManager;

/**
 * <b>TimerFactory</b>
 * <p>
 * Generates a Timer, given its type Id.
 * <p>
 * When a Timer of any type is created, it is added to the {@link RoundManager}.
 * 
 * @author felix.t.morgenstern
 *
 */
public interface TimerFactory extends SoliloquyClass {
	/**
	 * @param timerId - The Id of the Timer to instantiate
	 * @param action - Action to perform when Timer fires
	 * @param roundWhenGoesOff - The round on which the OneTimeTimer fires
	 * @return The OneTimeTimer
	 * @throws IllegalArgumentException If and only if timerTypeId doesn't correspond to a valid
	 * TimerType,
	 * or if roundWhenGoesOff is less than 1, or if roundWhenGoesOff has already elapsed.
	 */
	OneTimeTimer makeOneTimeTimer(String timerId, Action<Void> action, long roundWhenGoesOff)
			throws IllegalArgumentException;
	
	/**
	 * @param timerId - The Id of the Timer to instantiate
	 * @param action - Action to perform when Timer fires
	 * @param roundModulo - The number of turns between each time this RecurringTimer will fire
	 * @param roundOffset - The turns offset from when (roundNumber mod roundModulo()) is 0 on
	 * which this RecurringTimer will fire
	 * @return The RecurringTimer
	 * @throws IllegalArgumentException If and only if timerTypeId doesn't correspond to a valid
	 * TimerType, or if roundsBetweenFiring is less than 1, or if roundsBeforeFiring is less than 1
	 * or greater than roundsBetweenFiring
	 */
	RecurringTimer makeRecurringTimer(String timerId, Action<Void> action, int roundModulo,
									  int roundOffset)
			throws IllegalArgumentException;
}
