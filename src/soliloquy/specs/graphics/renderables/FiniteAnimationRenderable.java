package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.rendering.RenderableStack;

/**
 * <b>FiniteAnimationRenderable</b>
 * <p>
 * An Animation which can be rendered in the window. <i>This Renderable will determine when its
 * Animation has finished by determining when its next requested frame is beyond its underlying
 * Animation's {@link soliloquy.specs.graphics.assets.Animation#msDuration}, and when it is, it
 * will inform its containing {@link soliloquy.specs.graphics.rendering.RenderableStack} to remove
 * it.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface FiniteAnimationRenderable extends RenderableAnimation, RenderableWithArea {
}
