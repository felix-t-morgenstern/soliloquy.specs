package soliloquy.specs.common.entities;

import soliloquy.specs.common.shared.HasId;

/**
 * <b>Supplier</b>
 * <p>
 * A Supplier is a {@link Function}, which receives no input and supplies an output
 *
 * @param <Output> The type supplied
 * @author felix.t.morgenstern
 * @version 0.0.1
 */

public class Supplier<Output> implements java.util.function.Supplier<Output>, HasId {
    private final String ID;
    private final java.util.function.Supplier<Output> LOGIC;

    private Supplier(String id, java.util.function.Supplier<Output> logic) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Supplier: id cannot be null or empty");
        }
        ID = id;
        if (logic == null) {
            throw new IllegalArgumentException("Supplier: logic cannot be null");
        }
        LOGIC = logic;
    }

    public static <T> Supplier<T> supplier(String id, java.util.function.Supplier<T> logic) {
        return new Supplier<>(id, logic);
    }

    @Override
    public String id() throws IllegalStateException {
        return ID;
    }

    @Override
    public Output get() {
        return LOGIC.get();
    }
}
