package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.io.graphics.assets.Animation;
import soliloquy.specs.io.graphics.renderables.FiniteAnimationRenderable;
import soliloquy.specs.io.graphics.renderables.RenderableWithMouseEvents.MouseEventInputs;
import soliloquy.specs.io.graphics.renderables.colorshifting.ColorShift;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.rendering.RenderableStack;

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
     * @param colorShiftProviders     A list of Providers which provide ColorShifts for this
     *                                Animation
     * @param renderingAreaProvider   A class which provides the dimensions in which to render
     * @param z                       The z index within the container
     * @param uuid                    The universally unique identifier
     * @param containingStack         The RenderableStack to contain the Renderable
     * @param startTimestamp          The time at which this Animation began or will begin
     * @param pausedTimestamp         The time at which this Animation has been paused
     * @param mostRecentTimestamp     The most recent time at which this Animation has been
     *                                rendered, paused, or captured any mouse events
     * @return The newly-created FiniteAnimationRenderable
     * @throws IllegalArgumentException If and only if animation, borderThicknessProvider,
     *                                  borderColorProvider, colorShiftProviders,
     *                                  renderingAreaProvider, uuid, or containingStack are null;
     *                                  or if pausedTimestamp is non-null, and mostRecentTimestamp
     *                                  is either null, or before pausedTimestamp
     */
    FiniteAnimationRenderable make(Animation animation,
                                   ProviderAtTime<Float> borderThicknessProvider,
                                   ProviderAtTime<Color> borderColorProvider,
                                   List<ProviderAtTime<ColorShift>> colorShiftProviders,
                                   ProviderAtTime<FloatBox> renderingAreaProvider, int z,
                                   UUID uuid, RenderableStack containingStack,
                                   long startTimestamp, Long pausedTimestamp,
                                   Long mostRecentTimestamp)
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
     * @param colorShiftProviders     A list of Providers which provide ColorShifts for this
     *                                Animation
     * @param renderingAreaProvider   A class which provides the dimensions in which to render
     * @param z                       The z index within the container
     * @param uuid                    The universally unique identifier
     * @param containingStack         The RenderableStack to contain the Renderable
     * @param startTimestamp          The time at which this Animation began or will begin
     * @param pausedTimestamp         The time at which this Animation has been paused
     * @param mostRecentTimestamp     The most recent time at which this Animation has been
     *                                rendered, paused, or captured any mouse events
     * @return The newly-created FiniteAnimationRenderable
     * @throws IllegalArgumentException If and only if animation, borderThicknessProvider,
     *                                  borderColorProvider, colorShiftProviders,
     *                                  renderingAreaProvider, uuid, or containingStack are null;
     *                                  or if pausedTimestamp is non-null, and mostRecentTimestamp
     *                                  is either null, or before pausedTimestamp
     */
    FiniteAnimationRenderable make(Animation animation,
                                   ProviderAtTime<Float> borderThicknessProvider,
                                   ProviderAtTime<Color> borderColorProvider,
                                   Map<Integer, Action<MouseEventInputs>> onPress,
                                   Map<Integer, Action<MouseEventInputs>> onRelease,
                                   Action<MouseEventInputs> onMouseOver,
                                   Action<MouseEventInputs> onMouseLeave,
                                   List<ProviderAtTime<ColorShift>> colorShiftProviders,
                                   ProviderAtTime<FloatBox> renderingAreaProvider,
                                   int z,
                                   UUID uuid,
                                   RenderableStack containingStack,
                                   long startTimestamp,
                                   Long pausedTimestamp,
                                   Long mostRecentTimestamp)
            throws IllegalArgumentException;
}
