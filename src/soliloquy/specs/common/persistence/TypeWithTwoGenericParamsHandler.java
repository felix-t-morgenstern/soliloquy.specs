package soliloquy.specs.common.persistence;

import soliloquy.specs.common.shared.HasTwoGenericParams;

/**
 * <b>TypeHandler</b>
 * <p>
 * This class is a {@link TypeHandler} for a type that {@link HasTwoGenericParams}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <T> The type with one generic parameter handled by this class
 */
@SuppressWarnings("rawtypes")
public interface TypeWithTwoGenericParamsHandler<T extends HasTwoGenericParams>
        extends TypeHandler<T> {
    /**
     * NB: The value returned must be cast to a generic instance since Java does not permit
     * functions to declare the inner type of T, even though it is a type with a generic parameter.
     * @param innerType1 A String representation of the first archetype to generate, fully
     *                   qualified with generic parameters, e.g.
     *                  "soliloquy.specs.common.infrastructure.List&lt;java.lang.Integer&gt;"
     * @param innerType2 A string representation of the second archetype to generate
     * @return An archetype of type T, with all children archetypes provided as needed
     * @throws IllegalArgumentException If and only if innerType1 or innerType2 are null, empty, do
     * not correspond to a proper type, or doe not parse correctly (e.g. in the case where
     * innerType1 or innerType2 has generic parameters).
     */
    T generateArchetype(String innerType1, String innerType2) throws IllegalArgumentException;
}
