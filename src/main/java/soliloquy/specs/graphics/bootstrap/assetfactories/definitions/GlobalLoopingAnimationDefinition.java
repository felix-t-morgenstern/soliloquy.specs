package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasPeriodModuloOffset;
import soliloquy.specs.graphics.assets.Animation;

/**
 * <b>GlobalLoopingAnimationDefinition</b>
 * <p>
 * This class defines a {@link soliloquy.specs.graphics.assets.GlobalLoopingAnimation}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class GlobalLoopingAnimationDefinition implements HasId, HasPeriodModuloOffset {
    private final String ID;
    private final Animation ANIMATION;
    private final int PERIOD_MODULO_OFFSET;
    private final Long PAUSE_TIMESTAMP;

    public GlobalLoopingAnimationDefinition(String id,
                                            Animation animation,
                                            int periodModuloOffset,
                                            Long pauseTimestamp) {
        ID = id;
        ANIMATION = animation;
        PERIOD_MODULO_OFFSET = periodModuloOffset;
        PAUSE_TIMESTAMP = pauseTimestamp;
    }

    @Override
    public String id() throws IllegalStateException {
        return ID;
    }

    /**
     * @return The Animation to loop over globally
     */
    public Animation animation() {
        return ANIMATION;
    }

    @Override
    public int periodModuloOffset() {
        return PERIOD_MODULO_OFFSET;
    }

    /**
     * @return The timestamp at which this GlobalLoopingAnimation is paused; if null, that implies
     *         it is unpaused.
     */
    public Long pauseTimestamp() {
        return PAUSE_TIMESTAMP;
    }
}
