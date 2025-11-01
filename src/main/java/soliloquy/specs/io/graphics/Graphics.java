package soliloquy.specs.io.graphics;

import soliloquy.specs.io.graphics.assets.*;
import soliloquy.specs.io.graphics.renderables.Component;

import java.util.UUID;

public interface Graphics {
    /**
     * @param relLoc The relative location of the image file (c.f. {@link Image#relativeLocation()}
     * @return The image corresponding to the file; null, if not present
     */
    Image getImage(String relLoc);

    /**
     * @param id The Sprite Id
     * @return The Sprite; null, if not present
     */
    Sprite getSprite(String id);

    /**
     * @param id The Animation Id
     * @return The Animation; null, if not present
     */
    Animation getAnimation(String id);

    /**
     * @param id The GlobalLoopingAnimation Id
     * @return The GlobalLoopingAnimation; null, if not present
     */
    GlobalLoopingAnimation getGlobalLoopingAnimation(String id);

    /**
     * @param id The ImageAssetSet Id
     * @return The ImageAssetSet; null, if not present
     */
    ImageAssetSet getImageAssetSet(String id);

    /**
     * @param id The Font Id
     * @return The Font; null, if not present
     */
    Font getFont(String id);

    /**
     * When a Component is created, it will automatically be added to this lookup; and when it is
     * deleted, it will be automatically removed
     *
     * @param uuid The UUID of the Component to retrieve
     * @return The corresponding Component; null, if not present
     */
    Component getComponent(UUID uuid);
}
