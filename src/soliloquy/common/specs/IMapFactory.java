package soliloquy.common.specs;

/**
 * <b>MapFactory</b>
 * <p>
 * Generates a Map, with a specific key and value. May receive params, relating to the behavior of the created Map.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface IMapFactory {
	/**
	 * @param archetype1 A dummy value of the first type
	 * @param archetype2 A dummy value of the second type
	 * @return A new Map, with the specified types for its Key and Value
	 */
	<K, V> IMap<K,V> make(K archetype1, V archetype2);
}
