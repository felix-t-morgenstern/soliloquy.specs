package soliloquy.specs.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.assets.Animation;
import soliloquy.specs.graphics.renderables.FiniteAnimationRenderable;
import soliloquy.specs.graphics.renderables.Renderable;
import soliloquy.specs.graphics.renderables.colorshifting.ColorShift;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.rendering.FloatBox;
import soliloquy.specs.graphics.rendering.RenderableStack;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * <b>SpriteRenderableFactory</b>
 * <p>
 * Creates {@link FiniteAnimationRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FiniteAnimationRenderableFactory extends SoliloquyClass {
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
                                   Map<Integer, Action<Long>> onPress,
                                   Map<Integer, Action<Long>> onRelease,
                                   Action<Long> onMouseOver,
                                   Action<Long> onMouseLeave,
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
