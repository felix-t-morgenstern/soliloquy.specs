package soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.io.graphics.assets.Animation;
import soliloquy.specs.io.graphics.assets.AnimationFrameSnippet;
import soliloquy.specs.io.graphics.rendering.renderers.Renderer;

import java.util.Map;

/**
 * <b>SpriteDefinition</b>
 * <p>
 * This class defines an {@link Animation}, to be created by the corresponding
 * {@link soliloquy.specs.io.graphics.bootstrap.assetfactories.AssetFactory}.
 * <p>
 * It is intended for this interface to be implemented anonymously at runtime.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class AnimationDefinition extends AssetDefinition<Animation> {
    private final int MS_DURATION;
    private final Map<Integer, AnimationFrameSnippet> FRAME_SNIPPET_DEFINITIONS;

    public AnimationDefinition(String id,
                               int msDuration,
                               Map<Integer, AnimationFrameSnippet> frameSnippetDefinitions) {
        super(id);
        MS_DURATION = msDuration;
        FRAME_SNIPPET_DEFINITIONS = frameSnippetDefinitions;
    }

    /**
     * @return The total duration of the Animation in milliseconds
     */
    public int msDuration() {
        return MS_DURATION;
    }

    /**
     * This Map is set up so that each frame snippet at a given int key is rendered starting at
     * that int key's millisecond position, until the millisecond position of another frame is
     * encountered by the {@link Renderer} for Animations (the AnimationRenderer).
     * NB: There must be at least one frame snippet definition for 0ms, and no map keys may be less
     * than 0 or greater than the duration of the Animation in milliseconds.
     *
     * @return A Map, where the key is the position in milliseconds in which the frame snippet
     *         first occurs.
     */
    public Map<Integer, AnimationFrameSnippet> frameSnippetDefinitions() {
        return FRAME_SNIPPET_DEFINITIONS;
    }
}
