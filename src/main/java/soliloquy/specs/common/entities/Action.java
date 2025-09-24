package soliloquy.specs.common.entities;

import soliloquy.specs.common.shared.HasId;

import java.util.function.Consumer;

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

public class Action<Input> implements Consumer<Input>, HasId {
    private final String ID;
    private final Consumer<Input> LOGIC;

    private Action(String id, Consumer<Input> logic) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Action: id cannot be null or empty");
        }
        ID = id;
        if (logic == null) {
            throw new IllegalArgumentException("Action: logic cannot be null");
        }
        LOGIC = logic;
    }

    public static <T> Action<T> action(String id, Consumer<T> logic) {
        return new Action<>(id, logic);
    }

    @Override
    public String id() throws IllegalStateException {
        return ID;
    }

    public void accept(Input input) {
        LOGIC.accept(input);
    }
}
