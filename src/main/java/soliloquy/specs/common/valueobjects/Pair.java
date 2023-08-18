package soliloquy.specs.common.valueobjects;

import soliloquy.specs.common.shared.Cloneable;
import soliloquy.specs.common.shared.HasTwoGenericParams;

/**
 * <b>Pair</b>
 * <p>
 * A pair of two non-null entities, of two specified types.
 * <p>
 * <i>NB: This class is implemented concretely rather than described as an interface, since it has
 * negligible logic, and keeping it as an interface with a corresponding factory is highly
 * unwieldy.</i>
 *
 * @param <T1> The type of the first entity
 * @param <T2> The type of the second entity
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Pair<T1, T2> extends Cloneable<Pair<T1, T2>>, HasTwoGenericParams<T1, T2> {
    /**
     * @return The first item
     */
    T1 item1();

    /**
     * @return The second item
     */
    T2 item2();
}
