package soliloquy.specs.common.valueobjects;

import java.util.Objects;

/**
 * <b>Pair</b>
 * <p>
 * A pair of two non-null entities, of two specified types
 *
 * @param <T1> The type of the first entity
 * @param <T2> The type of the second entity
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class Pair<T1, T2> {
    public final T1 FIRST;
    public final T2 SECOND;

    private Pair(T1 first, T2 second) {
        FIRST = first;
        SECOND = second;
    }

    public static <T1, T2> Pair<T1, T2> pairOf(T1 first, T2 second) {
        return new Pair<>(first, second);
    }

    public Pair<T1, T2> makeClone() {
        return new Pair<>(FIRST, SECOND);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIRST, SECOND);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pair p) {
            return Objects.equals(FIRST, p.FIRST) && Objects.equals(SECOND, p.SECOND);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("{%s,%s}", FIRST, SECOND);
    }
}
