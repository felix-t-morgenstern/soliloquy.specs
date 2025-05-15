package soliloquy.specs.graphics.rendering.timing;

import soliloquy.specs.common.shared.PausableAtTime;
import soliloquy.specs.gamestate.entities.Setting;

/**
 * <b>FrameRateReporter</b>
 * <p>
 * This class receives reports from the {@link FrameTimer} over every polling period (i.e. every
 * second), containing both the target and observed frames per second. The intent of this class is
 * to be enabled for either debugging purposes mid-execution, or for performance monitoring data
 * (perhaps with results aggregated over larger timeframes).
 * <p>
 * "Period" here refers to "seconds", whereas "aggregate" here refers to some aggregate of periods,
 * e.g. 5s. Intended use is for FrameRateReporter to receive aggregate length in terms of periods
 * from its constructor, possibly through {@link Setting}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FrameRateReporter extends PausableAtTime {
    /**
     * NB: Periods when frame execution was paused for the entire duration should still report 0
     * fps to the FrameReporter; the FrameReporter will handle that logic. Similarly, if targetFps
     * is null for some but not all periods, the {@link FrameRateReporterAggregateOutput} will
     * receive an average of the non-null targetFps values; and if they are all null, it will
     * instead receive null.
     *
     * @param datetime  The datetime for the given polling interval
     * @param targetFps The target frames per second (may be null if no target is set, c.f.
     *                  {@link FrameTimer#setTargetFps})
     * @param actualFps The frames per second which were actually executed
     * @throws IllegalArgumentException If and only if targetFps or actualFps are negative
     */
    void reportFrameRate(long datetime, Float targetFps, float actualFps)
            throws IllegalArgumentException;

    /**
     * @return The current frames per second; if frame execution for the most recent period was
     *         paused for the whole duration of that period, this method returns null
     */
    Float currentActualFps();

    /**
     * <i>NB: Aggregate outputs default to being active</i>
     *
     * @param id The id of the {@link FrameRateReporterAggregateOutput} to activate
     * @throws IllegalArgumentException If id is null or empty, or does not correspond to a
     *                                  FrameRateReporterAggregateOutput
     */
    void activateAggregateOutput(String id) throws IllegalArgumentException;

    /**
     * <i>NB: Aggregate outputs default to being active</i>
     *
     * @param id The id of the {@link FrameRateReporterAggregateOutput} to deactivate
     * @throws IllegalArgumentException If id is null or empty, or does not correspond to a
     *                                  FrameRateReporterAggregateOutput
     */
    void deactivateAggregateOutput(String id) throws IllegalArgumentException;

    /**
     * @param timestamp The timestamp at which the pause of frame execution began (c.f.
     *                  {@link GlobalClock#globalTimestamp})
     * @throws IllegalArgumentException If and only if timestamp is not within the current
     *                                  aggregation period
     */
    void reportPause(long timestamp) throws IllegalArgumentException;

    /**
     * @param timestamp The timestamp at which the pause of frame execution ended (c.f.
     *                  {@link GlobalClock#globalTimestamp})
     * @throws IllegalArgumentException If and only if timestamp is not within the current
     *                                  aggregation period
     */
    void reportUnpause(long timestamp) throws IllegalArgumentException;
}
