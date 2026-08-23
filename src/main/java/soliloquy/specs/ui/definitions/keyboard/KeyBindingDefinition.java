package soliloquy.specs.ui.definitions.keyboard;

public class KeyBindingDefinition {
    public final int[] KEY_CODEPOINTS;

    public String pressConsumerId;
    public String releaseConsumerId;

    private KeyBindingDefinition(int[] keyCodepoints) {
        KEY_CODEPOINTS = keyCodepoints;
    }

    public static KeyBindingDefinition binding(int... keyCodepoints) {
        return new KeyBindingDefinition(keyCodepoints);
    }

    public KeyBindingDefinition onPress(String pressConsumerId) {
        this.pressConsumerId = pressConsumerId;

        return this;
    }

    public KeyBindingDefinition onRelease(String releaseConsumerId) {
        this.releaseConsumerId = releaseConsumerId;

        return this;
    }
}
