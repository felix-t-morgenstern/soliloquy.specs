package soliloquy.specs.graphics.assets;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>AssetSnippet</b>
 * <p>
 * This class defines the properties shared across all asset snippets, e.g. Sprites, single
 * Animation frames, or single ImageAssetSet snippets.
 * <p>
 * <i>Top and left boundaries are considered inclusive, whereas bottom and right are not.</i> So,
 * for example, if you have a 100x100 image, an AssetSnippet with boundaries of (0,0) and (100,100)
 * would encompass the whole image; no more, and no less.
 * <p>
 * It is intended for this interface to be implemented anonymously at runtime.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface AssetSnippet extends SoliloquyClass {
    /**
     * @return The Image from which to draw this snippet
     */
    Image image();

    /**
     * @return The left boundary of the snippet
     */
    int leftX();

    /**
     * @return The top boundary of the snippet
     */
    int topY();

    /**
     * @return The right boundary of the snippet
     */
    int rightX();

    /**
     * @return The bottom boundary of the snippet
     */
    int bottomY();
}
