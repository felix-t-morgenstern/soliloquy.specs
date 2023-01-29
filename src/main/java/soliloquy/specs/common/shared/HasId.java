package soliloquy.specs.common.shared;

/**
 * <b>HasId</b>
 * <p>
 * It has a String Id.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasId extends SoliloquyClass {
    /**
     * @return The Id of this entity
     * @throws IllegalStateException if and only if the Id is blank or null
     */
    String id() throws IllegalStateException;
}
