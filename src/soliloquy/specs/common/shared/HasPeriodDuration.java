package soliloquy.specs.common.shared;

public interface HasPeriodDuration extends SoliloquyClass {
    /**
     * @return The duration, in ms, of the period over which this provider loops
     */
    int periodDuration();
}
