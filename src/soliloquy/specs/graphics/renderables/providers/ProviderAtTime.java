package soliloquy.specs.graphics.renderables.providers;

import soliloquy.specs.common.shared.HasOneGenericParam;
import soliloquy.specs.common.shared.PausableAtTime;
import soliloquy.specs.graphics.renderables.FiniteAnimationRenderable;
import soliloquy.specs.graphics.renderables.SpriteRenderable;

/**
 * <b>ProviderAtTime</b>
 * <p>
 * A provider of an object of a specified type--e.g. an
 * {@link soliloquy.specs.graphics.assets.AnimationFrameSnippet} for a
 * {@link FiniteAnimationRenderable}, a float for
 * {@link SpriteRenderable#borderThicknessProvider()}, or a {@link java.awt.Color} for
 * {@link SpriteRenderable#borderColorProvider()}. By accepting a timestamp, the ProviderAtTime can
 * support animations of varying sorts--not only the animated sprites for the dedicated Animation
 * classes, but also animating
 * {@link soliloquy.specs.graphics.renderables.colorshifting.ColorShift}s, Sprite borders, etc.
 * This class can also be implemented to simply provide a static value, for when you simply don't
 * want to animate any of these things.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ProviderAtTime<T> extends PausableAtTime, HasOneGenericParam<T> {
    /**
     * @param timestamp The timestamp for which to provide the specified type of object
     * @return The specified type of object, at the provided timestamp
     * @throws IllegalArgumentException If and only if timestamp is before the most recent
     * timestamp at which a value was requested, or a pause or unpause was reported
     */
    T provide(long timestamp) throws IllegalArgumentException;
}
