package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.providers.AnimatedMouseCursorProvider;

import java.util.Map;

/**
 * <b>AnimatedMouseCursorProviderFactory</b>
 * <p>
 * This class creates {@link AnimatedMouseCursorProvider}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface AnimatedMouseCursorProviderFactory extends SoliloquyClass {
    /**
     * @param id The id of the newly-created AnimatedMouseCursorProvider
     * @param cursorsAtMs The mouse cursor Ids (defined by OpenGL) corresponding to each
     *                    millisecond within the period, analogous to
     *                    {@link soliloquy.specs.graphics.assets.Animation}
     * @param msDuration The duration of the animation
     * @param periodModuloOffset The number of ms to add onto the current timestamp to determine
     *                           which mouse cursor to provide
     * @param pausedTimestamp The time at which this Provider was paused; null if it has not been
     *                        paused
     * @param mostRecentTimestamp The most recent time at which the newly-created Provider is to
     *                            have been paused
     * @return The newly-created AnimatedMouseCursorProvider
     * @throws IllegalArgumentException If and only if id is null or empty; valuesAtTimes is null,
     * is empty, has any null or negative keys, has any null values, or has no key of 0ms; or if
     * msDuration is 0 or less, or less than the maximum key provided in valuesAtTimes; or if
     * periodModuloOffset is 0 or less, or greater than or equal to msDuration; or if
     * pausedTimestamp is defined, and mostRecentTimestamp is either null or less than
     * pausedTimestamp
     */
    AnimatedMouseCursorProvider make(String id, Map<Long, Long> cursorsAtMs, int msDuration,
                                     int periodModuloOffset, Long pausedTimestamp,
                                     Long mostRecentTimestamp)
            throws IllegalArgumentException;
}
