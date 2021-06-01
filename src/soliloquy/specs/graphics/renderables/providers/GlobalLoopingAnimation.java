package soliloquy.specs.graphics.renderables.providers;

import soliloquy.specs.graphics.assets.AnimationFrameSnippet;

public interface GlobalLoopingAnimation
        extends ProviderAtTime<AnimationFrameSnippet>, NonStaticProvider {
    /**
     * @return True, if and only if the underlying
     * {@link soliloquy.specs.graphics.assets.Animation} supports mouse events
     */
    boolean supportsMouseEvents();

    // TODO: Look for instances of this method in other classes, refactor into shared interface
    /**
     * <i>NB: This method exists to support period starting timestamps which are not exact
     * multiples of the periodDuration. E.g., if periodDuration is 1000ms, then the periods would
     * start on the timestamps 1000ms, 2000ms, 3000ms, etc. However, if this method returns 250,
     * then the periods would start on the timestamps 1250ms, 2250ms, 3250ms, etc.</i>
     * @return The offset, in ms, of the period start time.
     */
    int periodModuloOffset();
}
