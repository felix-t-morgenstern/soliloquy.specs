package soliloquy.common.specs;

/**
 * <b>HasId</b>
 * <p>
 * It has a String Id, to be initialized behind-the-scenes, before it can be accessed.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IHasId extends ISoliloquyClass {
	/**
	 * @return The Id of this entity
	 * @throws IllegalStateException if and only if the Id is blank or null
	 */
	String id() throws IllegalStateException;
}
