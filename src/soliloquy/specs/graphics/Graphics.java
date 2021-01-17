package soliloquy.specs.graphics;

import soliloquy.specs.common.infrastructure.Registry;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.assets.Animation;
import soliloquy.specs.graphics.assets.Sprite;
import soliloquy.specs.graphics.assets.SpriteSet;
import soliloquy.specs.graphics.rendering.MouseCursorAsset;
import soliloquy.specs.graphics.rendering.WindowManager;

// TODO: Document this interface
public interface Graphics extends SoliloquyClass {
	// TODO: Just wait until the module is worked out to figure out what even goes in here

    /**
     * @return A {@link Registry} of {@link Sprite}s
     */
    Registry<Sprite> spritesRegistry();

    /**
     * @return A {@link Registry} of {@link SpriteSet}s
     */
    Registry<SpriteSet> spriteSetsRegistry();

    /**
     * @return A {@link Registry} of {@link Animation}s
     */
    Registry<Animation> animationsRegistry();

    /**
     * @return The {@link WindowManager}, to manage the size of the window (and, if fullscreen, the
     * screen)
     */
    WindowManager windowManager();

    /**
     * @return An interface to mutate the current mouse cursor asset
     */
    MouseCursorAsset mouseCursorAsset();
}
