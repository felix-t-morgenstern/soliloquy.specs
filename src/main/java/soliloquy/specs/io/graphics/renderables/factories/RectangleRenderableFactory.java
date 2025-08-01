package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.RectangleRenderable;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.Component;
import soliloquy.specs.ui.EventInputs;

import java.awt.*;
import java.util.Map;
import java.util.UUID;

/**
 * <b>RectangleRenderableFactory</b>
 * <p>
 * Creates {@link RectangleRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RectangleRenderableFactory {
    /**
     * @param topLeftColorProvider      A Provider for the color mask at the top-left corner (c.f.
     *                                  {@link RectangleRenderable#getTopLeftColorProvider()}
     * @param topRightColorProvider     A Provider for the color mask at the top-right corner
     *                                  (c.f.
     *                                  {@link RectangleRenderable#getTopRightColorProvider()}
     * @param bottomRightColorProvider  A Provider for the color mask at the bottom-right corner
     *                                  (c.f.
     *                                  {@link RectangleRenderable#getBottomRightColorProvider()}
     * @param bottomLeftColorProvider   A Provider for the color mask at the bottom-left corner
     *                                  (c.f.
     *                                  {@link RectangleRenderable#getBottomLeftColorProvider()}
     * @param textureIdProvider         A Provider for the background texture (c.f.
     *                                  {@link
     *                                  RectangleRenderable#getTextureIdProvider()}
     * @param textureTileWidthProvider  Provides the width of each "tile" of the background texture
     *                                  provided, where 1.0 is the width of the window
     * @param textureTileHeightProvider Provides the height of each "tile" of the background texture
     *                                  provided, where 1.0 is the height of the window
     * @param onPress                   The Actions which is fired when a click is registered on
     *                                  this Renderable, with the integer keys corresponding to
     *                                  mouse buttons (c.f. GLFW_MOUSE_BUTTON_*)
     * @param onRelease                 The Actions which is fired when a click is registered on
     *                                  this Renderable, with the integer keys corresponding to
     *                                  mouse buttons (c.f. GLFW_MOUSE_BUTTON_*)
     * @param onMouseOver               The Action which is fired when the mouse moves over this
     *                                  Renderable
     * @param onMouseLeave              The Action which is fired when the mouse leaves this
     *                                  Renderable
     * @param areaProvider              A class which provides the dimensions in which to render
     * @param z                         The z index within the container
     * @param uuid                      The universally unique identifier
     * @param component                 The Component to contain the Renderable
     * @return The newly-created RectangleRenderable
     * @throws IllegalArgumentException If and only if topLeftColorProvider, topRightColorProvider,
     *                                  bottomRightColorProvider, bottomLeftColorProvider,
     *                                  textureIdProvider, colorShiftProviders,
     *                                  areaProvider, uuid, or component are null; or
     *                                  if backgroundTextureTileWidth or backgroundTileHeight are
     *                                  less than or equal to 0
     */
    RectangleRenderable make(ProviderAtTime<Color> topLeftColorProvider,
                             ProviderAtTime<Color> topRightColorProvider,
                             ProviderAtTime<Color> bottomRightColorProvider,
                             ProviderAtTime<Color> bottomLeftColorProvider,
                             ProviderAtTime<Integer> textureIdProvider,
                             ProviderAtTime<Float> textureTileWidthProvider,
                             ProviderAtTime<Float> textureTileHeightProvider,
                             Map<Integer, Action<EventInputs>> onPress,
                             Map<Integer, Action<EventInputs>> onRelease,
                             Action<EventInputs> onMouseOver,
                             Action<EventInputs> onMouseLeave,
                             ProviderAtTime<FloatBox> areaProvider,
                             int z,
                             UUID uuid,
                             Component component)
            throws IllegalArgumentException;
}
