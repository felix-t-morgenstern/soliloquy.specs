package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.ImmutableMap;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;

/**
 * <b>Setting</b>
 * <p>
 * This is a Setting (e.g. for the Game, for graphics, for audio, etc.)
 *
 * @param <T> The type of this Setting
 * @author felix.t.morgenstern
 */
public interface Setting<T> extends HasId, HasName {
    /**
     * @return The current value of this Setting
     */
    T getValue();

    /**
     * @param value The value to which to set this Setting
     * @throws IllegalArgumentException If the value is illegal (e.g. out of range, empty, etc.)
     */
    void setValue(T value) throws IllegalArgumentException;

    /**
     * @return Parameters determining how the control for this setting appears in the UI (e.g.;
     *         whether it is a slider, a text field, etc.; whether it is hidden; etc.)
     */
    ImmutableMap<String, Object> controlParams();
}
