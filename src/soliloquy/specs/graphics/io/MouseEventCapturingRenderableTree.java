package soliloquy.specs.graphics.io;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.RenderableWithArea;

public interface MouseEventCapturingRenderableTree extends SoliloquyClass {
    /**
     * @param x The x location of the mouse
     * @param y The y location of the mouse
     * @return The RenderableWithArea capturing mouse events at that location (can be null)
     * @throws IllegalArgumentException If and only if x or y are outside of window boundaries
     */
    RenderableWithArea getCapturingRenderable(float x, float y) throws IllegalArgumentException;
}
