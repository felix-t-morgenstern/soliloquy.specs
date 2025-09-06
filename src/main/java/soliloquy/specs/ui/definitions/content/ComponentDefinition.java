package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.ui.definitions.keyboard.KeyBindingDefinition;

public class ComponentDefinition extends AbstractContentDefinition {
    public final AbstractContentDefinition[] CONTENT;

    public KeyBindingDefinition[] bindings;
    public Boolean blocksLowerBindings;

    private ComponentDefinition(int z, AbstractContentDefinition... content) {
        super(z);
        CONTENT = content;
    }

    public static ComponentDefinition component(int z, AbstractContentDefinition... content) {
        return new ComponentDefinition(z, content);
    }

    public ComponentDefinition withBindings(boolean blocksLowerBindings,
                                            KeyBindingDefinition... bindings) {
        this.bindings = bindings;
        this.blocksLowerBindings = blocksLowerBindings;

        return this;
    }
}
