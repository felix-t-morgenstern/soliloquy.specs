package soliloquy.specs.io.graphics.renderables;

import soliloquy.specs.common.entities.BiConsumer;
import soliloquy.specs.common.entities.Consumer;
import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.gamestate.entities.shared.HasData;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.io.graphics.rendering.RenderingBoundaries;
import soliloquy.specs.io.input.keyboard.KeyEventHandler;
import soliloquy.specs.io.input.keyboard.KeyBinding;

import java.util.Set;

/**
 * <b>Component</b>
 * <p>
 * A Component is the base unit of the UI. A Component is Renderable, which is composed of one or
 * more Renderables, and which can contain limited, local state and logic. It provides
 * {@link KeyBinding}s to {@link KeyEventHandler},
 * and can provide rendering boundaries to
 * {@link soliloquy.specs.io.graphics.rendering.renderers.ComponentRenderer#render}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Component extends Renderable, HasData {
    /**
     * A Set of the KeyBindings in this context
     */
    Set<KeyBinding> keyBindings();

    /**
     * True, if and only if all lower contexts' bindings are blocked (c.f.
     * {@link KeyEventHandler#addComponent})
     */
    boolean blocksLowerKeyBindings();

    /**
     * @param content The content to add to this Component
     * @throws IllegalArgumentException If and only if content is null, or not already reporting
     *                                  this as its Component (cf
     *                                  {@link Renderable#containingComponent()}, or if it is a
     *                                  Component whose tier (c.f. {@link #tier()}) is not one
     *                                  higher than this Component
     */
    void add(Renderable content) throws IllegalArgumentException;

    /**
     * Deletes the content upon removal
     *
     * @param content The content to remove
     * @throws IllegalArgumentException If and only if content is null or is in another Component
     */
    void remove(Renderable content) throws IllegalArgumentException;

    /**
     * Clears this Component of all of its content
     */
    void clear();

    /**
     * (NB: To remove contents from this Component, call {@link Renderable#delete()}
     *
     * @return A representation of the Renderables which comprise this Component
     */
    Set<Renderable> contentsRepresentation();

    /**
     * This method is used by other Components to know the dimensions this Component takes up, for
     * layout purposes.
     * <p>
     * <i>This method is different from {@link #getRenderingBoundariesProvider()}!</i> The rendering
     * boundaries are fed into {@link RenderingBoundaries#pushNewBoundaries} to limit the rendering
     * space, which is useful for instance in a scrollable box of content. This method is used so
     * that a scrollable box of content will be able to know the dimensions of its content.
     *
     * @return The dimensions this Component takes up
     */
    ProviderAtTime<FloatBox> getDimensionsProvider();

    /**
     * @param dimensionsProvider Provides the dimensions of this Component, c.f.
     *                           {@link #getDimensionsProvider()}
     * @throws IllegalArgumentException If and only if dimensionsProvider is null
     */
    void setDimensionsProvider(ProviderAtTime<FloatBox> dimensionsProvider)
            throws IllegalArgumentException;

    /**
     * <i>NB: To be used by {@link RenderingBoundaries#currentBoundaries()}</i>
     *
     * @return Provider for the rendering boundaries of this Component; all Renderables
     *         contained within will not be drawn beyond the dimensions provided here
     */
    ProviderAtTime<FloatBox> getRenderingBoundariesProvider();

    /**
     * @param renderingBoundariesProvider The Provider to assign for the rendering boundaries
     * @throws IllegalArgumentException      If and only if renderingBoundariesProvider is null
     * @throws UnsupportedOperationException If and only if the RenderingStack is top-level; the
     *                                       top-level RenderingStack should always only provide the
     *                                       whole screen as rendering boundaries
     */
    void setRenderingBoundariesProvider(ProviderAtTime<FloatBox> renderingBoundariesProvider)
            throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * @return The {@link soliloquy.specs.common.entities.BiFunction} called prior to this Component
     *         rendering within
     *         {@link soliloquy.specs.io.graphics.rendering.renderers.ComponentRenderer#render},
     *         whose respective inputs are the Component itself, and the timestamp. <i>NB: This
     *         functionality is hidden on the interface, since it is only intended to be used by UI
     *         components for layout purposes. The hook id is exposed for persistence only.</i>
     */
    String prerenderHookId();

    /**
     * <i>NB: This method is primarily intended for the UI to be able to assemble layouts of
     * variable content with dynamic dimensions</i>
     *
     * @return The Id of the {@link Consumer} called, with this
     *         Component adds new content
     */
    String addHookId();

    /**
     * @return The 'tier' of Component, where lower values imply a higher tier, e.g., 0 for
     *         top-level, 1 for a Component beneath top-level, etc.
     */
    int tier();
}
