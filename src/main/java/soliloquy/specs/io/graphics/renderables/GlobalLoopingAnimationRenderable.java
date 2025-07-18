package soliloquy.specs.io.graphics.renderables;

import soliloquy.specs.io.graphics.assets.GlobalLoopingAnimation;

/**
 * <b>GlobalLoopingAnimationRenderable</b>
 * <p>
 * An Animation which can be rendered in the window. <i>This Renderable will continue looping
 * through the same Animation, and its intended use case is to be shared among many Renderables
 * using the same underlying {@link soliloquy.specs.io.graphics.assets.Animation}, e.g., all torches
 * or lampposts in a {@link soliloquy.specs.gamestate.entities.GameZone}.</i>
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
     * @throws IllegalArgumentException If and only if globalLoopingAnimation is null; or if it
     *                                  does not support mouse events, while this Renderable does
     *                                  support mouse events
     */
    void setGlobalLoopingAnimation(GlobalLoopingAnimation globalLoopingAnimation)
            throws IllegalArgumentException;
}
