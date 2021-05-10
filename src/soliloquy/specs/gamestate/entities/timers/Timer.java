package soliloquy.specs.gamestate.entities.timers;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.gamestate.entities.Deletable;

public interface Timer extends Deletable {
    /**
     * <i>NB: For {@link ClockBasedTimer}s, it is assumed that the specified Action will accept a
     * timestamp</i>
     * @return The Id of the type of {@link soliloquy.specs.common.entities.Action} which runs when
     * this Timer is fired
     */
    Action action();
}
