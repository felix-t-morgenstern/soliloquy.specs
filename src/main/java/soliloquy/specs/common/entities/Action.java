package soliloquy.specs.common.entities;

import soliloquy.specs.common.shared.HasId;

/**
 * <b>Action</b>
 * <p>
 * An Action is a {@link Function}, which receives an Input (or perhaps no input), and performs
 * some action with it.
 *
 * @param <Input> The type of inputs received by this Action. (If this is Void, then there is no
 *                input.)
 * @author felix.t.morgenstern
 * @version 0.0.1
 */

public interface Action<Input> extends HasId {
    /**
     * Runs this Action
     *
     * @param inputs The inputs to this Action
     * @throws IllegalArgumentException If and only if the inputs to this Action is illegal
     */
    @SuppressWarnings("unchecked")
    void run(Input... inputs) throws IllegalArgumentException;
}
