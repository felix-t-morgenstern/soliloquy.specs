package soliloquy.common.specs;

/**
 * <b>HasPluralName</b>
 * <p>
 * Has a pluralized name (e.g. "Iron Broadswords"), which can be obtained and set
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IHasPluralName extends ISoliloquyClass {
	/**
	 * @return the pluralized name of the entity
	 */
	String getPluralName();
	
	/**
	 * @param pluralName - the pluralized name to set for this entity
	 * @throws IllegalArgumentException If the pluralName provided is null
	 * <p>
	 * <i>If the pluralName provided is a blank string, it is strongly encouraged to throw an
	 * IllegalArgumentException, or to report a warning in the Logger.</i>
	 */
	void setPluralName(String pluralName) throws IllegalArgumentException;
}
