package soliloquy.specs.ui.definitions.keyboard;

public class KeyBindingDefinition {
    public final int[] KEY_CODEPOINTS;
    public final String PRESS_CONSUMER_ID;
    public final String RELEASE_CONSUMER_ID;

    private KeyBindingDefinition(int[] keyCodepoints,
                                 String pressConsumerId,
                                 String releaseConsumerId) {
        KEY_CODEPOINTS = keyCodepoints;
        PRESS_CONSUMER_ID = pressConsumerId;
        RELEASE_CONSUMER_ID = releaseConsumerId;
    }

    public static KeyBindingDefinition binding(String pressConsumerId,
                                               String releaseConsumerId,
                                               int... keyCodepoints) {
        return new KeyBindingDefinition(keyCodepoints, pressConsumerId, releaseConsumerId);
    }
}
