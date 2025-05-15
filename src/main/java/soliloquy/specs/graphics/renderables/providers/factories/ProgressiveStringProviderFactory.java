package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.util.UUID;

public interface ProgressiveStringProviderFactory {
    /**
     * @param uuid                The id of the Provider
     * @param string              The string to be provided over time
     * @param startTimestamp      The time at which to start providing the string
     * @param timeToComplete      The time over which the string is provided
     * @param pausedTimestamp     The time at which the Provider was paused; if null, this implies
     *                            the Provider is unpaused
     * @param mostRecentTimestamp The most recent timestamp at which the Provider provided a value,
     *                            was paused, was unpaused, or was reset
     * @throws IllegalArgumentException If and only if uuid is null; string is null; timeToComplete
     *                                  is less than or equal to zero; or if pausedTimestamp is
     *                                  non-null, and mostRecentTimestamp is either null, or is
     *                                  before pausedTimestamp
     */
    ProviderAtTime<String> make(UUID uuid, String string, long startTimestamp,
                                long timeToComplete, Long pausedTimestamp, Long mostRecentTimestamp)
            throws IllegalArgumentException;
}
