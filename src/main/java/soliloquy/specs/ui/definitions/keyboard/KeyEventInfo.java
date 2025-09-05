package soliloquy.specs.ui.definitions.keyboard;

import soliloquy.specs.io.graphics.renderables.Component;

public class KeyEventInfo {
    public Long timestamp;
    public Component component;
    public Character key;

    private KeyEventInfo() {
    }

    public static KeyEventInfo keyEventInfo() {
        return new KeyEventInfo();
    }

    public KeyEventInfo withTimestamp(long timestamp) {
        this.timestamp = timestamp;

        return this;
    }

    public KeyEventInfo withComponent(Component component) {
        this.component = component;

        return this;
    }

    public KeyEventInfo withKey(char key) {
        this.key = key;

        return this;
    }
}
