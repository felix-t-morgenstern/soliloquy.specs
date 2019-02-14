package soliloquy.gamestate.specs;

import soliloquy.common.specs.IGlobalAccess;
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
public interface ITimer extends IHasId, IReads, IWrites, IGlobalAccess {
	/**
	 * <i>This method exists, because Timers will need to be saved according to their type; and when the savefile is reloaded, those Timers will need to be regenerated merely by knowing their type.
	 * <p>
	 * Therefore, Timers are expected to be constructed without any external parameters specifying their behavior. Any contingencies in how they behave are to be handled by use of IGlobalAccess.</i>
	 * @return The type of the Timer (which specifies what happens when the Timer is fired)
	 */
	ITimerType timerType();
	
	/**
	 * @return When multiple Timers fire in a Round, they fire in order of their priority
	 */
	int priority();
}
