package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.graphics.assets.Animation;
import soliloquy.specs.graphics.assets.Sprite;
import soliloquy.specs.graphics.renderables.colorshifting.ColorShift;

/**
 * <b>MouseCursorAsset</b>
 * <p>
 * This class specifies the {@link soliloquy.specs.graphics.assets.Sprite} or
 * {@link soliloquy.specs.graphics.assets.Animation} to be used for the mouse cursor.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface MouseCursorAsset {
    /**
     * @param sprite The Sprite to which to set the mouse cursor
     * @throws IllegalArgumentException If and only if sprite is null
     */
    void set(Sprite sprite) throws IllegalArgumentException;

    /**
     * @param animation The animation to which to set the mouse cursor
     * @param msPosition The millisecond position at which to start the Animation. Usually, this
     *                   will be 0, implying that the Animation will start when the cursor is set
     *                   to a new Animation; but there may be cases to start at a non-0 value, like
     *                   when the cursor has different pulsing Animations for different menu
     *                   options, with the same periodicity, but slightly different appearances.
     * @throws IllegalArgumentException If and only if animation is null, or if msPosition is less
     * than zero or greater than the Animation's duration in milliseconds
     */
    void set(Animation animation, int msPosition) throws IllegalArgumentException;

    /**
     * @return A mutable List of color shifts for the mouse cursor
     */
    List<ColorShift> colorShifts();

    /**
     * Clears the asset used for the mouse cursor, returning it to the default OS mouse cursor
     */
    void clear();
}
