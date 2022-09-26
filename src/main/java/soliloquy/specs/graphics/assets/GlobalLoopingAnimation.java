package soliloquy.specs.graphics.assets;

import soliloquy.specs.graphics.renderables.providers.LoopingProvider;

import java.util.UUID;

/**
 * <b>GlobalLoopingAnimationDefinition</b>
 * <p>
 * This class represents an {@link Animation}, which loops constantly, to be reused many times in a
 * game, e.g. to make all water tiles' waves all ebb and flow at the same time, or to have all
 * soldiers pace in unison.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GlobalLoopingAnimation
        extends LoopingProvider<AnimationFrameSnippet>, ImageAsset {
    /**
     * @return True, if and only if the underlying
     *         {@link soliloquy.specs.graphics.assets.Animation} supports mouse events
     */
    boolean supportsMouseEvents();

    /**
     * @return The id of the Animation over which to loop
     */
    String animationId();

    /**
     * This method is not supported for GlobalLoopingAnimation, since it will only be created when
     * the game is loading, it should never be deleted, and it can be adequately saved by only
     * exposing {@link #id()}.
     *
     * @return Nothing (c.f. throws)
     * @throws UnsupportedOperationException Every time this class is called
     */
    UUID uuid() throws UnsupportedOperationException;
}
