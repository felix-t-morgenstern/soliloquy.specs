package soliloquy.specs.common.entities;

import soliloquy.specs.common.shared.HasId;

/**
 * <b>Runnable</b>
 * <p>
 * A Runnable is a {@link Function}, which receives no input or output
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */

public class Runnable implements java.lang.Runnable, HasId {
    private final String ID;
    private final java.lang.Runnable LOGIC;

    private Runnable(String id, java.lang.Runnable logic) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Runnable: id cannot be null or empty");
        }
        ID = id;
        if (logic == null) {
            throw new IllegalArgumentException("Runnable: logic cannot be null");
        }
        LOGIC = logic;
    }

    public static Runnable runnable(String id, java.lang.Runnable logic) {
        return new Runnable(id, logic);
    }

    @Override
    public String id() throws IllegalStateException {
        return ID;
    }

    @Override
    public void run() {
        LOGIC.run();
    }
}
