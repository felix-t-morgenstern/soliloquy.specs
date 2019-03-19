package soliloquy.gamestate.specs;

/**
 * <b>RecurringTimer</b>
 * <p>
 * Recurring timers are determined by performing a modulo function on the number of the current
 * Round.
 * <p>
 * So, for instance, if roundModulo() returns 3, then the RecurringTimer will fire on every third
 * turn.
 * <p>
 * There is also an offset. So, if roundModulo() returns 3 and roundOffset() returns 1, the
 * RecurringTimer will fire on rounds 1, 4, 7, etc. 
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IRecurringTimer extends ITimer {
	/**
	 * @return The number of turns between each time this RecurringTimer fires
	 */
	int getRoundModulo();
	
	/**
	 * @param roundModulo - The number of turns between each time this RecurringTimer will fire
	 * @throws IllegalArgumentException If roundModulo is less than one, or if it is less than or
	 * equal to roundOffset
	 */
	void setRoundModulo(int roundModulo) throws IllegalArgumentException;
	
	/**
	 * @return The turns offset from when (roundNumber mod roundModulo()) is 0 on which this
	 * RecurringTimer fires
	 */
	int getRoundOffset();
	
	/**
	 * @param roundOffset - The turns offset from when (roundNumber mod roundModulo()) is 0 on
	 * which this RecurringTimer will fire
	 * @throws IllegalArgumentException If roundOffset is less than zero, or greater than or equal
	 * to roundModulo
	 */
	void setRoundOffset(int roundOffset) throws IllegalArgumentException;
}
