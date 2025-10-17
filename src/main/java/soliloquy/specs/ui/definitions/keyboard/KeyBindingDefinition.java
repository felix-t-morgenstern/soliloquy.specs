package soliloquy.specs.ui.definitions.keyboard;

public class KeyBindingDefinition {
    public final int[] KEY_CODEPOINTS;
    public final String PRESS_ACTION_ID;
    public final String RELEASE_ACTION_ID;

    private KeyBindingDefinition(int[] keyCodepoints,
                                 String pressActionId,
                                 String releaseActionId) {
        KEY_CODEPOINTS = keyCodepoints;
        PRESS_ACTION_ID = pressActionId;
        RELEASE_ACTION_ID = releaseActionId;
    }

    public static KeyBindingDefinition binding(String pressActionId,
                                               String releaseActionId,
                                               int... keyCodepoints) {
        return new KeyBindingDefinition(keyCodepoints, pressActionId, releaseActionId);
    }
}
