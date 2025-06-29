package soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions;

public class StaticMouseCursorProviderDefinition {
    private final String ID;
    private final long MOUSE_CURSOR_IMAGE_ID;

    public StaticMouseCursorProviderDefinition(String id, long mouseCursorImageId) {
        ID = id;
        MOUSE_CURSOR_IMAGE_ID = mouseCursorImageId;
    }

    public String id() {
        return ID;
    }

    public long mouseCursorImageId() {
        return MOUSE_CURSOR_IMAGE_ID;
    }
}
