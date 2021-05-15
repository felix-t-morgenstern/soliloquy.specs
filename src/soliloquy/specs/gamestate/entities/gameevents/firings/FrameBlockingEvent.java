package soliloquy.specs.gamestate.entities.gameevents.firings;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>FrameBlockingEvent</b>
 * <p>
 * This class represents an event which will fire the next time
 * {@link soliloquy.specs.graphics.rendering.FrameExecutor#execute} is called. This event is
 * expected to be very brief, on the order of a few ms. See the description of
 * FrameExecutor.execute for more details.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FrameBlockingEvent extends SoliloquyClass {
    void fire(long timestamp);
}
