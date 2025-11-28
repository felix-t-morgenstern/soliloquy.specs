package soliloquy.specs.io.graphics.renderables.providers.factories;

import soliloquy.specs.common.entities.Consumer;
import soliloquy.specs.io.graphics.renderables.providers.FunctionalProvider;

import java.util.Map;
import java.util.UUID;

/**
 * <b>FunctionalProviderFactory</b>
 * <p>
 * A factory which creates
 * {@link soliloquy.specs.io.graphics.renderables.providers.FunctionalProvider}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FunctionalProviderFactory {
    /**
     * @param uuid              The UUID of this Provider
     * @param provideFunctionId The Id of the {@link soliloquy.specs.common.entities.Function} which
     *                          provides the value in question
     * @param pauseConsumerId   The Id of an {@link Consumer} which accepts a
     *                          {@link FunctionalProvider.Inputs} when
     *                          {@link soliloquy.specs.common.shared.PausableAtTime#reportPause} is
     *                          called
     * @param unpauseConsumerId Same as above, but for when
     *                          {@link soliloquy.specs.common.shared.PausableAtTime#reportPause} is
     *                          called
     * @param pauseTimestamp    The timestamp at which this Provider has been paused, may be null
     * @param data              The data for this provider, fed into the provide, pause, and action
     *                          Function and Actions as part of a {@link FunctionalProvider.Inputs}
     * @param <T>               The type provided
     * @return The newly-created FunctionalProvider
     * @throws IllegalArgumentException If and only if provideFunctionId or data are null; or if
     *                                  provideFunctionId, pauseConsumerId, or unpauseConsumerId are
     *                                  empty or do not correspond to valid entities
     */
    <T> FunctionalProvider<T> make(UUID uuid,
                                   String provideFunctionId,
                                   String pauseConsumerId,
                                   String unpauseConsumerId,
                                   Long pauseTimestamp,
                                   Map<String, Object> data) throws IllegalArgumentException;
}
