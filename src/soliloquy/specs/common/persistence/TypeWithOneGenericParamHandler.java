package soliloquy.specs.common.persistence;

import soliloquy.specs.common.shared.HasOneGenericParam;

/**
 * <b>TypeHandler</b>
 * <p>
 * This class is a {@link TypeHandler} for a type that {@link HasOneGenericParam}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <T> The type with one generic parameter handled by this class
 */
@SuppressWarnings("rawtypes")
public interface TypeWithOneGenericParamHandler<T extends HasOneGenericParam>
        extends TypeHandler<T> {
    /**
     * NB: The value returned must be cast to a generic instance since Java does not permit
     * functions to declare the inner type of T, even though it is a type with a generic parameter.
     * @param innerType A String representation of the archetype to generate, fully qualified with
     *                  generic parameters, e.g.
     *                  "soliloquy.specs.common.infrastructure.List&lt;java.lang.Integer&gt;"
     * @return An archetype of type T, with all children archetypes provided as needed
     * @throws IllegalArgumentException If and only if innerType is null or empty
     */
    T generateArchetype(String innerType) throws IllegalArgumentException;
}
