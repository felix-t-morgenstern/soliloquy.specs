package soliloquy.specs.io.graphics.renderables;

import soliloquy.specs.common.shared.HasUuid;
import soliloquy.specs.gamestate.entities.Deletable;
import soliloquy.specs.ui.Component;

/**
 * <b>Renderable</b>
 * <p>
 * An object which can be rendered in the window
 * <p>
 * Each renderable can contain Renderables within it, each with their own internal z-indices, which
 * cannot supersede the rendering of anything with a higher z-index than its parent Renderable.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Renderable extends HasUuid, Deletable {
    /**
     * @return The Component containing this Renderable
     */
    Component component();

    /**
     * <i>NB: Higher z values will be rendered first.</i>
     *
     * @return The z-index of this Renderable within its {@link #component()}
     */
    int getZ();

    /**
     * C.f. {@link #getZ()} for more information
     *
     * @param z The value to assign for the z-index
     */
    void setZ(int z);
}
