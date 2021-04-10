package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.assets.AnimationFrameSnippet;

/**
 * <b>RenderableAnimation</b>
 * <p>
 * An Animation which can be rendered, as either a {@link FiniteAnimationRenderable}, or as a
 * {@link GlobalLoopingAnimationRenderable}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RenderableAnimation {
    /**
     * @param timestamp The timestamp for which to obtain the snippet
     * @return The snippet (frame) of the underlying Animation at the current timestamp
     * @throws IllegalArgumentException If and only if timestamp is before the most recent
     * timestamp at which a snippet was requested, or a pause or unpause was reported
     */
    AnimationFrameSnippet currentSnippet(long timestamp) throws IllegalArgumentException;

    /**
     * @param timestamp The time at which the pause has begun
     * @throws IllegalArgumentException If and only if timestamp is before the most recent
     * timestamp at which a snippet was requested, or a pause or unpause was reported; or, if this
     * object was already paused
     */
    void reportPause(long timestamp) throws IllegalArgumentException;

    /**
     * @param timestamp The time at which the pause has ended
     * @throws IllegalArgumentException If and only if timestamp is before the most recent
     * timestamp at which a snippet was requested, or a pause or unpause was reported; or, if this
     * object was already paused
     */
    void reportUnpause(long timestamp) throws IllegalArgumentException;
}
