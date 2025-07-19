package soliloquy.specs.io;

import soliloquy.specs.io.graphics.assets.ImageAssetSet;

public interface IO {
    ImageAssetSet getImageAssetSet(String id) throws IllegalArgumentException;
}
