package soliloquy.specs.io.graphics.renderables;

import soliloquy.specs.io.graphics.assets.GlobalLoopingAnimation;
import soliloquy.specs.ruleset.entities.GroundType;

/**
 * <b>GlobalLoopingAnimationRenderable</b>
 * <p>
 * An Animation which can be rendered in the window. This Renderable will continue looping through
 * the same Animation, and its intended use case is to be shared among many Renderables using the
 * same underlying {@link soliloquy.specs.io.graphics.assets.Animation}. E.g., you have an animation
 * of waves rippling across the shoreline, and you want to make sure that every
 * {@link soliloquy.specs.gamestate.entities.Tile} which uses that animation for its
 * {@link GroundType#imageAsset()} is synchronized.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GlobalLoopingAnimationRenderable extends ImageAssetRenderable {
    /**
     * @return The GlobalLoopingAnimation supporting this Renderable.
     */
    GlobalLoopingAnimation getGlobalLoopingAnimation();

    /**
     * @param globalLoopingAnimation The GlobalLoopingAnimation to support this Renderable
     * @throws IllegalArgumentException If and only if globalLoopingAnimation is null; or if it does
     *                                  not support mouse events, while this Renderable does support
     *                                  mouse events
     */
    void setGlobalLoopingAnimation(GlobalLoopingAnimation globalLoopingAnimation)
            throws IllegalArgumentException;
}
