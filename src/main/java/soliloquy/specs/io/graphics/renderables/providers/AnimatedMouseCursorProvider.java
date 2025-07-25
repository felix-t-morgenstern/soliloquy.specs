package soliloquy.specs.io.graphics.renderables.providers;

import soliloquy.specs.common.shared.HasId;

import java.util.UUID;

/**
 * <b>AnimatedMouseCursorProvider</b>
 * <p>
 * This class supports mouse cursor animations, and behaves much like
 * {@link soliloquy.specs.io.graphics.assets.Animation}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface AnimatedMouseCursorProvider extends ResettableProvider<Long>, HasId {
    /**
     * AnimatedMouseCursorProviders are not identified by Uuid, but rather by their String Ids.
     */
    @Override
    UUID uuid() throws UnsupportedOperationException;
}
