package soliloquy.specs.common.shared;

import java.util.UUID;

/**
 * <b>HasUuid</b>
 * <p>
 * Specifies a class which has an UUID.
 * <p>
 * <i>(For reference, see:
 * <a href="https://en.wikipedia.org/wiki/Universally_unique_identifier">https://en.wikipedia.org/wiki/Universally_unique_identifier</a>)</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasUuid {
    /**
     * (NB: This method does not throw an exception when called on
     * {@link soliloquy.specs.gamestate.entities.Deletable} entities which have been deleted.)
     *
     * @return This entity's ID
     */
    UUID uuid();
}
