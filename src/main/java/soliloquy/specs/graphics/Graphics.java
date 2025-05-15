package soliloquy.specs.graphics;

import soliloquy.specs.graphics.assets.*;
import soliloquy.specs.graphics.bootstrap.GraphicsCoreLoop;
import soliloquy.specs.graphics.bootstrap.GraphicsTeardown;
import soliloquy.specs.graphics.rendering.WindowResolutionManager;

/**
 * <b>Graphics</b>
 * <p>
 * This class encompasses all of the functionality of the graphics engine which will be needed at
 * runtime.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Graphics {
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
     * @param id The id of the Sprite requested
     * @return The desired Sprite
     * @throws IllegalArgumentException If and only if id is null, empty, or does not correspond to
     *                                  a valid Sprite
     */
    Sprite getSprite(String id) throws IllegalArgumentException;

    /**
     * @param id The id of the ImageAssetSet requested
     * @return The desired ImageAssetSet
     * @throws IllegalArgumentException If and only if id is null, empty, or does not correspond to
     *                                  a valid Sprite
     */
    ImageAssetSet getImageAssetSet(String id);

    /**
     * @param id The id of the Animation requested
     * @return The desired Animation
     * @throws IllegalArgumentException If and only if id is null, empty, or does not correspond to
     *                                  a valid Animation
     */
    Animation getAnimation(String id) throws IllegalArgumentException;

    /**
     * @param id The id of the GlobalLoopingAnimation requested
     * @return The desired GlobalLoopingAnimation
     * @throws IllegalArgumentException If and only if id is null, empty, or does not correspond to
     *                                  a valid GlobalLoopingAnimation
     */
    GlobalLoopingAnimation getGlobalLoopingAnimation(String id) throws IllegalArgumentException;

    /**
     * @param id The Id of the Font requested
     * @return The desired Font
     * @throws IllegalArgumentException If and only if id is null, empty, or does not correspond to
     *                                  a valid Font
     */
    Font getFont(String id) throws IllegalArgumentException;

    /**
     * @return The {@link WindowResolutionManager}, to manage the size of the window (and, if
     *         fullscreen, the screen itself)
     */
    WindowResolutionManager windowResolutionManager();
}
