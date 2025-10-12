package soliloquy.specs.ui.definitions.keyboard;

public class KeyBindingDefinition {
    public final char[] KEYS;
    public final String PRESS_ACTION_ID;
    public final String RELEASE_ACTION_ID;

    private KeyBindingDefinition(char[] keys, String pressActionId, String releaseActionId) {
        KEYS = keys;
        PRESS_ACTION_ID = pressActionId;
        RELEASE_ACTION_ID = releaseActionId;
    }

    public static KeyBindingDefinition binding(String pressActionId, String releaseActionId,
                                               char... keys) {
        return new KeyBindingDefinition(keys, pressActionId, releaseActionId);
    }
}
