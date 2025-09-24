package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.ui.definitions.keyboard.KeyBindingDefinition;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.util.Map;

import static soliloquy.specs.ui.definitions.providers.StaticProviderDefinition.staticVal;

public class ComponentDefinition extends AbstractContentDefinition {
    public final AbstractProviderDefinition<FloatBox> DIMENSIONS_PROVIDER;
    public final AbstractContentDefinition[] CONTENT;

    public KeyBindingDefinition[] bindings;
    public Boolean blocksLowerBindings;
    public Map<String, Object> data;

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

    public static ComponentDefinition component(
            int z,
            FloatBox dimens,
            AbstractContentDefinition... content
    ) {
        return new ComponentDefinition(z, staticVal(dimens), content);
    }

    public ComponentDefinition withBindings(boolean blocksLowerBindings,
                                            KeyBindingDefinition... bindings) {
        this.bindings = bindings;
        this.blocksLowerBindings = blocksLowerBindings;

        return this;
    }

    public ComponentDefinition withData(Map<String, Object> data) {
        this.data = data;

        return this;
    }
}
