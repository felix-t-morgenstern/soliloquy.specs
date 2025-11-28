package soliloquy.specs.io.input.keyboard;

import soliloquy.specs.common.entities.Consumer;
import soliloquy.specs.ui.EventInputs;

/**
 * <b>KeyBinding</b>
 * <p>
 * When one or more keys are pressed or released, an action may take place.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class KeyBinding {
    public final int[] BOUND_CODEPOINTS;
    public final Consumer<EventInputs> ON_PRESS;
    public final Consumer<EventInputs> ON_RELEASE;

    private KeyBinding(
            int[] boundCodepoints,
            Consumer<EventInputs> onPress,
            Consumer<EventInputs> onRelease
    ) {
        BOUND_CODEPOINTS = boundCodepoints;
        ON_PRESS = onPress;
        ON_RELEASE = onRelease;
    }

    /**
     * @param boundCodepoints The key codepoints bound
     * @param onPress         The action fired when the key is pressed down
     * @param onRelease       The action fired when the key is raised back up, after being pressed
     *                        down
     */
    public static KeyBinding keyBinding(
            int[] boundCodepoints,
            Consumer<EventInputs> onPress,
            Consumer<EventInputs> onRelease
    ) {
        return new KeyBinding(boundCodepoints, onPress, onRelease);
    }
}
