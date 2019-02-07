package soliloquy.common.specs;

/**
 * <b>HasName</b>
 * <p>
 * Has a name, which can be obtained, and changed
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IHasName extends ISoliloquyClass {
	/**
	 * @return The name of the entity
	 */
	String getName();
	
	/**
	 * Sets the name of the entity
	 * @param name - the name to which to set the entity
	 */
	void setName(String name);
}
