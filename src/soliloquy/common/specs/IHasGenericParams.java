package soliloquy.common.specs;

/**
 * <b>HasGenericParams</b>
 * <p>
 * This is an interface which allows classes with generic parameters (e.g. Collection&lt;V&gt;) to write their class name to a String, <i>with</i> their generic types intact, e.g. "Collection&lt;String&gt;".
 * <p>
 * This is intended so that PersistentValuesHandler can assign incoming classes with generic types to the correct repository, i.e. Collections of Strings will not be stored alongside Collections of Integers.
 * 
 * @author felix.t.morgenstern
 *
 */
public interface IHasGenericParams {
	/**
	 * <b><i>Recommended usage is to describe the interface of the class; e.g., Collection should describe itself as an ICollection.
	 * @return A String representation of this class, with a specification of generic parameters. (So, an ICollection of Strings would have its class rendered as &quot;soliloquy.common.specs.ICollection&lt;java.lang.String&gt;&quot;.)
	 */
	String getParameterizedClassName();
}
