package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.shared.Cloneable;
import soliloquy.specs.common.shared.HasTwoGenericParams;

/**
 * <b>Pair</b>
 * <p>
 * A pair of two entities, of two specified types.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <T1> The type of the first entity
 * @param <T2> The type of the second entity
 */
public interface Pair<T1, T2> extends Cloneable<Pair<T1,T2>>, HasTwoGenericParams<T1, T2> {
	/**
	 * @return The first item
	 */
	T1 getItem1();

	/**
	 * @return The second item
	 */
	T2 getItem2();

	/**
	 * @param item - The value to which to set the first item
	 * @throws IllegalArgumentException If the item provided is an illegal value, e.g. null,
	 * out-of-range, invalid Id, etc.
	 */
	void setItem1(T1 item) throws IllegalArgumentException;
	
	/**
	 * @param item - The value to which to set the second item
	 * @throws IllegalArgumentException If the item provided is an illegal value, e.g. null,
	 * out-of-range, invalid Id, etc.
	 */
	void setItem2(T2 item) throws IllegalArgumentException;
}
