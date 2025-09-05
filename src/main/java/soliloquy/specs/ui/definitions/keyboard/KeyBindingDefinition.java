package soliloquy.specs.ui.definitions.keyboard;

public class KeyBindingDefinition {
    public final char[] CHARS;
    public final String PRESS_ACTION_ID;
    public final String RELEASE_ACTION_ID;

    private KeyBindingDefinition(char[] chars, String pressActionId, String releaseActionId) {
        CHARS = chars;
        PRESS_ACTION_ID = pressActionId;
        RELEASE_ACTION_ID = releaseActionId;
    }

    public static KeyBindingDefinition binding(String pressActionId, String releaseActionId,
                                               char... chars) {
        return new KeyBindingDefinition(chars, pressActionId, releaseActionId);
    }
}
