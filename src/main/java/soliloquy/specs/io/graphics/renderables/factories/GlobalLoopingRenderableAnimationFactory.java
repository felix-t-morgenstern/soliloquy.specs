package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.io.graphics.assets.Animation;
import soliloquy.specs.io.graphics.assets.AnimationFrameSnippet;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>GlobalLoopingRenderableAnimationFactory</b>
 * <p>
 * Creates {@link ProviderAtTime}s, which provide {@link AnimationFrameSnippet}s, to be used by
 * {@link soliloquy.specs.io.graphics.renderables.GlobalLoopingAnimationRenderable}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GlobalLoopingRenderableAnimationFactory {
    /**
     * @param animation      The Animation for which to make a globally-accessible and consistent
     *                       ProviderAtTime, providing the same {@link AnimationFrameSnippet} for
     *                       all
     *                       recipients of that provider at a given timestamp
     * @param startTimestamp The starting timestamp of this globally looping renderable animation
     * @return The ProviderAtTime, which provides the AnimationFrameSnippets as specified
     * @throws IllegalArgumentException If and only if animation is null
     */
    ProviderAtTime<AnimationFrameSnippet> make(Animation animation, long startTimestamp)
            throws IllegalArgumentException;
}
