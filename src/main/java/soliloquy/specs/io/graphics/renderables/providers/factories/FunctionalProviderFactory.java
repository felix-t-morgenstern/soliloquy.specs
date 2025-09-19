package soliloquy.specs.io.graphics.renderables.providers.factories;

import soliloquy.specs.io.graphics.renderables.providers.FunctionalProvider;

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
     * @param provideFunctionId The Id of the {@link soliloquy.specs.common.entities.Function} which
     *                          provides the value in question
     * @param pauseActionId     The Id of an {@link soliloquy.specs.common.entities.Action} which
     *                          accepts a {@link FunctionalProvider.EventInfo} when
     *                          {@link soliloquy.specs.common.shared.PausableAtTime#reportPause} is
     *                          called
     * @param unpauseActionId   Same as above, but for when
     *                          {@link soliloquy.specs.common.shared.PausableAtTime#reportPause} is
     *                          called
     * @param <T>               The type provided
     * @return The newly-created FunctionalProvider
     * @throws IllegalArgumentException If and only if provideFunctionId is null; or if
     *                                  provideFunctionId, pauseActionId, or unpauseActionId are
     *                                  empty or do not correspond to valid entities
     */
    <T> FunctionalProvider<T> make(String provideFunctionId, String pauseActionId,
                                   String unpauseActionId) throws IllegalArgumentException;
}
