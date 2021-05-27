package soliloquy.specs.graphics.renderables;

import soliloquy.specs.common.shared.HasUuid;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.rendering.FloatBox;

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
 *
 */
public interface Renderable extends HasUuid {
	/**
	 * <i>NB: Higher z values will be rendered first.</i>
	 * @return The z-index of this Renderable. (If this Renderable is within another Renderable,
	 * then the z-index is only used to determine rendering order amongst other Renderables within
	 * the containing Renderable.)
	 */
	int getZ();

	/**
	 * C.f. {@link #getZ()} for more information
	 * @param z The value to assign for the z-index
	 */
	void setZ(int z);

	/**
	 * (Currently only needed when {@link GlobalLoopingAnimationRenderable}s are deleted; handles
	 * unsubscribing that class from a publisher of pause and unpause updates.)
	 * <p>
	 * (NB: This class does not extend Deletable, since there is no need to assess whether it has
	 * been deleted.)
	 */
	void delete();
}
