package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.entities.Consumer;
import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.PolygonRenderable;
import soliloquy.specs.io.graphics.renderables.RectangleRenderable;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.io.graphics.renderables.Component;
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
     * @param topLeftColorProvider          See
     *                                      {@link RectangleRenderable#getTopLeftColorProvider()}
     * @param topRightColorProvider         See
     *                                      {@link RectangleRenderable#getTopRightColorProvider()}
     * @param bottomRightColorProvider      See
     *                                      {@link
     *                                      RectangleRenderable#getBottomRightColorProvider()}
     * @param bottomLeftColorProvider       See
     *                                      {@link RectangleRenderable#getBottomLeftColorProvider()}
     * @param textureIdProvider             See
     *                                      {@link
     *                                      PolygonRenderable#getTextureIdProvider()}
     * @param textureTilesPerWidthProvider  See
     *                                      {@link
     *                                      PolygonRenderable#getTextureTilesPerWidthProvider()}
     * @param textureXOffsetProvider        See
     *                                      {@link PolygonRenderable#getTextureXOffsetProvider()}
     * @param textureTilesPerHeightProvider See
     *                                      {@link
     *                                      PolygonRenderable#getTextureTilesPerHeightProvider()}
     * @param textureYOffsetProvider        See
     *                                      {@link PolygonRenderable#getTextureYOffsetProvider()}
     * @param onPress                       The Actions which is fired when a click is registered on
     *                                      this Renderable, with the integer keys corresponding to
     *                                      mouse buttons (c.f. GLFW_MOUSE_BUTTON_*)
     * @param onRelease                     The Actions which is fired when a click is registered on
     *                                      this Renderable, with the integer keys corresponding to
     *                                      mouse buttons (c.f. GLFW_MOUSE_BUTTON_*)
     * @param onMouseOver                   The Action which is fired when the mouse moves over this
     *                                      Renderable
     * @param onMouseLeave                  The Action which is fired when the mouse leaves this
     *                                      Renderable
     * @param dimensProvider                A class which provides the dimensions in which to render
     * @param z                             The z index within the container
     * @param uuid                          The universally unique identifier
     * @param component                     The Component to contain the Renderable
     * @return The newly-created RectangleRenderable
     * @throws IllegalArgumentException If and only if topLeftColorProvider, topRightColorProvider,
     *                                  bottomRightColorProvider, bottomLeftColorProvider,
     *                                  textureIdProvider, textureTilesPerWidthProvider,
     *                                  textureXOffsetProvider, textureTilesPerHeightProvider,
     *                                  textureYOffsetProvider, dimensProvider, uuid, or component
     *                                  are null; or if backgroundTextureTileWidth or
     *                                  backgroundTileHeight are less than or equal to 0
     */
    RectangleRenderable make(ProviderAtTime<Color> topLeftColorProvider,
                             ProviderAtTime<Color> topRightColorProvider,
                             ProviderAtTime<Color> bottomRightColorProvider,
                             ProviderAtTime<Color> bottomLeftColorProvider,
                             ProviderAtTime<Integer> textureIdProvider,
                             ProviderAtTime<Float> textureTilesPerWidthProvider,
                             ProviderAtTime<Float> textureXOffsetProvider,
                             ProviderAtTime<Float> textureTilesPerHeightProvider,
                             ProviderAtTime<Float> textureYOffsetProvider,
                             Map<Integer, Consumer<EventInputs>> onPress,
                             Map<Integer, Consumer<EventInputs>> onRelease,
                             Consumer<EventInputs> onMouseOver,
                             Consumer<EventInputs> onMouseLeave,
                             ProviderAtTime<FloatBox> dimensProvider,
                             int z,
                             UUID uuid,
                             Component component)
            throws IllegalArgumentException;
}
