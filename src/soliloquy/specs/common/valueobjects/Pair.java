package soliloquy.specs.common.valueobjects;

import soliloquy.specs.common.shared.Cloneable;
import soliloquy.specs.common.shared.HasTwoGenericParams;

/**
 * <b>Pair</b>
 * <p>
 * A pair of two entities, of two specified types.
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
public class Pair<T1, T2> implements Cloneable<Pair<T1, T2>>, HasTwoGenericParams<T1, T2> {
    private final T1 ITEM_1;
    private final T2 ITEM_2;

    private final T1 ARCHETYPE_1;
    private final T2 ARCHETYPE_2;

    public Pair(T1 item1, T2 item2) {
        if (item1 == null) {
            throw new IllegalArgumentException(
                    "Pair: item1 cannot be null if no archetypes are provided");
        }
        if (item2 == null) {
            throw new IllegalArgumentException(
                    "Pair: item2 cannot be null if no archetypes are provided");
        }

        ITEM_1 = item1;
        ITEM_2 = item2;

        ARCHETYPE_1 = item1;
        ARCHETYPE_2 = item2;
    }

    public Pair(T1 item1, T2 item2, T1 archetype1, T2 archetype2) {
        ITEM_1 = item1;
        ITEM_2 = item2;
        ARCHETYPE_1 = archetype1;
        ARCHETYPE_2 = archetype2;
    }

    /**
     * @return The first item
     */
    public T1 getItem1() {
        return ITEM_1;
    }

    /**
     * @return The second item
     */
    public T2 getItem2() {
        return ITEM_2;
    }

    @Override
    public Pair<T1, T2> makeClone() {
        return new Pair<>(ITEM_1, ITEM_2, ARCHETYPE_1, ARCHETYPE_2);
    }

    @Override
    public T1 getFirstArchetype() throws IllegalStateException {
        return ARCHETYPE_1;
    }

    @Override
    public T2 getSecondArchetype() throws IllegalStateException {
        return ARCHETYPE_2;
    }

    @Override
    public String getInterfaceName() {
        return Pair.class.getCanonicalName();
    }

    @SuppressWarnings("RedundantIfStatement")
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        //noinspection rawtypes
        Pair pair = (Pair) obj;

        if (ITEM_1 == null) {
            if (pair.getItem1() != null) {
                return false;
            }
        } else {
            if (!ITEM_1.equals(pair.getItem1())) {
                return false;
            }
        }

        if (ITEM_2 == null) {
            if (pair.getItem2() != null) {
                return false;
            }
        } else {
            if (!ITEM_2.equals(pair.getItem2())) {
                return false;
            }
        }

        return true;
    }
}
