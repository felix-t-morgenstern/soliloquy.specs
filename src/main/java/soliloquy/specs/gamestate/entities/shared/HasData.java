package soliloquy.specs.gamestate.entities.shared;

import java.util.Map;

/**
 * <b>HasData</b>
 * <p>
 * This class has a store of dynamic state data.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasData {
    /**
     * @return Any parameters regarding this entity which do not fit neatly into any of their other
     *         properties.
     * @throws IllegalStateException If this Item has been deleted
     */
    Map<String, Object> data() throws IllegalStateException;
}
