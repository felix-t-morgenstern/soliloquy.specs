package soliloquy.specs.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.RectangleRenderable;
import soliloquy.specs.graphics.renderables.Renderable;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.rendering.FloatBox;

import java.awt.*;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * <b>RectangleRenderableFactory</b>
 * <p>
 * Creates {@link RectangleRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RectangleRenderableFactory extends SoliloquyClass {
    /**
     * @param topLeftColorProvider        A Provider for the color mask at the top-left corner (c.f.
     *                                    {@link RectangleRenderable#getTopLeftColorProvider()}
     * @param topRightColorProvider       A Provider for the color mask at the top-left corner (c.f.
     *                                    {@link RectangleRenderable#getTopRightColorProvider()}
     * @param bottomRightColorProvider    A Provider for the color mask at the top-left corner (c.f.
     *                                    {@link RectangleRenderable#getBottomRightColorProvider()}
     * @param bottomLeftColorProvider     A Provider for the color mask at the top-left corner (c.f.
     *                                    {@link RectangleRenderable#getBottomLeftColorProvider()}
     * @param backgroundTextureIdProvider A Provider for the background texture (c.f. {@link RectangleRenderable#getBackgroundTextureIdProvider()}
     * @param backgroundTextureTileWidth  The width of each "tile" of the background texture
     *                                    provided, where 1.0 is the width of the window
     * @param backgroundTextureTileHeight The width of each "tile" of the background texture
     *                                    provided, where 1.0 is the width of the window
     * @param onPress                     The Actions which is fired when a click is registered on
     *                                    this renderable,
     *                                    with the integer keys corresponding to mouse buttons
     *                                    (c.f.
     *                                    GLFW_MOUSE_BUTTON_*)
     * @param onRelease                   The Actions which is fired when a click is registered on
     *                                    this renderable,
     *                                    with the integer keys corresponding to mouse buttons
     *                                    (c.f.
     *                                    GLFW_MOUSE_BUTTON_*)
     * @param onMouseOver                 The Action which is fired when the mouse moves over this
     *                                    renderable
     * @param onMouseLeave                The Action which is fired when the mouse leaves this
     *                                    renderable
     * @param renderingAreaProvider       A class which provides the dimensions in which to render
     * @param z                           The z index within the container
     * @param uuid                        The universally unique identifier
     * @param updateZIndexInContainer     A Consumer which will accept this object to update its
     *                                    z-index within its container when {@link Renderable#setZ}
     *                                    is called
     * @param removeFromContainer         A Consumer which will accept this object to delete it from
     *                                    its container when deleted
     * @return The newly-created RectangleRenderable
     * @throws IllegalArgumentException If and only if topLeftColorProvider, topRightColorProvider,
     *                                  bottomRightColorProvider, bottomLeftColorProvider,
     *                                  backgroundTextureIdProvider,
     *                                  colorShiftProviders, renderingAreaProvider, uuid,
     *                                  updateZIndexInContainer, or
     *                                  removeFromContainer are null; or if
     *                                  backgroundTextureTileWidth
     *                                  or backgroundTileHeight are
     *                                  less than or equal to 0
     */
    RectangleRenderable make(ProviderAtTime<Color> topLeftColorProvider,
                             ProviderAtTime<Color> topRightColorProvider,
                             ProviderAtTime<Color> bottomRightColorProvider,
                             ProviderAtTime<Color> bottomLeftColorProvider,
                             ProviderAtTime<Integer> backgroundTextureIdProvider,
                             float backgroundTextureTileWidth,
                             float backgroundTextureTileHeight,
                             Map<Integer, Action<Long>> onPress,
                             Map<Integer, Action<Long>> onRelease,
                             Action<Long> onMouseOver,
                             Action<Long> onMouseLeave,
                             ProviderAtTime<FloatBox> renderingAreaProvider,
                             int z,
                             UUID uuid,
                             Consumer<Renderable> updateZIndexInContainer,
                             Consumer<Renderable> removeFromContainer)
            throws IllegalArgumentException;
}
