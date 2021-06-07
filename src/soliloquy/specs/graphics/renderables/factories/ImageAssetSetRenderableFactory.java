package soliloquy.specs.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.EntityUuid;
import soliloquy.specs.graphics.assets.ImageAssetSet;
import soliloquy.specs.graphics.renderables.ImageAssetSetRenderable;
import soliloquy.specs.graphics.renderables.Renderable;
import soliloquy.specs.graphics.renderables.colorshifting.ColorShift;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.rendering.FloatBox;

import java.awt.*;
import java.util.List;
import java.util.function.Consumer;

/**
 * <b>ImageAssetSetRenderableFactory</b>
 * <p>
 * Creates {@link ImageAssetSetRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ImageAssetSetRenderableFactory extends SoliloquyClass {
    /**
     * @param imageAssetSet The ImageAssetSet to render
     * @param type The current type to render from the ImageAssetSet (c.f.
     * {@link ImageAssetSet#getImageAssetForTypeAndDirection})
     * @param direction The current direction to render from the ImageAssetSet (c.f.
     * {@link ImageAssetSet#getImageAssetForTypeAndDirection})
     * @param colorShifts The ColorShifts to apply when rendering
     * @param borderThicknessProvider A class which provides the thickness of the border to render
     * @param borderColorProvider A class which provides the color of the border to render
     * @param renderingAreaProvider A class which provides the area in which to render
     * @param z The z index within the container
     * @param uuid The universally unique identifier
     * @param updateZIndexInContainer A Consumer which will accept this object to update its
     *                                z-index within its container when
     *                                {@link ImageAssetSetRenderable#setZ} is called
     * @param removeFromContainer A Consumer which will accept this object to delete it from its
     *                            container when deleted
     * @return The newly-created ImageAssetSetRenderable
     * @throws IllegalArgumentException If and only if imageAssetSet is null; both type and
     * direction are null or empty; colorShifts is null; renderingAreaProvider is null; uuid is
     * null; updateZIndexInContainer is null; or removeFromContainer is null
     */
    ImageAssetSetRenderable make(ImageAssetSet imageAssetSet, String type, String direction,
                                 List<ColorShift> colorShifts,
                                 ProviderAtTime<Float> borderThicknessProvider,
                                 ProviderAtTime<Color> borderColorProvider,
                                 ProviderAtTime<FloatBox> renderingAreaProvider, int z,
                                 EntityUuid uuid,
                                 Consumer<Renderable> updateZIndexInContainer,
                                 Consumer<Renderable> removeFromContainer)
            throws IllegalArgumentException;

    /**
     * @param imageAssetSet The ImageAssetSet to render
     * @param type The current type to render from the ImageAssetSet (c.f.
     * {@link ImageAssetSet#getImageAssetForTypeAndDirection})
     * @param direction The current direction to render from the ImageAssetSet (c.f.
     * {@link ImageAssetSet#getImageAssetForTypeAndDirection})
     * @param onClick The Action which is fired when a click is registered on this renderable
     * @param onMouseOver The Action which is fired when the mouse moves over this renderable
     * @param onMouseLeave The Action which is fired when the mouse leaves this renderable
     * @param colorShifts The ColorShifts to apply when rendering
     * @param borderThicknessProvider A class which provides the thickness of the border to render
     * @param borderColorProvider A class which provides the color of the border to render
     * @param renderingDimensionsProvider A class which provides the area in which to render
     * @param z The z index within the container
     * @param uuid The universally unique identifier
     * @param updateZIndexInContainer A Consumer which will accept this object to update its
     *                                z-index within its container when
     *                                {@link ImageAssetSetRenderable#setZ} is called
     * @param removeFromContainer A Consumer which will accept this object to delete it from its
     *                            container when deleted
     * @return The newly-created ImageAssetSetRenderable
     * @throws IllegalArgumentException If and only if imageAssetSet is null; both type and
     * direction are null or empty; colorShifts is null; renderingDimensionsProvider is null; uuid
     * is null; updateZIndexInContainer is null; or removeFromContainer is null
     */
    ImageAssetSetRenderable make(ImageAssetSet imageAssetSet, String type, String direction,
                                 @SuppressWarnings("rawtypes") Action onClick,
                                 @SuppressWarnings("rawtypes") Action onMouseOver,
                                 @SuppressWarnings("rawtypes") Action onMouseLeave,
                                 List<ColorShift> colorShifts,
                                 ProviderAtTime<Float> borderThicknessProvider,
                                 ProviderAtTime<Color> borderColorProvider,
                                 ProviderAtTime<FloatBox> renderingDimensionsProvider, int z,
                                 EntityUuid uuid,
                                 Consumer<Renderable> updateZIndexInContainer,
                                 Consumer<Renderable> removeFromContainer)
            throws IllegalArgumentException;
}