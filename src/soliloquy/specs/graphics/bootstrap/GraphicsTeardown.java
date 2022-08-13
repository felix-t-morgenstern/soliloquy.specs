package soliloquy.specs.graphics.bootstrap;

/**
 * <b>GraphicsTeardown</b>
 * <p>
 * This class takes down the Graphics infrastructure and releases all held memory.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GraphicsTeardown {
    /**
     * Takes down the Graphics infrastructure and releases all held memory
     */
    void tearDown();
}
