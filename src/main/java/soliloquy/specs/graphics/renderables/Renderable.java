package soliloquy.specs.graphics.renderables;

import soliloquy.specs.common.shared.HasUuid;
import soliloquy.specs.graphics.rendering.RenderableStack;

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
public interface Renderable extends HasUuid {
    /**
     * <i>NB: Higher z values will be rendered first.</i>
     *
     * @return The z-index of this Renderable within its {@link #containingStack()}
     */
    int getZ();

    /**
     * C.f. {@link #getZ()} for more information
     *
     * @param z The value to assign for the z-index
     */
    void setZ(int z);

    /**
     * @return The RenderableStack containing this Renderable. Will return null if and only if this
     *         Renderable has been deleted.
     */
    RenderableStack containingStack();

    /**
     * The intended method to remove a Renderable from its RenderingStack. Invokes
     * {@link RenderableStack#remove}. Also handles unsubscribing
     * {@link GlobalLoopingAnimationRenderable}s from a publisher of pause and unpause updates.
     * <p>
     * (NB: This class does not extend Deletable, since there is no need to assess whether it has
     * been deleted.)
     */
    void delete();
}
