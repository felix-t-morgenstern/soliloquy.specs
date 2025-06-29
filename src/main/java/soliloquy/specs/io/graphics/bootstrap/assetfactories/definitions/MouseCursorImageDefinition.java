package soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions;

/**
 * <b>MouseCursorImageDefinition</b>
 * <p>
 * This class defines an image to be provided to a
 * {@link soliloquy.specs.io.graphics.bootstrap.assetfactories.MouseCursorImageFactory}
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class MouseCursorImageDefinition {
    private final String RELATIVE_LOCATION;
    private final int HOTSPOT_X;
    private final int HOTSPOT_Y;

    public MouseCursorImageDefinition(String relativeLocation, int hotspotX, int hotspotY) {
        RELATIVE_LOCATION = relativeLocation;
        HOTSPOT_X = hotspotX;
        HOTSPOT_Y = hotspotY;
    }

    public String relativeLocation() {
        return RELATIVE_LOCATION;
    }

    public int hotspotX() {
        return HOTSPOT_X;
    }

    public int hotspotY() {
        return HOTSPOT_Y;
    }
}
