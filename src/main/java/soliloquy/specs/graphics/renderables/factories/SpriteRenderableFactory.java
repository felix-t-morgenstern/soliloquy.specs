package soliloquy.specs.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.assets.Sprite;
import soliloquy.specs.graphics.renderables.Renderable;
import soliloquy.specs.graphics.renderables.SpriteRenderable;
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
 * Creates {@link SpriteRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface SpriteRenderableFactory extends SoliloquyClass {
    /**
     * @param sprite                      The Sprite to assign to this Renderable
     * @param colorShiftProviders         The ColorShifts to apply when rendering (NB: This List is
     *                                    intended to contain Providers which will provide
     *                                    ColorShifts of the same type for each entry in the list;
     *                                    however, you can obviously use it differently if you
     *                                    please.)
     * @param borderThicknessProvider     A class which provides the thickness of the border to
     *                                    render
     * @param borderColorProvider         A class which provides the color of the border to render
     * @param renderingDimensionsProvider A class which provides the dimensions in which to render
     * @param z                           The z index within the container
     * @param uuid                        The universally unique identifier
     * @param containingStack             The RenderableStack to contain the Renderable
     * @return The newly-created SpriteRenderable
     * @throws IllegalArgumentException If and only if sprite is null; colorShifts is null;
     *                                  renderingDimensionsProvider is null; uuid is null; or
     *                                  containingStack is null
     */
    SpriteRenderable make(Sprite sprite, ProviderAtTime<Float> borderThicknessProvider,
                          ProviderAtTime<Color> borderColorProvider,
                          List<ProviderAtTime<ColorShift>> colorShiftProviders,
                          ProviderAtTime<FloatBox> renderingDimensionsProvider, int z,
                          UUID uuid, RenderableStack containingStack)
            throws IllegalArgumentException;

    /**
     * @param sprite                      The Sprite to assign to this Renderable
     * @param onPress                     The Actions which is fired when a click is registered on
     *                                    this Renderable, with the integer keys corresponding to
     *                                    mouse buttons (c.f. GLFW_MOUSE_BUTTON_*)
     * @param onRelease                   The Actions which is fired when a click is registered on
     *                                    this Renderable, with the integer keys corresponding to
     *                                    mouse buttons (c.f. GLFW_MOUSE_BUTTON_*)
     * @param onMouseOver                 The Action which is fired when the mouse moves over this
     *                                    Renderable
     * @param onMouseLeave                The Action which is fired when the mouse leaves this
     *                                    Renderable
     * @param colorShiftProviders         The ColorShifts to apply when rendering (NB: This List is
     *                                    intended to contain Providers which will provide
     *                                    ColorShifts of the same type for each entry in the list;
     *                                    however, you can obviously use it differently if you
     *                                    please.)
     * @param borderThicknessProvider     A class which provides the thickness of the border to
     *                                    render
     * @param borderColorProvider         A class which provides the color of the border to render
     * @param renderingDimensionsProvider A class which provides the dimensions in which to render
     * @param z                           The z index within the container
     * @param uuid                        The universally unique identifier
     * @param containingStack             The RenderableStack to contain the Renderable
     * @return The newly-created SpriteRenderable
     * @throws IllegalArgumentException If and only if sprite is null; colorShifts is null;
     *                                  renderingDimensionsProvider is null; uuid is null;
     *                                  containingStack is null; or borderThicknessProvider is null,
     *                                  and borderColorProvider is non-null
     */
    SpriteRenderable make(Sprite sprite, ProviderAtTime<Float> borderThicknessProvider,
                          ProviderAtTime<Color> borderColorProvider,
                          Map<Integer, Action<Long>> onPress,
                          Map<Integer, Action<Long>> onRelease,
                          Action<Long> onMouseOver,
                          Action<Long> onMouseLeave,
                          List<ProviderAtTime<ColorShift>> colorShiftProviders,
                          ProviderAtTime<FloatBox> renderingDimensionsProvider, int z,
                          UUID uuid, RenderableStack containingStack)
            throws IllegalArgumentException;
}
