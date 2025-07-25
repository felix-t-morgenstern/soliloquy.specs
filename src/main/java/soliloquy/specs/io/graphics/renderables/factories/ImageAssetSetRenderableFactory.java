package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.assets.ImageAssetSet;
import soliloquy.specs.io.graphics.renderables.ImageAssetSetRenderable;
import soliloquy.specs.io.graphics.renderables.colorshifting.ColorShift;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.Component;
import soliloquy.specs.ui.EventInputs;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <b>ImageAssetSetRenderableFactory</b>
 * <p>
 * Creates {@link ImageAssetSetRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ImageAssetSetRenderableFactory {
    /**
     * @param imageAssetSet           The ImageAssetSet to render
     * @param displayParams           The current display parameters for the ImageAssetSet (cf
     *                                {@link ImageAssetSet#getImageAssetWithDisplayParams})
     * @param colorShifts             The ColorShifts to apply when rendering
     * @param borderThicknessProvider A class which provides the thickness of the border to render
     * @param borderColorProvider     A class which provides the color of the border to render
     * @param renderingAreaProvider   A class which provides the area in which to render
     * @param z                       The z index within the container
     * @param uuid                    The universally unique identifier
     * @param containingStack         The Component to contain the Renderable
     * @return The newly-created ImageAssetSetRenderable
     * @throws IllegalArgumentException If and only if imageAssetSet is null; displayParams is null;
     *                                  colorShifts is null; renderingAreaProvider is null; uuid is
     *                                  null; or containingStack is null
     */
    ImageAssetSetRenderable make(ImageAssetSet imageAssetSet, Map<String, String> displayParams,
                                 List<ColorShift> colorShifts,
                                 ProviderAtTime<Float> borderThicknessProvider,
                                 ProviderAtTime<Color> borderColorProvider,
                                 ProviderAtTime<FloatBox> renderingAreaProvider, int z,
                                 UUID uuid,
                                 Component containingStack)
            throws IllegalArgumentException;

    /**
     * @param imageAssetSet               The ImageAssetSet to render
     * @param displayParams               The current display parameters for the ImageAssetSet (cf
     *                                    {@link ImageAssetSet#getImageAssetWithDisplayParams})
     * @param onPress                     The Actions which is fired when a click is registered on
     *                                    this renderable, with the integer keys corresponding to
     *                                    mouse buttons (c.f. GLFW_MOUSE_BUTTON_*)
     * @param onRelease                   The Actions which is fired when a click is registered on
     *                                    this renderable, with the integer keys corresponding to
     *                                    mouse buttons (c.f. GLFW_MOUSE_BUTTON_*)
     * @param onMouseOver                 The Action which is fired when the mouse moves over this
     *                                    renderable
     * @param onMouseLeave                The Action which is fired when the mouse leaves this
     *                                    renderable
     * @param colorShifts                 The ColorShifts to apply when rendering
     * @param borderThicknessProvider     A class which provides the thickness of the border to
     *                                    render
     * @param borderColorProvider         A class which provides the color of the border to render
     * @param renderingDimensionsProvider A class which provides the area in which to render
     * @param z                           The z index within the container
     * @param uuid                        The universally unique identifier
     * @param containingStack             The Component to contain the Renderable
     * @return The newly-created ImageAssetSetRenderable
     * @throws IllegalArgumentException If and only if imageAssetSet is null; displayParams is null;
     *                                  colorShifts is null; renderingDimensionsProvider is null;
     *                                  uuid is null; or containingStack is null
     */
    ImageAssetSetRenderable make(ImageAssetSet imageAssetSet,
                                 Map<String, String> displayParams,
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
                                 Component containingStack)
            throws IllegalArgumentException;
}
