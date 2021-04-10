package soliloquy.specs.graphics.renderables;

/**
 * <b>GlobalLoopingAnimationRenderable</b>
 * <p>
 * An Animation which can be rendered in the window. <i>This Renderable will continue looping
 * through the same Animation, and its intended use case is to be shared among many Renderables
 * using the same underlying {@link soliloquy.specs.graphics.assets.Animation}, e.g. all torches or
 * lampposts in a {@link soliloquy.specs.gamestate.entities.GameZone}.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface GlobalLoopingAnimationRenderable extends RenderableWithArea {
    /**
     * NB: The intended use of this method is to have a single, looping RenderableAnimation
     * supporting many different GlobalLoopingAnimationRenderables; for instance, all torches or
     * lampposts might share the same looping animation, and this method enables all of them to
     * indirectly point back to a single {@link soliloquy.specs.graphics.assets.Animation}.
     * @return The underlying RenderableAnimation supporting this Renderable.
     */
    RenderableAnimation loopingAnimation();
}
