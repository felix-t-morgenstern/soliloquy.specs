package soliloquy.specs.graphics.renderables.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.assets.Animation;
import soliloquy.specs.graphics.renderables.RenderableAnimation;

/**
 * <b>GlobalLoopingRenderableAnimationFactory</b>
 * <p>
 * Creates {@link RenderableAnimation}s, to be used by
 * {@link soliloquy.specs.graphics.renderables.GlobalLoopingAnimationRenderable}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface GlobalLoopingRenderableAnimationFactory extends SoliloquyClass {
    RenderableAnimation make(Animation animation, long startTimestamp)
            throws IllegalArgumentException;
}
