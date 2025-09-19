package soliloquy.specs.io.graphics.renderables.providers;

import soliloquy.specs.gamestate.entities.shared.HasData;

import java.util.Map;

/**
 * <b>FunctionalProvider</b>
 * <p>
 * This class provides values based on a {@link soliloquy.specs.common.entities.Function} fed into
 * it. Optionally, {@link soliloquy.specs.common.entities.Action}s can also dictate pause and
 * unpause behavior.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FunctionalProvider<T> extends ProviderAtTime<T>, HasData {
    record EventInfo(long timestamp, Long pauseTimestamp, Map<String, Object> data) {
    }

    record Representation(String provideId, String pauseId, String unpauseId, Long pauseTimestamp,
                          Map<String, Object> data) {
    }
}
