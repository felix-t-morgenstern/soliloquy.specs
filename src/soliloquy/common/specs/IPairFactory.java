package soliloquy.common.specs;

/**
 * <b>PairFactory</b>
 * <p>
 * Generates a Pair, with a specific type for its two entries.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface IPairFactory extends ISoliloquyClass {
	/**
	 * Creates a Pair with the specified values.
	 * <i>This method assumes that both values are non-null. If one of the values must be null, use Make(T1, T2, T1, T2) to specify archetypes.</i>
	 * @param item1 - The first (non-null) value for the new Pair
	 * @param item2 - The second (non-null) value for the new Pair
	 * @return The newly created Pair
	 * @throws IllegalArgumentException If item1 or item2 are null
	 */
	<T1, T2> IPair<T1,T2> make(T1 item1, T2 item2) throws IllegalArgumentException;
	
	/**
	 * Creates a Pair with the specified values.
	 * (This method allows archetypes to be specified, so null values may be provided for the items in the Pair.)
	 * @param item1 - The first value for the new Pair
	 * @param item2 - The second value for the new Pair
	 * @param archetype1 - The archetype corresponding to the first value
	 * @param archetype2 - The archetype corresponding to the second value
	 * @return The newly created Pair
	 * @throws IllegalArgumentException If archetype1 or archetype2 are null
	 */
	<T1, T2> IPair<T1,T2> make(T1 item1, T2 item2, T1 archetype1, T2 archetype2) throws IllegalArgumentException;
}
