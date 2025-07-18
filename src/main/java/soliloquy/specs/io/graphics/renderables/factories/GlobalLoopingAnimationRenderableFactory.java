package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.io.graphics.assets.GlobalLoopingAnimation;
import soliloquy.specs.io.graphics.renderables.GlobalLoopingAnimationRenderable;
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
 * <b>GlobalLoopingAnimationRenderableFactory</b>
 * <p>
 * Creates {@link GlobalLoopingAnimationRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GlobalLoopingAnimationRenderableFactory {
    /**
     * @param globalLoopingAnimation  The GlobalLoopingAnimation to render
     * @param colorShiftProviders     The ColorShifts to apply when rendering (NB: This List is
     *                                intended to contain Providers which will provide ColorShifts
     *                                of
     *                                the same type for each entry in the list; however, you can
     *                                obviously use it differently if you please.)
     * @param borderThicknessProvider A class which provides the thickness of the border to render
     * @param borderColorProvider     A class which provides the color of the border to render
     * @param areaProvider            A class which provides the area in which to render
     * @param z                       The z index within the container
     * @param uuid                    The universally unique identifier
     * @param containingStack         The RenderableStack to contain the Renderable
     * @return The newly-created GlobalLoopingAnimationRenderable
     * @throws IllegalArgumentException If and only if globalLoopingAnimation is null; colorShifts
     *                                  is null; areaProvider is null; uuid is null; or
     *                                  containingStack is null
     */
    GlobalLoopingAnimationRenderable make(GlobalLoopingAnimation globalLoopingAnimation,
                                          ProviderAtTime<Float> borderThicknessProvider,
                                          ProviderAtTime<Color> borderColorProvider,
                                          List<ProviderAtTime<ColorShift>> colorShiftProviders,
                                          ProviderAtTime<FloatBox> areaProvider,
                                          int z, UUID uuid,
                                          RenderableStack containingStack)
            throws IllegalArgumentException;

    /**
     * @param globalLoopingAnimation  The GlobalLoopingAnimation to render
     * @param borderThicknessProvider A class which provides the thickness of the border to render
     * @param borderColorProvider     A class which provides the color of the border to render
     * @param onPress                 The Actions which is fired when a click is registered on this
     *                                renderable,
     *                                with the integer keys corresponding to mouse buttons (c.f.
     *                                GLFW_MOUSE_BUTTON_*)
     * @param onRelease               The Actions which is fired when a click is registered on this
     *                                renderable,
     *                                with the integer keys corresponding to mouse buttons (c.f.
     *                                GLFW_MOUSE_BUTTON_*)
     * @param onMouseOver             The Action which is fired when the mouse moves over this
     *                                renderable
     * @param onMouseLeave            The Action which is fired when the mouse leaves this
     *                                renderable
     * @param colorShiftProviders     The ColorShifts to apply when rendering (NB: This List is
     *                                intended to contain Providers which will provide ColorShifts
     *                                of
     *                                the same type for each entry in the list; however, you can
     *                                obviously use it differently if you please.)
     * @param areaProvider            A class which provides the area in which to render
     * @param z                       The z index within the container
     * @param uuid                    The universally unique identifier
     * @param containingStack         The RenderableStack to contain the Renderable
     * @return The newly-created GlobalLoopingAnimationRenderable
     * @throws IllegalArgumentException If and only if globalLoopingAnimation is null; colorShifts
     *                                  is null; renderingDimensionsProvider is null; uuid is null;
     *                                  or containingStack is null
     */
    GlobalLoopingAnimationRenderable make(GlobalLoopingAnimation globalLoopingAnimation,
                                          ProviderAtTime<Float> borderThicknessProvider,
                                          ProviderAtTime<Color> borderColorProvider,
                                          Map<Integer, Action<MouseEventInputs>> onPress,
                                          Map<Integer, Action<MouseEventInputs>> onRelease,
                                          Action<MouseEventInputs> onMouseOver,
                                          Action<MouseEventInputs> onMouseLeave,
                                          List<ProviderAtTime<ColorShift>> colorShiftProviders,
                                          ProviderAtTime<FloatBox> areaProvider,
                                          int z, UUID uuid,
                                          RenderableStack containingStack)
            throws IllegalArgumentException;
}
