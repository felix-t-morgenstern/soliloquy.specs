package soliloquy.common.specs;

/**
 * <b>Action</b>
 * <p>
 * An Action is a Function, which receives an Input (or perhaps no input), and performs some action.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <Input> The type of Input received by this Action. (If this is Void, then there is no input.)
 */

public interface IAction<Input> extends IHasId, IHasOneGenericParam<Input> {
	/**
	 * Runs this Action
	 * @param input - The input to this Action
	 * @throws IllegalArgumentException If and only if the input to this Action is illegal
	 */
	void run (Input input) throws IllegalArgumentException;
}
