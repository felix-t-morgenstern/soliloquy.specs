package soliloquy.specs.ruleset.entities;

/**
 * <b>HasDescription</b>
 * <p>
 * This class has a description which can be changed during the course of the game
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasDescription {
    /**
     * @return The description of this entity
     */
    String getDescription();

    /**
     * @param description The description to set for this entity
     * @throws IllegalArgumentException If and only if description is null or empty
     */
    void setDescription(String description) throws IllegalArgumentException;
}
