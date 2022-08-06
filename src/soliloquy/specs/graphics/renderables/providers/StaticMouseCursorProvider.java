package soliloquy.specs.graphics.renderables.providers;

import soliloquy.specs.common.shared.HasId;

import java.util.UUID;

/**
 * <b>StaticMouseCursorProvider</b>
 * <p>
 * This class supports a static (i.e. non-animated) mouse cursor.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface StaticMouseCursorProvider extends StaticProvider<Long>, HasId {
    /**
     * StaticMouseCursorProviders are not identified by Uuid, but rather by their String Ids.
     */
    @Override
    UUID uuid() throws UnsupportedOperationException;
}
