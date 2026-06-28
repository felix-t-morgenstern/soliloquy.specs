package soliloquy.specs.ui.definitions.content;

import java.util.UUID;

/**
 * <b>ContentDefinition</b>
 * <p>
 * This interface defines members of {@link ComponentDefinition#CONTENT}
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public abstract class AbstractContentDefinition {
    public final UUID UUID;

    public int z;

    protected AbstractContentDefinition(int z, UUID uuid) {
        this.z = z;
        UUID = uuid;
    }
}
