package soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.io.graphics.assets.AssetSnippet;
import soliloquy.specs.io.graphics.assets.Image;
import soliloquy.specs.io.graphics.assets.Sprite;

/**
 * <b>SpriteDefinition</b>
 * <p>
 * This class defines a {@link Sprite}.
 * <p>
 * It is intended for this interface to be implemented anonymously at runtime.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class SpriteDefinition extends AssetDefinition<Sprite> implements AssetSnippet {
    private final Image IMAGE;
    private final int LEFT_X;
    private final int TOP_Y;
    private final int RIGHT_X;
    private final int BOTTOM_Y;

    public SpriteDefinition(String id, Image image, int leftX, int topY, int rightX, int bottomY) {
        super(id);
        IMAGE = image;
        LEFT_X = leftX;
        TOP_Y = topY;
        RIGHT_X = rightX;
        BOTTOM_Y = bottomY;
    }

    /**
     * @return The Image from which to draw this snippet
     */
    public Image image() {
        return IMAGE;
    }

    /**
     * @return The left boundary of the snippet
     */
    public int leftX() {
        return LEFT_X;
    }

    /**
     * @return The top boundary of the snippet
     */
    public int topY() {
        return TOP_Y;
    }

    /**
     * @return The right boundary of the snippet
     */
    public int rightX() {
        return RIGHT_X;
    }

    /**
     * @return The bottom boundary of the snippet
     */
    public int bottomY() {
        return BOTTOM_Y;
    }
}
