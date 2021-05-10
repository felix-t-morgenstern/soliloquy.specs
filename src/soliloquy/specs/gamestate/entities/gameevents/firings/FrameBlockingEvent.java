package soliloquy.specs.gamestate.entities.gameevents.firings;

import soliloquy.specs.common.shared.SoliloquyClass;

// TODO: Draft class summary
public interface FrameBlockingEvent extends SoliloquyClass {
    void fire(long timestamp);
}
