package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.infrastructure.ReadableCollection;
import soliloquy.specs.common.infrastructure.ReadableMap;
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
     * Clears the stack
     */
    void clear();

    /**
     * <i>NB: Higher z values will be rendered first.</i>
     * If renderable is already present in the stack, this method does nothing.
     * @param renderable The Renderable to add to the stack
     * @throws IllegalArgumentException If and only if renderable is null
     */
    void add(Renderable renderable) throws IllegalArgumentException;

    /**
     * @return A read-only representation of the stack. <i>(NB: All of the Renderables are to be
     * clones, so any changes to Renderables taking place during the rendering of a frame will not
     * change what is expected to be rendered on that frame mid-rendering.)</i>
     */
    ReadableMap<Integer, ReadableCollection<Renderable>> snapshot();
}
