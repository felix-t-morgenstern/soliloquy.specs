package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.assets.Animation;
import soliloquy.specs.graphics.assets.GlobalLoopingAnimation;
import soliloquy.specs.graphics.bootstrap.assetfactories.definitions.GlobalLoopingAnimationDefinition;

/**
 * <b>GlobalLoopingAnimationFactory</b>
 * <p>
 * A factory which creates {@link GlobalLoopingAnimation}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface GlobalLoopingAnimationFactory extends SoliloquyClass {
    /**
     * @param definition The definition of the GlobalLoopingAnimation to be created
     * @return The newly-created GlobalLoopingAnimation
     * @throws IllegalArgumentException If and only if definition is null; or its uuid is null, its
     * animation is null, or its periodModuloOffset is negative or greater than or equal to the ms
     * duration of animation
     */
    GlobalLoopingAnimation make(GlobalLoopingAnimationDefinition definition)
            throws IllegalArgumentException;
}
