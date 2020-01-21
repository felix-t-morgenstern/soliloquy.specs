package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.HasId;

/**
 * <b>Timer</b>
 * <p>
 * Shared functionality of OneTimeTimer and RecurringTimer
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Timer extends HasId, Deletable {
	/**
	 * @return The Id of the type of {@link soliloquy.specs.common.entities.Action} which runs when
	 * this Timer is fired
	 */
	Action action();

	/**
	 * Fires the Timer. For {@link OneTimeTimer}s, this also calls {@link OneTimeTimer#delete}.
	 */
	void fire();
	
	/**
	 * (NB: When multiple Timers firing on a Round have the same priority, all of them will be 
	 * fired successfully, but their order cannot be guaranteed. This value can be set to negative 
	 * values.)
	 * @return When multiple Timers fire in a Round, they fire in order of this priority
	 */
	int getPriority();
	
	/**
	 * (NB: When multiple Timers firing on a Round have the same priority, all of them will be 
	 * fired successfully, but their order cannot be guaranteed. This value can be set to negative 
	 * values.)
	 * @param priority - When multiple Timers fire in a Round, they fire in order of this priority
	 */
	void setPriority(int priority);
}
