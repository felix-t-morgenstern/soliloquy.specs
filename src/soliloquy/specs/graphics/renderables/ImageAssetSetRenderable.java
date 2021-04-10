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
public interface ImageAssetSetRenderable extends RenderableWithArea {
    /**
     * @return The ImageAssetSet to be rendered
     */
    ImageAssetSet imageAssetSet();

    /**
     * @return The type to render for the ImageAssetSet (c.f.
     * {@link ImageAssetSet#getImageAssetForTypeAndDirection})
     */
    String type();

    /**
     * @return The direction to render for the ImageAssetSet (c.f.
     * {@link ImageAssetSet#getImageAssetForTypeAndDirection})
     */
    String direction();
}
