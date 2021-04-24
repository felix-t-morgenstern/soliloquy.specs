package soliloquy.specs.graphics.assets;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>Sprite</b>
 * <p>
 * This class defines an object which can be used to generate a {@link ProviderAtTime} of
 * {@link AnimationFrameSnippet}s for one of the two types of Animation Renderables,
 * {@link soliloquy.specs.graphics.renderables.GlobalLoopingAnimationRenderable} or
 * {@link soliloquy.specs.graphics.renderables.FiniteAnimationRenderable}, at some location in the
 * window. It is defined by an Image; a total duration in milliseconds; and for each millisecond
 * within that range, it provides top-left and bottom-right boundaries (inclusive) for the desired
 * frame of the Animation, and an offset in pixels for the Animation. (The pixel offset can be
 * measured in pixels here, since if the Animation is expanded or shrunk by some scale when
 * rendered, the offset in pixels will undergo the same transformation.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Animation extends ImageAsset {
    /**
     * @return The total duration (inclusive) of the Animation in milliseconds
     */
    int msDuration();

    /**
     * @param msPosition The position, in milliseconds, of this Animation
     * @return A definition of the Animation at msPosition
     * @throws IllegalArgumentException If and only if msPosition is less than zero or greater than
     * the total duration of the Animation
     */
    AnimationFrameSnippet snippetAtFrame(int msPosition) throws IllegalArgumentException;
}
