package soliloquy.gamestate.specs;

import soliloquy.common.specs.IHasId;

/**
 * <b>TimerType</b>
 * <p>
 * It has an Id identifying its Type.
 * <p>
 * It has an event which can be fired.
 * <p>
 * The behavior of this Timer MUST be consistent for EVERY SINGLE INSTANCE of the TimerType.
 * <p>
 * This is because the TimerType must be saved to file, and then recreated; so it must be able to
 * be recreated, in whole, just from its Id.
 *  
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ITimerType extends IHasId {
	/**
	 * This triggers the Timer's associated behavior.
	 */
	void fire();
}
