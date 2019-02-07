package soliloquy.common.specs;

/**
 * <b>HasUuid</b>
 * <p>
 * Specifies a class which has an UUID.
 * <p>
 * <i>(For reference, see: <a href="https://en.wikipedia.org/wiki/Universally_unique_identifier">https://en.wikipedia.org/wiki/Universally_unique_identifier</a>)</i>
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IHasUuid extends ISoliloquyClass {
	/**
	 * @return This entity's UUID
	 * @throws UnsupportedOperationException If this entity has been deleted, or if the UUID has not been initialized
	 */
	IEntityUuid uuid() throws UnsupportedOperationException;
	
	/**
	 * @param uuid - The UUID to initialize for this entity
	 * @throws IllegalArgumentException
	 * @throws UnsupportedOperationException
	 */
	void initializeUuid(IEntityUuid uuid) throws IllegalArgumentException, UnsupportedOperationException;
}
