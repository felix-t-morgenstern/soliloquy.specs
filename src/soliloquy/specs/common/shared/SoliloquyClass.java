package soliloquy.specs.common.shared;

import soliloquy.specs.common.persistence.TypeHandler;

/**
 * <b>SoliloquyClass</b>
 * <p>
 * This class is defined within the soliloquy namespace, and therefore can be asked to expose a
 * type-qualified class name, e.g. "{@link soliloquy.specs.common.infrastructure.List}<
 * {@link soliloquy.specs.gamestate.entities.Character}>". At present, Java does not expose the
 * generic type parameters of a class, so Soliloquy classes must expose this information
 * themselves, to be fed to the correct
 * {@link TypeHandler} when the type of a class
 * is not known in advance, e.g. {@link soliloquy.specs.common.infrastructure.Setting}s or items in
 * the {@link soliloquy.specs.common.infrastructure.VariableCache}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface SoliloquyClass {
    /**
     * <b>If this class has any type parameters, those parameters should be included, in the proper
     * order, within angle brackets, just as they do in the class definition.</b>
     *
     * @return The name of the interface of this class.
     */
    String getInterfaceName();
}
