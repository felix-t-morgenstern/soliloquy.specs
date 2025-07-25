package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.assets.Sprite;
import soliloquy.specs.io.graphics.renderables.SpriteRenderable;
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
 * Creates {@link SpriteRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface SpriteRenderableFactory {
    /**
     * @param sprite                      The Sprite to assign to this Renderable
     * @param colorShifts                 The ColorShifts to apply when rendering
     * @param borderThicknessProvider     A class which provides the thickness of the border to
     *                                    render
     * @param borderColorProvider         A class which provides the color of the border to render
     * @param renderingDimensionsProvider A class which provides the dimensions in which to render
     * @param z                           The z index within the container
     * @param uuid                        The universally unique identifier
     * @param component                   The Component to contain the Renderable
     * @return The newly-created SpriteRenderable
     * @throws IllegalArgumentException If and only if sprite is null; colorShifts is null;
     *                                  renderingDimensionsProvider is null; uuid is null; or
     *                                  component is null
     */
    SpriteRenderable make(Sprite sprite,
                          ProviderAtTime<Float> borderThicknessProvider,
                          ProviderAtTime<Color> borderColorProvider,
                          List<ColorShift> colorShifts,
                          ProviderAtTime<FloatBox> renderingDimensionsProvider,
                          int z,
                          UUID uuid,
                          Component component)
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
     * @param colorShifts                 The ColorShifts to apply when rendering
     * @param borderThicknessProvider     A class which provides the thickness of the border to
     *                                    render
     * @param borderColorProvider         A class which provides the color of the border to render
     * @param renderingDimensionsProvider A class which provides the dimensions in which to render
     * @param z                           The z index within the container
     * @param uuid                        The universally unique identifier
     * @param component                   The Component to contain the Renderable
     * @return The newly-created SpriteRenderable
     * @throws IllegalArgumentException If and only if sprite is null; colorShifts is null;
     *                                  renderingDimensionsProvider is null; uuid is null;
     *                                  component is null; or borderThicknessProvider is null,
     *                                  and borderColorProvider is non-null
     */
    SpriteRenderable make(Sprite sprite,
                          ProviderAtTime<Float> borderThicknessProvider,
                          ProviderAtTime<Color> borderColorProvider,
                          Map<Integer, Action<EventInputs>> onPress,
                          Map<Integer, Action<EventInputs>> onRelease,
                          Action<EventInputs> onMouseOver,
                          Action<EventInputs> onMouseLeave,
                          List<ColorShift> colorShifts,
                          ProviderAtTime<FloatBox> renderingDimensionsProvider,
                          int z,
                          UUID uuid,
                          Component component)
            throws IllegalArgumentException;
}
