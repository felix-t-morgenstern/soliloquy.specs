package soliloquy.specs.io.graphics;

import soliloquy.specs.io.graphics.assets.*;
import soliloquy.specs.io.graphics.rendering.FrameExecutor;
import soliloquy.specs.io.graphics.rendering.timing.FrameRateReporter;
import soliloquy.specs.io.graphics.rendering.timing.GlobalClock;
import soliloquy.specs.io.input.mouse.MouseCursor;

public interface Graphics {
    Sprite getSprite(String id) throws IllegalArgumentException;

    Animation getAnimation(String id) throws IllegalArgumentException;

    GlobalLoopingAnimation getGlobalLoopingAnimation(String id) throws IllegalArgumentException;

    ImageAssetSet getImageAssetSet(String id) throws IllegalArgumentException;

    Font getFont(String id) throws IllegalArgumentException;
}
