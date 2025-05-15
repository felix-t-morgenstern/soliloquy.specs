package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.renderables.colorshifting.ColorShift;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.util.List;

/**
 * <b>HasColorShifts</b>
 * <p>
 * A class which supports color shifts (see method description).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasColorShifts {
    /**
     * Color shifts at the front of the List are processed by the
     * {@link soliloquy.specs.graphics.renderables.colorshifting.ColorShiftStackAggregator}
     * before color shifts at the end.
     * <p>
     * <i>NB: There should not be any color shifts for a {@link RectangleRenderable} which does not
     * have a background Sprite or Animation.</i>
     *
     * @return A List of Providers of ColorShifts, to be applied to this Renderable, when rendering
     *         it in the {@link soliloquy.specs.graphics.rendering.Shader}
     */
    List<ProviderAtTime<ColorShift>> colorShiftProviders();
}
