package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.shared.SoliloquyClass;

import java.util.function.Supplier;

/**
 * <b>CameraFactory</b>
 * <p>
 * This class exists so to mediate the bidirectional relationship between
 * {@link soliloquy.specs.gamestate.valueobjects.GameState} and {@link Camera}; Camera is a member
 * of GameState, and GameState needs to expose to Camera a way to obtain the current
 * {@link GameZone}, therefore this class exists to pass that Supplier onto Camera without exposing
 * a mutator on that class.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */

public interface CameraFactory extends SoliloquyClass {
    Camera make();
}
