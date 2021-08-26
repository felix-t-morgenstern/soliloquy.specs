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

    /**
     * @param spriteId The id of the Sprite requested
     * @return The desired Sprite
     * @throws IllegalArgumentException If and only if spriteId is null, empty, or does not
     * correspond to a valid Sprite
     */
    Sprite getSprite(String spriteId) throws IllegalArgumentException;

    /**
     * @param imageAssetSetId The id of the ImageAssetSet requested
     * @return The desired ImageAssetSet
     * @throws IllegalArgumentException If and only if imageAssetSetId is null, empty, or does not
     * correspond to a valid Sprite
     */
    ImageAssetSet getImageAssetSet(String imageAssetSetId);

    /**
     * @param animationId The id of the Animation requested
     * @return The desired Animation
     * @throws IllegalArgumentException If and only if animationId is null, empty, or does not
     * correspond to a valid Animation
     */
    Animation getAnimation(String animationId) throws IllegalArgumentException;

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
