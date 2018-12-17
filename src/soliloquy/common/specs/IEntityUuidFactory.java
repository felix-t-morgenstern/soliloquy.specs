package soliloquy.common.specs;

/**
 * <b>EntityUuidFactory</b>
 * <p>
 * Creates EntityUuid, either from longs, a string, or randomly.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IEntityUuidFactory {
	/**
	 * Creates an EntityUuid from two longs
	 * @param mostSignificantBits - The first set of bits used to create this EntityUuid
	 * @param leastSignificantBits - The second set of bits used to create this EntityUuid
	 */
	IEntityUuid createFromLongs(long mostSignificantBits, long leastSignificantBits);

	/**
	 * @param uuidString - The string used to create this EntityUuid
	 * @throws IllegalArgumentException If uuidString is not a validly formatted UUID string
	 */
	IEntityUuid createFromString(String uuidString) throws IllegalArgumentException;

	/**
	 * Creates a new, random (and thus globally unique) EntityUuid
	 */
	void createRandomUuid();
}
