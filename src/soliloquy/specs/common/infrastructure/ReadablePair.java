package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.shared.HasTwoGenericParams;

/**
 * <b>ReadablePair</b>
 * <p>
 * A read-only pair of two entities, of two specified types.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <T1> The type of the first entity
 * @param <T2> The type of the second entity
 */
public interface ReadablePair<T1, T2> extends HasTwoGenericParams<T1, T2> {
    /**
     * @return The first item
     */
    T1 getItem1();

    /**
     * @return The second item
     */
    T2 getItem2();
}
