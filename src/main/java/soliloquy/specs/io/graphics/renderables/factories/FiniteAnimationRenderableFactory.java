package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.assets.Animation;
import soliloquy.specs.io.graphics.renderables.FiniteAnimationRenderable;
import soliloquy.specs.io.graphics.renderables.colorshifting.ColorShift;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.Component;
import soliloquy.specs.ui.EventInputs;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <b>SpriteRenderableFactory</b>
 * <p>
 * Creates {@link FiniteAnimationRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FiniteAnimationRenderableFactory {
    /**
     * <i>NB: This method is for FiniteAnimationRenderables which do not support mouse events.</i>
     *
     * @param animation               The Animation to be rendered
     * @param borderThicknessProvider A class which provides the thickness of the border to render
     * @param borderColorProvider     A class which provides the color of the border to render
     * @param colorShifts             A list ColorShifts for this Animation
     * @param areaProvider            A class which provides the dimensions in which to render
     * @param z                       The z index within the container
     * @param uuid                    The universally unique identifier
     * @param component         The Component to contain the Renderable
     * @param startTimestamp          The time at which this Animation began or will begin
     * @param pausedTimestamp         The time at which this Animation has been paused
     * @return The newly-created FiniteAnimationRenderable
     * @throws IllegalArgumentException If and only if animation, borderThicknessProvider,
     *                                  borderColorProvider, colorShiftProviders, areaProvider,
     *                                  uuid, or component are null
     */
    FiniteAnimationRenderable make(Animation animation,
                                   ProviderAtTime<Float> borderThicknessProvider,
                                   ProviderAtTime<Color> borderColorProvider,
                                   List<ColorShift> colorShifts,
                                   ProviderAtTime<FloatBox> areaProvider, int z,
                                   UUID uuid,
                                   Component component,
                                   long startTimestamp,
                                   Long pausedTimestamp)
            throws IllegalArgumentException;

    /**
     * <i>NB: This method is for FiniteAnimationRenderables which support mouse events.</i>
     *
     * @param animation               The Animation to be rendered
     * @param borderThicknessProvider A class which provides the thickness of the border to render
     * @param borderColorProvider     A class which provides the color of the border to render
     * @param onPress                 The Actions which is fired when a click is registered on this
     *                                renderable, with the integer keys corresponding to mouse
     *                                buttons (c.f. GLFW_MOUSE_BUTTON_*)
     * @param onRelease               The Actions which is fired when a click is registered on this
     *                                renderable, with the integer keys corresponding to mouse
     *                                buttons (c.f. GLFW_MOUSE_BUTTON_*)
     * @param onMouseOver             The Action which is fired when the mouse moves over this
     *                                renderable
     * @param onMouseLeave            The Action which is fired when the mouse leaves this
     *                                renderable
     * @param colorShifts             A list ColorShifts for this Animation
     * @param areaProvider            A class which provides the dimensions in which to render
     * @param z                       The z index within the container
     * @param uuid                    The universally unique identifier
     * @param component         The Component to contain the Renderable
     * @param startTimestamp          The time at which this Animation began or will begin
     * @param pausedTimestamp         The time at which this Animation has been paused
     * @return The newly-created FiniteAnimationRenderable
     * @throws IllegalArgumentException If and only if animation, borderThicknessProvider,
     *                                  borderColorProvider, colorShiftProviders, areaProvider,
     *                                  uuid, or component are null
     */
    FiniteAnimationRenderable make(Animation animation,
                                   ProviderAtTime<Float> borderThicknessProvider,
                                   ProviderAtTime<Color> borderColorProvider,
                                   Map<Integer, Action<EventInputs>> onPress,
                                   Map<Integer, Action<EventInputs>> onRelease,
                                   Action<EventInputs> onMouseOver,
                                   Action<EventInputs> onMouseLeave,
                                   List<ColorShift> colorShifts,
                                   ProviderAtTime<FloatBox> areaProvider,
                                   int z,
                                   UUID uuid,
                                   Component component,
                                   long startTimestamp,
                                   Long pausedTimestamp)
            throws IllegalArgumentException;
}
