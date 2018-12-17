package soliloquy.gamestate.specs;

import soliloquy.common.specs.IHasId;
import soliloquy.common.specs.IReads;
import soliloquy.common.specs.IWrites;

/**
 * <b>Timer</b>
 * Shared functionality of OneTimeTimer and RecurringTimer
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ITimer extends IHasId, IReads, IWrites {
	/**
	 * @return The type of the Timer (which specifies what happens when the Timer is fired)
	 */
	ITimerType timerType();
	
	/**
	 * @return When multiple Timers fire in a Round, they fire in order of their priority
	 */
	int priority();
}
