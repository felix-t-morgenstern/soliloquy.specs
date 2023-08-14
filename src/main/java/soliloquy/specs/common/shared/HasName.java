package soliloquy.specs.common.shared;

/**
 * <b>HasName</b>
 * <p>
 * Has a name, which can be obtained, and changed
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasName extends SoliloquyClass {
    /**
     * @return The name of the entity
     */
    String getName();

    /**
     * Sets the name of the entity
     *
     * @param name the name to which to set the entity (can be null)
     */
    void setName(String name);
}
