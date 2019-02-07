package soliloquy.common.specs;

/**
 * <b>HasGenericParams</b>
 * <p>
 * Exposes the unparameterized name of the interface in question, so it can be combined with its parameters' names, to generate a parameterized interface name.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IHasGenericParams extends ISoliloquyClass {
	String getUnparameterizedInterfaceName();
}
