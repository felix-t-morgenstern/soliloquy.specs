package soliloquy.specs.ui.definitions.content;

import java.util.Set;

public class AbstractComponentDefinition {
//    public final String TYPE;
//    public final int Z;

    public Set<AbstractContentDefinition> content;

    public AbstractComponentDefinition withContent(Set<AbstractContentDefinition> content) {
        this.content = content;

        return this;
    }
}
