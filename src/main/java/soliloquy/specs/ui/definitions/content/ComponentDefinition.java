package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.ui.definitions.keyboard.KeyBindingDefinition;

public class ComponentDefinition {
    public final AbstractContentDefinition[] CONTENT;

    public KeyBindingDefinition[] bindings;
    public Boolean blocksLowerBindings;

    private ComponentDefinition(AbstractContentDefinition... content) {
        CONTENT = content;
    }

    public static ComponentDefinition component(AbstractContentDefinition... content) {
        return new ComponentDefinition(content);
    }

    public ComponentDefinition withBindings(boolean blocksLowerBindings,
                                            KeyBindingDefinition... bindings) {
        this.bindings = bindings;
        this.blocksLowerBindings = blocksLowerBindings;

        return this;
    }
}
