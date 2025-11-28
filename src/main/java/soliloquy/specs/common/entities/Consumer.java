package soliloquy.specs.common.entities;

import soliloquy.specs.common.shared.HasId;

/**
 * <b>Consumer</b>
 * <p>
 * A Consumer is a {@link Function}, which receives an Input (or perhaps no input), and performs
 * some action with it.
 *
 * @param <Input> The type of inputs received by this Consumer. (If this is Void, then there is no
 *                input.)
 * @author felix.t.morgenstern
 * @version 0.0.1
 */

public class Consumer<Input> implements java.util.function.Consumer<Input>, HasId {
    private final String ID;
    private final java.util.function.Consumer<Input> LOGIC;

    private Consumer(String id, java.util.function.Consumer<Input> logic) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Consumer: id cannot be null or empty");
        }
        ID = id;
        if (logic == null) {
            throw new IllegalArgumentException("Consumer: logic cannot be null");
        }
        LOGIC = logic;
    }

    public static <T> Consumer<T> consumer(String id, java.util.function.Consumer<T> logic) {
        return new Consumer<>(id, logic);
    }

    @Override
    public String id() throws IllegalStateException {
        return ID;
    }

    public void accept(Input input) {
        LOGIC.accept(input);
    }
}
