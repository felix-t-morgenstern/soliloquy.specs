package soliloquy.specs.common.entities;

import soliloquy.specs.common.shared.HasId;

/**
 * <b>Function</b>
 * <p>
 * An Function receives an Input (or perhaps no input), and produces some Output.
 * <p>
 * A Function has an Id, so that it can be instantiated at load time from a global cache.
 *
 * @param <Input>  The type of Input received by this Function. (If this is Void, then there is no
 *                 input.)
 * @param <Output> The type of Output produced by this Function. (If this is Void, consider using
 *                 an Action instead.)
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class Function<Input, Output> implements java.util.function.Function<Input, Output>, HasId {
    private final String ID;
    private final java.util.function.Function<Input, Output> LOGIC;

    private Function(String id, java.util.function.Function<Input, Output> logic) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Action: id cannot be null or empty");
        }
        ID = id;
        if (logic == null) {
            throw new IllegalArgumentException("Action: logic cannot be null");
        }
        LOGIC = logic;
    }

    public static <TInput, TOutput> Function<TInput, TOutput> function(
            String id,
            java.util.function.Function<TInput, TOutput> logic
    ) {
        return new Function<>(id, logic);
    }

    @Override
    public String id() throws IllegalStateException {
        return ID;
    }

    public Output apply(Input input) {
        return LOGIC.apply(input);
    }
}
