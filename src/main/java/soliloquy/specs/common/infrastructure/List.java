package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.shared.Cloneable;
import soliloquy.specs.common.shared.HasOneGenericParam;

/**
 * <b>List</b>
 * <p>
 * A grouping of some entities.
 * <p>
 * Items can be added to it.
 * <p>
 * It can be cleared.
 * <p>
 * It can be asked whether it has a specific item.
 * <p>
 * It can be asked whether it is empty.
 * <p>
 * It can be converted into an array.
 * <p>
 * It can be asked how many items it has.
 * <p>
 * Items can be removed from it.
 *
 * @param <V> The type of entities in this List
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface List<V> extends java.util.List<V>, Cloneable<List<V>>, HasOneGenericParam<V> {
}
