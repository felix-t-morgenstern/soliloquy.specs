package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.ui.definitions.keyboard.KeyBindingDefinition;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

public class ComponentDefinition extends AbstractContentDefinition {
    public final AbstractProviderDefinition<FloatBox> DIMENSIONS_PROVIDER;
    public final AbstractContentDefinition[] CONTENT;

    public KeyBindingDefinition[] bindings;
    public Boolean blocksLowerBindings;

    private ComponentDefinition(
            int z,
            AbstractProviderDefinition<FloatBox> dimensProvider,
            AbstractContentDefinition... content
    ) {
        super(z);
        DIMENSIONS_PROVIDER = dimensProvider;
        CONTENT = content;
    }

    public static ComponentDefinition component(
            int z,
            AbstractProviderDefinition<FloatBox> dimensProvider,
            AbstractContentDefinition... content
    ) {
        return new ComponentDefinition(z, dimensProvider, content);
    }

    public ComponentDefinition withBindings(boolean blocksLowerBindings,
                                            KeyBindingDefinition... bindings) {
        this.bindings = bindings;
        this.blocksLowerBindings = blocksLowerBindings;

        return this;
    }
}
