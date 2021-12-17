package soliloquy.specs.common.shared;

/**
 * <b>HasTwoGenericParams</b>
 * <p>
 * This interface exists for classes which have two generic parameters.
 * <p>
 * <i>Intended use is for making sure that classes are stored properly in GenericParamsSets, or
 * written properly to file as Persistent Variables. The generic types of this interface are
 * intended to always match the generic type of whatever object implements this class.</i>
 * <p>
 * <i>For classes implementing this interface, it is expected that the implementing classes will
 * accept the archetypes in their constructors.</i>
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <T1> The type parameter corresponding to the first generic type argument provided to the
 * class implementing this interface
 * @param <T2> The type parameter corresponding to the second generic type argument provided to the
 * class implementing this interface
 */
public interface HasTwoGenericParams<T1, T2> extends SoliloquyClass {
	/**
	 * @return The first archetype
	 */
	T1 getFirstArchetype() throws IllegalStateException;
	
	/**
	 * @return The second archetype
	 */
	T2 getSecondArchetype() throws IllegalStateException;
}
