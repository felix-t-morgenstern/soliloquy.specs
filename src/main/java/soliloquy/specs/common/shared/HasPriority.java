package soliloquy.specs.common.shared;

/**
 * <b>HasId</b>
 * <p>
 * It has a priority for being fired.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasPriority {
    /**
     * @return The priority for this entity, with higher value implying higher priority; when
     *         multiple entities are fired, events with higher priority are fired first. (If
     *         multiple entities have the same priority, no assurances are made as to which will
     *         fire first!)
     */
    int priority();
}
