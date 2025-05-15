package soliloquy.specs.graphics.bootstrap;

/**
 * <b>GraphicsPreloader</b>
 * <p>
 * This class loads all graphics engine components (e.g.
 * {@link soliloquy.specs.graphics.assets.Image}s and
 * {@link soliloquy.specs.graphics.assets.Asset}s) used by the game into memory at startup, to
 * reduce latency when loading a savefile or entering a new area. (This class can technically be
 * omitted, but this runs the risk of introducing intrusive load times when first needing a large
 * number of previously unused assets.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GraphicsPreloader {
    /**
     * This method spins up worker threads to load each
     * {@link soliloquy.specs.graphics.assets.Image} and
     * {@link soliloquy.specs.graphics.assets.Asset}; and if needed, to calculate the Images' alpha
     * threshold map for mouse event capturing. (Determining which Images require alpha threshold
     * maps depends on the implementation of the Graphics engine.)
     */
    void load();
}
