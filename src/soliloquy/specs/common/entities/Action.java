package soliloquy.specs.common.entities;

import soliloquy.specs.common.shared.HasGlobalAccess;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasOneGenericParam;

/**
 * <b>Action</b>
 * <p>
 * An Action is a {@link Function}, which receives an Input (or perhaps no input), and performs
 * some action with it.
 *
 * @param <Input> The type of Input received by this Action. (If this is Void, then there is no
 *                input.)
 * @author felix.t.morgenstern
 * @version 0.0.1
 */

public interface Action<Input> extends HasId, HasOneGenericParam<Input>, HasGlobalAccess {
    /**
     * Runs this Action
     *
     * @param input The input to this Action
     * @throws IllegalArgumentException If and only if the input to this Action is illegal
     */
    void run(Input input) throws IllegalArgumentException;
}
