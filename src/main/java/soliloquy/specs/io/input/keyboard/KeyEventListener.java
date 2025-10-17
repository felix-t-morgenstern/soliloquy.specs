package soliloquy.specs.io.input.keyboard;

/**
 * <b>KeyEventListener</b>
 * <p>
 * This class is used by {@link soliloquy.specs.io.bootstrap.CoreLoop} to establish listeners to key
 * press events, and to pass those events onto {@link KeyEventHandler}
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface KeyEventListener {
    /**
     * To be called by {@link soliloquy.specs.io.bootstrap.CoreLoop#startup}; registers key event
     * listening to CoreLoop
     * @param window The window for which to register the listener
     */
    void registerKeyListener(long window);

    /**
     * Reports key press and release events to {@link KeyEventHandler#press} and
     * {@link KeyEventHandler#release}
     * @param timestamp The time at which key events are handled
     * @throws IllegalArgumentException If and only if timestamp is invalid
     */
    void reportKeyEvents(long timestamp) throws IllegalArgumentException;
}
