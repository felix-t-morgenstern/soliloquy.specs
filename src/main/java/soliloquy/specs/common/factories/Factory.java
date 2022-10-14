package soliloquy.specs.common.factories;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>Factory</b>
 * <p>
 * This is a class which takes a definition for an object of some type, and outputs an object of that type.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <TDefinition> The type of the definition used to create objects
 * @param <TOutput> The type created
 */
public interface Factory<TDefinition, TOutput> extends SoliloquyClass {
    /**
     * @param definition The definition to create the object
     * @return The created object
     * @throws IllegalArgumentException If definition is null, or if required fields are not provided or are invalid
     */
    TOutput make(TDefinition definition) throws IllegalArgumentException;
}
