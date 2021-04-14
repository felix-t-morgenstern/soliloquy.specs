package soliloquy.specs.graphics.renderables;

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
    /**
     * (NB: This method will return higher values each time this Renderable is paused and later
     * unpaused; the purpose of this method is to ensure that there is no call to
     * {@link #currentSnippet} before the start of this finite animation.)
     * @return The timestamp at which the finite animation began
     */
    long startTimestamp();

    /**
     * (NB: This method will return higher values each time this Renderable is paused and later
     * unpaused; the purpose of this method is to ensure that there is no call to
     * {@link #currentSnippet} after the end of this finite animation.)
     * @return The timestamp at which the finite animation began
     */
    long endTimestamp();
}
