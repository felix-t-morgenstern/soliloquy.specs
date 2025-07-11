package soliloquy.specs.io.graphics.renderables.providers.factories;

import soliloquy.specs.io.graphics.assets.GlobalLoopingAnimation;
import soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions.GlobalLoopingAnimationDefinition;

/**
 * <b>GlobalLoopingAnimationFactory</b>
 * <p>
 * A factory which creates {@link GlobalLoopingAnimation}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GlobalLoopingAnimationFactory {
    /**
     * @param definition The definition of the GlobalLoopingAnimation to be created
     * @return The newly-created GlobalLoopingAnimation
     * @throws IllegalArgumentException If and only if definition is null; or its uuid is null, its
     *                                  animation is null, or its periodModuloOffset is negative or
     *                                  greater than or equal to the ms
     *                                  duration of animation
     */
    GlobalLoopingAnimation make(GlobalLoopingAnimationDefinition definition)
            throws IllegalArgumentException;
}
