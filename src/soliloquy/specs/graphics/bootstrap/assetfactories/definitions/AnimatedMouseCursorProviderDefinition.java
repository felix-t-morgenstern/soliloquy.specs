package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.common.shared.HasId;

import java.util.Map;

/**
 * <b>GlobalLoopingAnimationDefinition</b>
 * <p>
 * This class defines an
 * {@link soliloquy.specs.graphics.renderables.providers.AnimatedMouseCursorProvider}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public class AnimatedMouseCursorProviderDefinition implements HasId {
    private final String ID;
    private final Map<Integer, Long> CURSORS_AT_MS;
    private final int MS_DURATION;
    private final int PERIOD_MODULO_OFFSET;
    private final Long PAUSED_TIMESTAMP;
    private final Long MOST_RECENT_TIMESTAMP;

    public AnimatedMouseCursorProviderDefinition(String id,
                                                 Map<Integer, Long> cursorsAtMs,
                                                 int msDuration,
                                                 int periodModuloOffset,
                                                 Long pausedTimestamp,
                                                 Long mostRecentTimestamp) {
        ID = id;
        CURSORS_AT_MS = cursorsAtMs;
        MS_DURATION = msDuration;
        PERIOD_MODULO_OFFSET = periodModuloOffset;
        PAUSED_TIMESTAMP = pausedTimestamp;
        MOST_RECENT_TIMESTAMP = mostRecentTimestamp;
    }

    /**
     * @return cursorsAtMs The mouse cursor Ids (defined by OpenGL) corresponding to each
     * millisecond within the period, analogous to
     * {@link soliloquy.specs.graphics.assets.Animation}
     */
    public Map<Integer, Long> cursorsAtMs() {
        return CURSORS_AT_MS;
    }

    /**
     * @return The duration of the animation
     */
    public int msDuration() {
        return MS_DURATION;
    }

    /**
     * @return The number of ms to add onto the current timestamp to determine which mouse cursor
     * to provide
     */
    public int periodModuloOffset() {
        return PERIOD_MODULO_OFFSET;
    }

    /**
     * @return The time at which this Provider was paused; null if it has not been paused
     */
    public Long pausedTimestamp() {
        return PAUSED_TIMESTAMP;
    }

    /**
     * @return The most recent time at which the newly-created Provider is to have been paused
     */
    public Long mostRecentTimestamp() {
        return MOST_RECENT_TIMESTAMP;
    }

    @Override
    public String id() throws IllegalStateException {
        return ID;
    }

    @Override
    public String getInterfaceName() {
        return null;
    }
}
