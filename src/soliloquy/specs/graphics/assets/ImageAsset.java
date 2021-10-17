package soliloquy.specs.graphics.assets;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>ImageAsset</b>
 * <p>
 * This class is a type of Asset which is made of one or more snippets of an {@link Image}, i.e.
 * {@link Sprite}, {@link Animation}, and {@link GlobalLoopingAnimation}. This interface exists to
 * allow {@link ImageAssetSet}s to return assets of any of these types. This interface also
 * contains an enum value of the ImageAssetTypes, to be used (and not defined) by the graphics
 * engine.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ImageAsset extends Asset {
    /**
     * This enum exists so that ImageAsset definitions in text files can use the proper numerical
     * indicator for the type of ImageAsset to be loaded for the ImageAssets which compose an
     * {@link ImageAssetSet}, used by the
     * {@link soliloquy.specs.graphics.bootstrap.assetfactories.AssetFactory} which creates
     * ImageAssetSets
     */
    enum ImageAssetType {
        UNKNOWN(0),
        SPRITE(1),
        ANIMATION(2),
        GLOBAL_LOOPING_ANIMATION(3);

        private static final Map<Integer, ImageAssetType> BY_VALUE = new HashMap<>();

        static {
            for (ImageAssetType imageAssetType : values()) {
                BY_VALUE.put(imageAssetType.VALUE, imageAssetType);
            }
        }

        @SuppressWarnings("FieldCanBeLocal")
        private final int VALUE;

        ImageAssetType(int value) {
            VALUE = value;
        }

        public static ImageAssetType getFromValue(int value) {
            if (BY_VALUE.containsKey(value)) {
                return BY_VALUE.get(value);
            }
            return UNKNOWN;
        }

        @Override
        public String toString() {
            switch(this) {
                case UNKNOWN:
                    return "UNKNOWN";
                case SPRITE:
                    return Sprite.class.getCanonicalName();
                case ANIMATION:
                    return Animation.class.getCanonicalName();
            }
            throw new UnsupportedOperationException(
                    "Cannot perform toString on undefined enum value");
        }
    }
}
