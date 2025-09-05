package soliloquy.specs.io.graphics.renderables.factories;

import soliloquy.specs.io.graphics.renderables.Component;

import java.util.UUID;

/**
 * <b>ComponentFactory</b>
 * <p>
 * Creates {@link Component}s. (This factory is exceedingly straightforward, but it needs to be
 * exposed to other modules.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ComponentFactory {
    /**
     * @param uuid                The uuid of the Component
     * @param z                   The z-index of the Component
     * @param containingComponent The Component which contains the newly-created Component, may be
     *                            null
     * @return The newly-created Component
     * @throws IllegalArgumentException If and only if uuid is null
     */
    Component make(
            UUID uuid,
            int z,
            Component containingComponent
    ) throws IllegalArgumentException;
}
