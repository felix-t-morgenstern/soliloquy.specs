package soliloquy.specs.common.entities;

import soliloquy.specs.common.shared.HasId;

/**
 * <b>BiFunction</b>
 * <p>
 * A BiFunction receives two inputs, and produces some Output.
 * <p>
 * A BiFunction has an Id, so that it can be instantiated at load time from a global cache.
 *
 * @param <Input1>  The first type of Input received by this BiFunction
 * @param <Input2>  The second type of Input received by this BiFunction
 * @param <Output> The type of Output produced by this BiFunction. (If this is Void, consider using
 *                 an Action instead.)
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class BiFunction<Input1, Input2, Output> implements java.util.function.BiFunction<Input1, Input2, Output>, HasId {
    private final String ID;
    private final java.util.function.BiFunction<Input1, Input2, Output> LOGIC;

    private BiFunction(String id, java.util.function.BiFunction<Input1, Input2, Output> logic) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Action: id cannot be null or empty");
        }
        ID = id;
        if (logic == null) {
            throw new IllegalArgumentException("Action: logic cannot be null");
        }
        LOGIC = logic;
    }

    public static <TInput1, TInput2, TOutput> BiFunction<TInput1, TInput2, TOutput> biFunction(
            String id,
            java.util.function.BiFunction<TInput1, TInput2, TOutput> logic
    ) {
        return new BiFunction<>(id, logic);
    }

    @Override
    public String id() throws IllegalStateException {
        return ID;
    }

    public Output apply(Input1 input1, Input2 input2) {
        return LOGIC.apply(input1, input2);
    }
}
