package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.shared.Cloneable;
import soliloquy.specs.common.shared.HasTwoGenericParams;

/**
 * <b>Map</b>
 * <p>
 * A Map contains a number of items of a consistent type, with keys of a consistent type.
 * <p>
 * A Map will allow retrieval of an item by its key, a list of all keys, the key corresponding to
 * an item, whether that item exists, etc.
 *
 * @param <K> The type of key used to identify values in the Set
 * @param <V> The type of value populating the Set
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Map<K, V>
        extends java.util.Map<K, V>, Cloneable<Map<K, V>>, HasTwoGenericParams<K, V> {
}
