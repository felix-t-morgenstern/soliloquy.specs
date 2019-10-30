package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>HasDescription</b>
 * <p>
 * This class has a description, which can be altered.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasDescription extends SoliloquyClass {
    /**
     * @return The description of this entity
     */
    String getDescription();

    /**
     * @param description - The description to set for this entity
     */
    void setDescription(String description);
}
