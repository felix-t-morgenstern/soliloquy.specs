package soliloquy.specs.io.graphics.renderables.providers;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.common.shared.HasUuid;
import soliloquy.specs.common.shared.PausableAtTime;
import soliloquy.specs.io.graphics.renderables.FiniteAnimationRenderable;
import soliloquy.specs.io.graphics.renderables.SpriteRenderable;
import soliloquy.specs.io.graphics.shared.HasMostRecentTimestamp;

/**
 * <b>ProviderAtTime</b>
 * <p>
 * A provider of an object of a specified type--e.g. an
 * {@link soliloquy.specs.io.graphics.assets.AnimationFrameSnippet} for a
 * {@link FiniteAnimationRenderable}, a float for
 * {@link SpriteRenderable#getBorderThicknessProvider()}, or a {@link java.awt.Color} for
 * {@link SpriteRenderable#getBorderColorProvider()}. By accepting a timestamp, the ProviderAtTime
 * can support animations of varying sorts--not only the animated sprites for the dedicated
 * Animation classes, but also animating
 * {@link soliloquy.specs.io.graphics.renderables.colorshifting.ColorShift}s, Sprite borders, etc.
 * This class can also be implemented to simply provide a static value, for when you simply don't
 * want to animate any of these things.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ProviderAtTime<T> extends PausableAtTime, HasUuid, HasMostRecentTimestamp {
    /**
     * @param timestamp The timestamp for which to provide the specified type of object
     * @return The specified type of object, at the provided timestamp
     * @throws IllegalArgumentException If and only if timestamp is before the most recent
     *                                  timestamp at which a value was requested, or a pause or
     *                                  unpause was reported
     */
    T provide(long timestamp) throws IllegalArgumentException;

    /**
     * <i>NB: This method exists for {@link soliloquy.specs.common.persistence.TypeHandler}s, which
     * are expected to cast the output to the required type. Recipients of a ProviderAtTime should
     * not be expected to know what type is used to represent the values provided. This is a
     * representation, so changing the output of this method will not change the behavior of the
     * ProviderAtTime<./i>
     *
     * @return A representation of how values are to be provided, e.g., a {@link java.util.Map}
     *         describing which {@link FloatBox} to provide at a
     *         given timestamp
     */
    Object representation();
}
