package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.EntityUuid;
import soliloquy.specs.graphics.assets.Animation;
import soliloquy.specs.graphics.renderables.providers.GlobalLoopingAnimation;

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
     * NB: This class only exposes uuid since it's a requirement of
     * {@link soliloquy.specs.graphics.renderables.providers.ProviderAtTime}
     * @param id The (human-readable) id of this GlobalLoopingAnimation
     * @param animation The Animation to use for this GlobalLoopingAnimation
     * @param periodModuloOffset The milliseconds by which the period of this Animation is offset
     *                           (c.f. {@link soliloquy.specs.common.shared.HasPeriodModuloOffset})
     * @param pauseTimestamp The timestamp at which this GlobalLoopingAnimation has been paused; if
     *                       unpaused, this value should be null
     * @return The newly-created GlobalLoopingAnimation
     * @throws IllegalArgumentException If and only if uuid is null, animation is null, or
     * periodModuloOffset is negative or greater than or equal to the ms duration of animation
     */
    GlobalLoopingAnimation make(String id, Animation animation, int periodModuloOffset,
                                Long pauseTimestamp)
            throws IllegalArgumentException;
}