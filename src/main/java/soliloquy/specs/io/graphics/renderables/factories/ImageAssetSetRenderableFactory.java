package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.Direction;
import soliloquy.specs.io.graphics.assets.ImageAssetSet;
import soliloquy.specs.io.graphics.renderables.ImageAssetSetRenderable;
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
     * @param type                    The current type to render from the ImageAssetSet (c.f.
     *                                {@link ImageAssetSet#getImageAssetForTypeAndDirection})
     * @param direction               The current direction to render from the ImageAssetSet (c.f.
     *                                {@link ImageAssetSet#getImageAssetForTypeAndDirection})
     * @param colorShiftProviders     The ColorShifts to apply when rendering (NB: This List is
     *                                intended to contain Providers which will provide ColorShifts
     *                                of the same type for each entry in the list; however, you can
     *                                obviously use it differently if you please.)
     * @param borderThicknessProvider A class which provides the thickness of the border to render
     * @param borderColorProvider     A class which provides the color of the border to render
     * @param renderingAreaProvider   A class which provides the area in which to render
     * @param z                       The z index within the container
     * @param uuid                    The universally unique identifier
     * @param containingStack         The RenderableStack to contain the Renderable
     * @return The newly-created ImageAssetSetRenderable
     * @throws IllegalArgumentException If and only if imageAssetSet is null; both type and
     *                                  direction are null or empty; colorShifts is null;
     *                                  renderingAreaProvider is null; uuid is null; or
     *                                  containingStack is null
     */
    ImageAssetSetRenderable make(ImageAssetSet imageAssetSet, String type, Direction direction,
                                 List<ProviderAtTime<ColorShift>> colorShiftProviders,
                                 ProviderAtTime<Float> borderThicknessProvider,
                                 ProviderAtTime<Color> borderColorProvider,
                                 ProviderAtTime<FloatBox> renderingAreaProvider, int z,
                                 UUID uuid,
                                 RenderableStack containingStack)
            throws IllegalArgumentException;

    /**
     * @param imageAssetSet               The ImageAssetSet to render
     * @param type                        The current type to render from the ImageAssetSet (c.f.
     *                                    {@link ImageAssetSet#getImageAssetForTypeAndDirection})
     * @param direction                   The current direction to render from the ImageAssetSet
     *                                    (c.f.
     *                                    {@link ImageAssetSet#getImageAssetForTypeAndDirection})
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
     * @param colorShiftProviders         The ColorShifts to apply when rendering (NB: This List is
     *                                    intended to contain Providers which will provide
     *                                    ColorShifts of the same type for each entry in the list;
     *                                    however, you can obviously use it differently if you
     *                                    please.)
     * @param borderThicknessProvider     A class which provides the thickness of the border to
     *                                    render
     * @param borderColorProvider         A class which provides the color of the border to render
     * @param renderingDimensionsProvider A class which provides the area in which to render
     * @param z                           The z index within the container
     * @param uuid                        The universally unique identifier
     * @param containingStack             The RenderableStack to contain the Renderable
     * @return The newly-created ImageAssetSetRenderable
     * @throws IllegalArgumentException If and only if imageAssetSet is null; both type and
     *                                  direction are null or empty; colorShifts is null;
     *                                  renderingDimensionsProvider is null; uuid is null; or
     *                                  containingStack is null
     */
    ImageAssetSetRenderable make(ImageAssetSet imageAssetSet, String type, Direction direction,
                                 Map<Integer, Action<MouseEventInputs>> onPress,
                                 Map<Integer, Action<MouseEventInputs>> onRelease,
                                 Action<MouseEventInputs> onMouseOver,
                                 Action<MouseEventInputs> onMouseLeave,
                                 List<ProviderAtTime<ColorShift>> colorShiftProviders,
                                 ProviderAtTime<Float> borderThicknessProvider,
                                 ProviderAtTime<Color> borderColorProvider,
                                 ProviderAtTime<FloatBox> renderingDimensionsProvider, int z,
                                 UUID uuid,
                                 RenderableStack containingStack)
            throws IllegalArgumentException;
}
