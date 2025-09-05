package soliloquy.specs.io.input.keyboard.entities;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.ui.definitions.keyboard.KeyEventInfo;

/**
 * <b>KeyBinding</b>
 * <p>
 * When one or more keys are pressed or released, an action may take place.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class KeyBinding {
    public final char[] BOUND_KEYS;
    public final Action<KeyEventInfo> ON_PRESS;
    public final Action<KeyEventInfo> ON_RELEASE;

    private KeyBinding(
            char[] boundKeys,
            Action<KeyEventInfo> onPress,
            Action<KeyEventInfo> onRelease
    ) {
        BOUND_KEYS = boundKeys;
        ON_PRESS = onPress;
        ON_RELEASE = onRelease;
    }

    public static KeyBinding keyBinding(
            char[] boundKeys,
            Action<KeyEventInfo> onPress,
            Action<KeyEventInfo> onRelease
    ) {
        return new KeyBinding(boundKeys, onPress, onRelease);
    }
}
