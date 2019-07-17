package soliloquy.specs.common.entities;

import soliloquy.specs.common.shared.HasTwoGenericParams;
import soliloquy.specs.common.shared.HasGlobalAccess;
import soliloquy.specs.common.shared.HasId;

/**
 * <b>Function</b>
 * <p>
 * An Function receives an Input (or perhaps no input), and produces some Output.
 * <p>
 * A Function has an Id, so that it can be instantiated at load time from a global cache. (For
 * instance, a Map may have a custom validator, which
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <Input> The type of Input received by this Function. (If this is Void, then there is no
 * input.)
 * @param <Output> The type of Output produced by this Function. (If this is Void, consider using
 * an Action instead.)
 */
public interface Function<Input,Output>
		extends HasId, HasTwoGenericParams<Input,Output>, HasGlobalAccess {
	/**
	 * Runs this Function
	 * @param input - The input to this Action
	 * @return The output of this Function
	 * @throws IllegalArgumentException If and only if the input to this Action is illegal
	 */
	Output run(Input input) throws IllegalArgumentException;
}
