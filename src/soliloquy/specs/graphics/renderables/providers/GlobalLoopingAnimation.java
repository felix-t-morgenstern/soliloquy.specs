package soliloquy.specs.graphics.renderables.providers;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.valueobjects.EntityUuid;
import soliloquy.specs.graphics.assets.AnimationFrameSnippet;

public interface GlobalLoopingAnimation extends LoopingProvider<AnimationFrameSnippet>, HasId {
    /**
     * @return True, if and only if the underlying
     * {@link soliloquy.specs.graphics.assets.Animation} supports mouse events
     */
    boolean supportsMouseEvents();

    /**
     * @return The id of the Animation over which to loop
     */
    String animationId();

    /**
     * This method is not supported for GlobalLoopingAnimation, since it will only be created when
     * the game is loading, it should never be deleted, and it can be adequately saved by only
     * exposing {@link #id()}.
     * @return Nothing (c.f. throws)
     * @throws UnsupportedOperationException Every time this class is called
     */
    EntityUuid uuid() throws UnsupportedOperationException;
}
