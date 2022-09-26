package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.bootstrap.assetfactories.definitions.AnimatedMouseCursorProviderDefinition;
import soliloquy.specs.graphics.renderables.providers.AnimatedMouseCursorProvider;

/**
 * <b>AnimatedMouseCursorProviderFactory</b>
 * <p>
 * This class creates {@link AnimatedMouseCursorProvider}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface AnimatedMouseCursorProviderFactory extends SoliloquyClass {
    /**
     * @param definition The definition of the AnimatedMouseCursorProvider to be created
     * @return The newly-created AnimatedMouseCursorProvider
     * @throws IllegalArgumentException If and only if definition is null; or its id is null or
     *                                  empty; valuesAtTimes is null, is empty, has any null or
     *                                  negative keys, has any null values,
     *                                  or has no key of 0ms; or if its msDuration is 0 or less, or
     *                                  less than the maximum key
     *                                  provided in its valuesAtTimes; or if its periodModuloOffset
     *                                  is 0 or less, or greater than or
     *                                  equal to its msDuration; or if its pausedTimestamp is
     *                                  defined, and its mostRecentTimestamp
     *                                  is either null or less than its pausedTimestamp
     */
    AnimatedMouseCursorProvider make(AnimatedMouseCursorProviderDefinition definition)
            throws IllegalArgumentException;
}
