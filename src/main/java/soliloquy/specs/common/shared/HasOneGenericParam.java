package soliloquy.specs.common.shared;

/**
 * <b>HasOneGenericParam</b>
 * <p>
 * This interface exists for classes which have one generic parameter.
 * <p>
 * <i>Intended use is for making sure that classes are stored properly in GenericParamsSets, or
 * written properly to file as Persistent Variables. The generic type of this interface is intended
 * to always match the generic type of whatever object implements this class.</i>
 * <p>
 * <i>For classes implementing this interface, it is expected that the implementing classes will
 * accept the archetype in their constructors.</i>
 *
 * @param <P1> The type parameter corresponding to the single generic type argument provided to the
 *             class implementing this interface
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasOneGenericParam<P1> extends SoliloquyClass {
    /**
     * @return The archetype provided to this class (to describe its generic parameter type)
     */
    P1 archetype();
}
