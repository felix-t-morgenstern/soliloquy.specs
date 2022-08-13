package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>OutputController</b>
 * <p>
 * This class is used to throttle the amount of work being put on computer resources, to prevent
 * congestion issues with paging or thread pool management.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface OutputController extends SoliloquyClass {
    /**
     * Resets any internal parameters set within the controller, which the controller uses to help
     * determine the next output
     */
    void reset();

    /**
     * Determines the next output (i.e. addition to the actual level observed previously) for the
     * next period, based on the actual output level seen in the current period, and the target
     * output level desired
     *
     * @param actual The actual output level observed in the current period
     * @param target The target output level for the next period
     * @return The adjustment to the output for the next period, to attempt to get to the target
     */
    double getOutput(double actual, double target);
}
