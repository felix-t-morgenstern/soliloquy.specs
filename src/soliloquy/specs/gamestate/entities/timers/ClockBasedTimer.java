package soliloquy.specs.gamestate.entities.timers;

import soliloquy.specs.common.shared.PausableAtTime;

// TODO: Draft class summary
public interface ClockBasedTimer extends PausableAtTime {
    void fire(long timestamp);
}
