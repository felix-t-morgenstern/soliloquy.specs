package soliloquy.specs.gamestate.entities.timers;

public interface RecurringClockBasedTimer {
    int firingTimePeriod();

    int firingTimeModulo();
}
