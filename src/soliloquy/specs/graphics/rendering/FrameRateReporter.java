package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;

import java.util.Date;

/**
 * <b>FrameRateReporter</b>
 * <p>
 * This class receives reports from the {@link FrameTimer} over every polling period (i.e. every
 * second), containing both the target and observed frames per second. The intent of this class is
 * to be enabled for either debugging purposes mid-execution, or for performance monitoring data
 * (perhaps with results aggregated over larger timeframes).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface FrameRateReporter extends SoliloquyClass {
    /**
     * @param datetime The datetime for the given polling interval
     * @param targetFps The target frames per second (may be null if no target is set, c.f. 
     *                  {@link FrameTimer#setTargetFps})
     * @param actualFps The frames per second which were actually executed
     * @throws IllegalArgumentException If and only if datetime is null
     */
    void reportFrameRate(Date datetime, Float targetFps, float actualFps)
            throws IllegalArgumentException;
}
