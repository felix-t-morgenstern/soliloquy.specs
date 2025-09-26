package soliloquy.specs.io.bootstrap.assetfactories.definitions;

/**
 * <b>ImageDefinition</b>
 * <p>
 * This class defines an {@link soliloquy.specs.io.graphics.assets.Image}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class ImageDefinition {
    private final String RELATIVE_LOCATION;
    private final boolean SUPPORTS_MOUSE_EVENT_CAPTURING;

    public ImageDefinition(String relative_location, boolean supportsMouseEventCapturing) {
        RELATIVE_LOCATION = relative_location;
        SUPPORTS_MOUSE_EVENT_CAPTURING = supportsMouseEventCapturing;
    }

    /**
     * @return C.f. {@link soliloquy.specs.io.graphics.assets.Image#relativeLocation()}
     */
    public String relativeLocation() {
        return RELATIVE_LOCATION;
    }

    /**
     * @return C.f. {@link soliloquy.specs.io.graphics.assets.Image#supportsMouseEventCapturing()}
     */
    public boolean supportsMouseEventCapturing() {
        return SUPPORTS_MOUSE_EVENT_CAPTURING;
    }
}
