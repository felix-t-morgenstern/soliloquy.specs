package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.io.graphics.renderables.TriangleRenderable;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.Component;
import soliloquy.specs.ui.EventInputs;

import java.awt.*;
import java.util.Map;
import java.util.UUID;

/**
 * <b>TriangleRenderableFactory</b>
 * <p>
 * Creates {@link TriangleRenderable}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TriangleRenderableFactory {
    /**
     * @param vertex1LocationProvider   Provides the location for the first vertex
     * @param vertex1ColorProvider      Provides the color of the first vertex
     * @param vertex2LocationProvider   Provides the location of the second vertex
     * @param vertex2ColorProvider      Provides the color of the second vertex
     * @param vertex3LocationProvider   Provides the location of the third vertex
     * @param vertex3ColorProvider      Provides the color of the third vertex
     * @param textureIdProvider         Provides the id of the texture of the background tiles; may
     *                                  return null, if no background tile is to be used
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
     * @param z                         The z index within the container
     * @param uuid                      The universally unique identifier
     * @param component           The Component to contain the Renderable
     * @return The newly-created TriangleRenderable
     * @throws IllegalArgumentException If and only if vertexLocation1Provider,
     *                                  vertex1ColorProvider, vertex2LocationProvider,
     *                                  vertex2ColorProvider, vertex3LocationProvider,
     *                                  vertex3ColorProvider, uuid, or component are null; or
     *                                  if textureTileWidthProvider or textureTileHeightProvider
     *                                  are null
     */
    TriangleRenderable make(ProviderAtTime<Vertex> vertex1LocationProvider,
                            ProviderAtTime<Color> vertex1ColorProvider,
                            ProviderAtTime<Vertex> vertex2LocationProvider,
                            ProviderAtTime<Color> vertex2ColorProvider,
                            ProviderAtTime<Vertex> vertex3LocationProvider,
                            ProviderAtTime<Color> vertex3ColorProvider,
                            ProviderAtTime<Integer> textureIdProvider,
                            ProviderAtTime<Float> textureTileWidthProvider,
                            ProviderAtTime<Float> textureTileHeightProvider,
                            Map<Integer, Action<EventInputs>> onPress,
                            Map<Integer, Action<EventInputs>> onRelease,
                            Action<EventInputs> onMouseOver,
                            Action<EventInputs> onMouseLeave,
                            int z,
                            UUID uuid,
                            Component component)
            throws IllegalArgumentException;
}
