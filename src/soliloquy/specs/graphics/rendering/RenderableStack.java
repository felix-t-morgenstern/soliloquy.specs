package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.Renderable;

/**
 * <b>RenderableStack</b>
 * <p>
 * This class is a stack of {@link Renderable}s, to be rendered, in descending order of
 * z-indices.
 * <p>
 * Multiple Renderables can have the same z-index, but in this case, no promises can be made as to
 * which of those Renderables will be rendered first.
 * <p>
 * (This class is not a stack in the strict sense of the term; it can be thought of more as a Map
 * of Lists.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RenderableStack extends SoliloquyClass {
    /**
     * Clears the contained Renderables
     */
    void clearContainedRenderables();

    /**
     * <i>NB: Higher z values will be rendered first.</i>
     * If renderable is already present in the stack, this method does nothing.
     * @param renderable The Renderable to add to the stack
     * @throws IllegalArgumentException If and only if renderable is null
     */
    void add(Renderable renderable) throws IllegalArgumentException;

    // TODO: Ensure that snapshot ONLY includes clones
    /**
     * @return A snapshot of the stack. (NB: While the Renderables are not clones, there should
     * also be nothing mutable about any Renderable; they are essentially stateless)
     */
    Map<Integer, List<Renderable>> snapshot();
}
