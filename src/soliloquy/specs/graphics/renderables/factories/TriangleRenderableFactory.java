package soliloquy.specs.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.graphics.renderables.Renderable;
import soliloquy.specs.graphics.renderables.TriangleRenderable;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.awt.*;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * <b>TriangleRenderableFactory</b>
 * <p>
 * Creates {@link TriangleRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TriangleRenderableFactory extends SoliloquyClass {
    /**
     * @param vertex1LocationProvider     Provides the location for the first vertex
     * @param vertex1ColorProvider        Provides the color of the first vertex
     * @param vertex2LocationProvider     Provides the location of the second vertex
     * @param vertex2ColorProvider        Provides the color of the second vertex
     * @param vertex3LocationProvider     Provides the location of the third vertex
     * @param vertex3ColorProvider        Provides the color of the third vertex
     * @param backgroundTextureIdProvider Provides the Id of the texture of the background tiles;
     *                                    may return null, if no background tile is to be used
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
     * @param z                           The z index within the container
     * @param uuid                        The universally unique identifier
     * @param updateZIndexInContainer     A Consumer which will accept this object to update its
     *                                    z-index within its container when {@link Renderable#setZ}
     *                                    is called
     * @param removeFromContainer         A Consumer which will accept this object to delete it from
     *                                    its container when deleted
     * @return The newly-created TriangleRenderable
     * @throws IllegalArgumentException If and only if vertexLocation1Provider,
     *                                  vertex1ColorProvider, vertex2LocationProvider,
     *                                  vertex2ColorProvider, vertex3LocationProvider,
     *                                  vertex3ColorProvider, uuid, updateZIndexInContainer, or
     *                                  removeFromContainer are null; or if
     *                                  backgroundTextureTileWidth
     *                                  or backgroundTextureTileHeight are less than 0
     */
    TriangleRenderable make(ProviderAtTime<Vertex> vertex1LocationProvider,
                            ProviderAtTime<Color> vertex1ColorProvider,
                            ProviderAtTime<Vertex> vertex2LocationProvider,
                            ProviderAtTime<Color> vertex2ColorProvider,
                            ProviderAtTime<Vertex> vertex3LocationProvider,
                            ProviderAtTime<Color> vertex3ColorProvider,
                            ProviderAtTime<Integer> backgroundTextureIdProvider,
                            float backgroundTextureTileWidth,
                            float backgroundTextureTileHeight,
                            Map<Integer, Action<Long>> onPress,
                            Map<Integer, Action<Long>> onRelease,
                            Action<Long> onMouseOver,
                            Action<Long> onMouseLeave,
                            int z,
                            UUID uuid,
                            Consumer<Renderable> updateZIndexInContainer,
                            Consumer<Renderable> removeFromContainer)
            throws IllegalArgumentException;
}
