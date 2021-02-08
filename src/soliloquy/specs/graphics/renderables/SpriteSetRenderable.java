package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.assets.SpriteSet;

/**
 * <b>SpriteSetRenderable</b>
 * <p>
 * A SpriteSet which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface SpriteSetRenderable extends RenderableWithArea {
    /**
     * @return The SpriteSet to be rendered
     */
    SpriteSet spriteSet();

    /**
     * @return The type to render for the SpriteSet (c.f.
     * {@link SpriteSet#getImageAndBoundariesForTypeAndDirection})
     */
    String type();

    /**
     * @return The direction to render for the SpriteSet (c.f.
     * {@link SpriteSet#getImageAndBoundariesForTypeAndDirection})
     */
    String direction();
}
