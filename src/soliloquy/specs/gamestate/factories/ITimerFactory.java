package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.entities.IAction;
import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.gamestate.entities.IOneTimeTimer;
import soliloquy.specs.gamestate.entities.IRecurringTimer;

/**
 * <b>TimerFactory</b>
 * <p>
 * Generates a Timer, given its type Id.
 * <p>
 * Intended both to initially create a timer initially, as well as to regenerate timers stored in a
 * save file.
 * 
 * @author felix.t.morgenstern
 *
 */
public interface ITimerFactory extends ISoliloquyClass {
	/**
	 * @param timerId - The Id of the Timer to instantiate
	 * @param action - Action to perform when Timer fires
	 * @param roundWhenGoesOff - The round on which the OneTimeTimer fires
	 * @return The OneTimeTimer
	 * @throws IllegalArgumentException If and only if timerTypeId doesn't correspond to a valid
	 * TimerType,
	 * or if roundWhenGoesOff is less than 1, or if roundWhenGoesOff has already elapsed.
	 */
	IOneTimeTimer makeOneTimeTimer(String timerId, IAction<Void> action, long roundWhenGoesOff)
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
	IRecurringTimer makeRecurringTimer(String timerId, IAction<Void> action, int roundModulo,
									   int roundOffset)
			throws IllegalArgumentException;
}
