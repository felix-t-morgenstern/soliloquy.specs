package soliloquy.specs.graphics.renderables.providers;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>NonStaticProvider</b>
 * <p>
 * This class exists to report pausedTimestamp for finite or looping moving providers, to handle
 * their persistence. This is not a part of the {@link ProviderAtTime} base class, since
 * {@link StaticProvider} does not need to report this value to handle its persistence.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface NonStaticProvider extends SoliloquyClass {
    /**
     * @return If this class has been paused, this method reports the timestamp at which its pause
     * began; otherwise, this method returns null
     */
    Long pausedTimestamp();
}
