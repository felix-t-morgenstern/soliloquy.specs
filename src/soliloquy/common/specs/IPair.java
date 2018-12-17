package soliloquy.common.specs;

/**
 * <b>Pair</b>
 * <p>
 * A pair of two entities, of two specified types.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <I1> The type of the first entity
 * @param <I2> The type of the second entity
 */
public interface IPair<I1,I2> extends IHasTwoGenericParams<I1,I2> {
	/**
	 * @return The first item
	 */
	I1 getItem1();
	
	/**
	 * @param item - The value to which to set the first item
	 * @throws IllegalArgumentException If the item provided is an illegal value, e.g. null, out-of-range, invalid Id, etc.
	 */
	void setItem1(I1 item) throws IllegalArgumentException;
	
	/**
	 * @return The second item
	 */
	I2 getItem2();
	
	/**
	 * @param item - The value to which to set the second item
	 * @throws IllegalArgumentException If the item provided is an illegal value, e.g. null, out-of-range, invalid Id, etc.
	 */
	void setItem2(I2 item) throws IllegalArgumentException;
}
