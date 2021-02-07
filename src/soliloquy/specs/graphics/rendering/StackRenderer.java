package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>StackRenderer</b>
 * <p>
 * This class renders the contents of the {@link RenderableStack}.
 * <p>
 * (NB: This class is separate from the FrameTimer, since this class is responsible for what
 * happens when a frame must be rendered, rather than determining when a frame should be rendered.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface StackRenderer extends SoliloquyClass {
	/**
	 * <i>NB: Higher z values will be rendered first.</i>
	 * Renders the contents of the {@link RenderableStack}.
	 */
	void render();
}
