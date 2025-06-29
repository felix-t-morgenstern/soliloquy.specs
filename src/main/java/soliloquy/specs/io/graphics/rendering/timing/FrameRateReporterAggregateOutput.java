package soliloquy.specs.io.graphics.rendering.timing;

import soliloquy.specs.common.shared.HasId;

import java.util.Date;

public interface FrameRateReporterAggregateOutput extends HasId {
    /**
     * @param datetime  The start of the aggregate period
     * @param targetFps The weighted target FPS for the aggregate period; if null, that implies
     *                  that frame execution was paused for the entire aggregate period
     * @param actualFps The weighted actual FPS for the aggregate period; if null, that implies
     *                  that frame execution was paused for the entire aggregate period
     */
    void outputAggregateFrameRateData(Date datetime, Float targetFps, Float actualFps);
}
