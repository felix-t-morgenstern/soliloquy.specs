package soliloquy.common.specs;

/**
 * <b>HasNameId</b>
 * <p>
 * It has a String Id, which must be initialized, before it can be accessed. It can only be initialized once.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IHasId {
	//TODO: Consider whether this is necessary at all
	/**
	 * @param id The value to which to initialize the Id
	 * @throws IllegalArgumentException If the Id is illegal, e.g. if it is already in use, if it is a blank String, if it is null, etc.
	 * @throws UnsupportedOperationException If and only if the Id has already been initialized
	 */
	void initializeId(String id) throws IllegalArgumentException, UnsupportedOperationException;

	/**
	 * @return The Id of this entity
	 */
	String id();
}
