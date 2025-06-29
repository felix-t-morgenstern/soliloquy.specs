package soliloquy.specs.io.graphics.renderables.providers;

/**
 * <b>ResettableProvider</b>
 * <p>
 * This class is a looping {@link ProviderAtTime} (e.g. {@link LoopingProvider} or
 * {@link AnimatedMouseCursorProvider}) which can be reset to a starting point on demand (i.e.
 * whose period modulo offset can be set so that the loop starts at the provided timestamp).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ResettableProvider<T> extends ProviderAtTime<T> {
    /**
     * @param timestamp The time at which to reset this Provider
     * @throws IllegalArgumentException If and only if timestamp is before most recent timestamp
     *                                  provided to class
     */
    void reset(long timestamp) throws IllegalArgumentException;
}
