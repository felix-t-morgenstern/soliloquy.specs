package soliloquy.specs.graphics.bootstrap;

import soliloquy.specs.common.shared.SoliloquyClass;

import java.util.List;
import java.util.function.Consumer;

/**
 * <b>GraphicsPreloader</b>
 * <p>
 * This class loads all graphics engine components (e.g.
 * {@link soliloquy.specs.graphics.assets.Image}s and
 * {@link soliloquy.specs.graphics.assets.AssetType}s) used by the game into memory at startup, to
 * reduce latency when loading a savefile or entering a new area. (This class can technically be
 * omitted, but this runs the risk of introducing intrusive load times when first needing a large
 * number of previously unused assets.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface GraphicsPreloader extends SoliloquyClass {
    /**
     * This method spins up worker threads to load each
     * {@link soliloquy.specs.graphics.assets.Image} and
     * {@link soliloquy.specs.graphics.assets.AssetType}; and if needed, to calculate the Images'
     * alpha threshold map for mouse event capturing. (Determining which Images require alpha
     * threshold maps depends which AssetTypes use snippets from which Images. Images only used for
     * GroundTypes, for instance, will not need alpha threshold maps; but Images used for
     * Characters will.)
     * @param callback The function to call once all Images have finished loading
     * @throws IllegalArgumentException If and only if callback is null
     */
    void load(Consumer<Void> callback) throws IllegalArgumentException;

    /**
     * @return The (estimated) percentage of graphics successfully loaded, e.g. to be used in a
     * loading bar
     */
    float percentageComplete();

    /**
     * @return A list of human-readable status message indicating the progress of graphics loading,
     * e.g. "Creatures: 100% loaded", "Fixtures: 40% loaded", etc.
     */
    List<String> statusMessage();
}
