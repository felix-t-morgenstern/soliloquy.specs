package soliloquy.specs.graphics;

import soliloquy.specs.common.infrastructure.Registry;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.assets.Animation;
import soliloquy.specs.graphics.assets.ImageAssetSet;
import soliloquy.specs.graphics.assets.Sprite;
import soliloquy.specs.graphics.bootstrap.GraphicsCoreLoop;
import soliloquy.specs.graphics.bootstrap.GraphicsTeardown;
import soliloquy.specs.graphics.rendering.MouseCursorAsset;
import soliloquy.specs.graphics.rendering.WindowResolutionManager;

/**
 * <b>Graphics</b>
 * <p>
 * This class encompasses all of the functionality of the graphics engine which will be needed at
 * runtime.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Graphics extends SoliloquyClass {
	// TODO: Just wait until the module is worked out to figure out what even goes in here

    /**
     * @return The core Graphics loop, to be started immediately on app startup
     */
    GraphicsCoreLoop coreLoop();

    /**
     * @return The functionality needed when tearing down the graphics engine
     */
    GraphicsTeardown teardown();

    // TODO: Consider replacing Registry with a method that simply provides the Assets in question
    /**
     * @return A {@link Registry} of {@link Sprite}s
     */
    Registry<Sprite> spritesRegistry();

    /**
     * @return A {@link Registry} of {@link ImageAssetSet}s
     */
    Registry<ImageAssetSet> imageAssetSetsRegistry();

    /**
     * @return A {@link Registry} of {@link Animation}s
     */
    Registry<Animation> animationsRegistry();

    /**
     * @return The {@link WindowResolutionManager}, to manage the size of the window (and, if
     * fullscreen, the screen itself)
     */
    WindowResolutionManager windowResolutionManager();

    /**
     * @return An interface to mutate the current mouse cursor asset
     */
    MouseCursorAsset mouseCursorAsset();
}
