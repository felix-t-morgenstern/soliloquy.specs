package soliloquy.specs.ui.definitions.keyboard;

public class KeyBindingDefinition {
    public final Character[] CHARS;
    public final String PRESS_ACTION_ID;
    public final String RELEASE_ACTION_ID;

    private KeyBindingDefinition(Character[] chars, String pressActionId, String releaseActionId) {
        CHARS = chars;
        PRESS_ACTION_ID = pressActionId;
        RELEASE_ACTION_ID = releaseActionId;
    }

    public static KeyBindingDefinition binding(String pressActionId, String releaseActionId,
                                               Character... chars) {
        return new KeyBindingDefinition(chars, pressActionId, releaseActionId);
    }
}
