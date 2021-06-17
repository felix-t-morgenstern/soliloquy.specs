package soliloquy.specs.graphics.renderables.providers;

import soliloquy.specs.graphics.assets.AnimationFrameSnippet;

public interface GlobalLoopingAnimation extends LoopingProvider<AnimationFrameSnippet> {
    /**
     * @return True, if and only if the underlying
     * {@link soliloquy.specs.graphics.assets.Animation} supports mouse events
     */
    boolean supportsMouseEvents();

    /**
     * @return The id of the Animation over which to loop
     */
    String animationId();
}
