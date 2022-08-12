package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.assets.ImageAssetSet;

/**
 * <b>ImageAssetSetRenderable</b>
 * <p>
 * A ImageAssetSet which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ImageAssetSetRenderable extends ImageAssetRenderable {
    /**
     * @return The ImageAssetSet to be rendered
     */
    ImageAssetSet getImageAssetSet();

    /**
     * C.f. {@link #getImageAssetSet()} for more information
     * @param imageAssetSet The ImageAssetSet to set for this Renderable
     * @throws IllegalArgumentException If and only if imageAssetSet is null, or if imageAssetSet
     * does not support mouse events, while this Renderable does support mouse events
     */
    void setImageAssetSet(ImageAssetSet imageAssetSet) throws IllegalArgumentException;

    /**
     * @return The type to render for the ImageAssetSet (c.f.
     * {@link ImageAssetSet#getImageAssetForTypeAndDirection})
     */
    String getType();

    /**
     * C.f. {@link #getType()} for more information
     * @param type The type to set for this Renderable
     */
    void setType(String type);

    /**
     * @return The direction to render for the ImageAssetSet (c.f.
     * {@link ImageAssetSet#getImageAssetForTypeAndDirection})
     */
    String getDirection();

    /**
     * C.f. {@link #getDirection()} for more information
     * @param direction The direction to set for this Renderable
     */
    void setDirection(String direction);
}
