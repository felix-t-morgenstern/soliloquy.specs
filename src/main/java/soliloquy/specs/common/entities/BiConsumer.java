package soliloquy.specs.common.entities;

import soliloquy.specs.common.shared.HasId;

import java.util.function.Consumer;

/**
 * <b>BiConsumer</b>
 * <p>
 * A BiConsumer is a {@link soliloquy.specs.common.entities.Consumer} which takes two inputs
 *
 * @param <Input1> The first type of input received
 * @param <Input2> The second type of input received
 * @author felix.t.morgenstern
 * @version 0.0.1
 */

public class BiConsumer<Input1, Input2>
        implements java.util.function.BiConsumer<Input1, Input2>, HasId {
    private final String ID;
    private final java.util.function.BiConsumer<Input1, Input2> LOGIC;

    private BiConsumer(String id, java.util.function.BiConsumer<Input1, Input2> logic) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("BiConsumer: id cannot be null or empty");
        }
        ID = id;
        if (logic == null) {
            throw new IllegalArgumentException("BiConsumer: logic cannot be null");
        }
        LOGIC = logic;
    }

    public static <T1, T2> BiConsumer<T1, T2> biConsumer(String id,
                                                         java.util.function.BiConsumer<T1, T2> logic) {
        return new BiConsumer<>(id, logic);
    }

    @Override
    public String id() throws IllegalStateException {
        return ID;
    }

    public void accept(Input1 input1, Input2 input2) {
        LOGIC.accept(input1, input2);
    }
}
