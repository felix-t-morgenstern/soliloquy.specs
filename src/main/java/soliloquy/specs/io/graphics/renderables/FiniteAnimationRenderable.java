package soliloquy.specs.io.graphics.renderables;

import soliloquy.specs.io.graphics.assets.AnimationFrameSnippet;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>FiniteAnimationRenderable</b>
 * <p>
 * An Animation which can be rendered in the window. <i>This Renderable will determine when its
 * Animation has finished by determining when its next requested frame is beyond its underlying
 * Animation's {@link soliloquy.specs.io.graphics.assets.Animation#msDuration}, and when it is, it
 * will inform its containing {@link soliloquy.specs.ui.Component} to remove it.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FiniteAnimationRenderable
        extends ProviderAtTime<AnimationFrameSnippet>, ImageAssetRenderable {
    /**
     * (NB: This method will return higher values each time this Renderable is paused and later
     * unpaused; the purpose of this method is to ensure that there is no call to
     * {@link #provide} before the start of this finite animation.)
     *
     * @return The timestamp at which the finite animation began
     */
    long startTimestamp();

    /**
     * (NB: This method will return higher values each time this Renderable is paused and later
     * unpaused; the purpose of this method is to ensure that there is no call to
     * {@link #provide} after the end of this finite animation.)
     *
     * @return The timestamp at which the finite animation ends
     */
    long endTimestamp();

    /**
     * @return The Id of the Animation to render
     */
    String animationId();
}
