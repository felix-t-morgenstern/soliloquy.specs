package soliloquy.specs.io.graphics;

import soliloquy.specs.io.graphics.assets.*;

public interface Graphics {
    Image getImage(String relLoc) throws IllegalArgumentException;

    Sprite getSprite(String id) throws IllegalArgumentException;

    Animation getAnimation(String id) throws IllegalArgumentException;

    GlobalLoopingAnimation getGlobalLoopingAnimation(String id) throws IllegalArgumentException;

    ImageAssetSet getImageAssetSet(String id) throws IllegalArgumentException;

    Font getFont(String id) throws IllegalArgumentException;
}
