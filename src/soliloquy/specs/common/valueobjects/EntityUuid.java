package soliloquy.specs.common.valueobjects;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>EntityUuid</b>
 * <p>
 * An UUID (Universally Unique Id) is a value that is assured to be unique to that entity,
 * regardless of what type of entity it is, or what Game it comes from.
 * <p>
 * It is intended to be used to identify entities, such as Characters or Items, so they can be
 * recognized by other Games.
 * <p>
 * <i>(For reference, see: <a href="https://en.wikipedia.org/wiki/Universally_unique_identifier">https://en.wikipedia.org/wiki/Universally_unique_identifier</a>)</i>
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface EntityUuid extends SoliloquyClass {
	/**
	 * @return The most significant bits of this UUID
	 */
	long getMostSignificantBits();
	
	/**
	 * @return The least significant bits of this UUID
	 */
	long getLeastSignificantBits();
	
	/**
	 * @return A String representation of this UUID
	 */
	String toString();
}
