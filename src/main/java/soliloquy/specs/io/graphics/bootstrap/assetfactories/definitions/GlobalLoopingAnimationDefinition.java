package soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasPeriodModuloOffset;
import soliloquy.specs.io.graphics.assets.Animation;

/**
 * <b>GlobalLoopingAnimationDefinition</b>
 * <p>
 * This class defines a {@link soliloquy.specs.io.graphics.assets.GlobalLoopingAnimation}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class GlobalLoopingAnimationDefinition {
    public final String ID;
    public final Animation ANIMATION;
    public final int PERIOD_MODULO_OFFSET;
    public final Long PAUSE_TIMESTAMP;

    public GlobalLoopingAnimationDefinition(String id,
                                            Animation animation,
                                            int periodModuloOffset,
                                            Long pauseTimestamp) {
        ID = id;
        ANIMATION = animation;
        PERIOD_MODULO_OFFSET = periodModuloOffset;
        PAUSE_TIMESTAMP = pauseTimestamp;
    }
}
