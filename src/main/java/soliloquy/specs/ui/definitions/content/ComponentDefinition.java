package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.keyboard.KeyBindingDefinition;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static soliloquy.specs.ui.definitions.providers.StaticProviderDefinition.staticVal;

public class ComponentDefinition extends AbstractContentDefinition {
    public final AbstractProviderDefinition<FloatBox> DIMENSIONS_PROVIDER_DEF;
    public final ProviderAtTime<FloatBox> DIMENSIONS_PROVIDER;
    public final Set<AbstractContentDefinition> CONTENT;

    public KeyBindingDefinition[] bindings;
    public Boolean blocksLowerBindings;
    public Map<String, Object> data;

    private ComponentDefinition(
            int z,
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            ProviderAtTime<FloatBox> dimensionsProvider,
            Set<AbstractContentDefinition> content
    ) {
        super(z);
        DIMENSIONS_PROVIDER_DEF = dimensionsProviderDef;
        DIMENSIONS_PROVIDER = dimensionsProvider;
        CONTENT = content;
    }

    public static ComponentDefinition component(int z) {
        return component(z, new HashSet<>());
    }

    public static ComponentDefinition component(
            int z,
            Set<AbstractContentDefinition> content
    ) {
        return new ComponentDefinition(z, null, null, content);
    }

    public static ComponentDefinition component(
            int z,
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef
    ) {
        return new ComponentDefinition(z, dimensionsProviderDef, null, new HashSet<>());
    }

    public static ComponentDefinition component(
            int z,
            ProviderAtTime<FloatBox> dimensionsProvider
    ) {
        return new ComponentDefinition(z, null, dimensionsProvider, new HashSet<>());
    }

    public static ComponentDefinition component(
            int z,
            AbstractProviderDefinition<FloatBox> dimensProviderDef,
            Set<AbstractContentDefinition> content
    ) {
        return new ComponentDefinition(z, dimensProviderDef, null, content);
    }

    public static ComponentDefinition component(
            int z,
            FloatBox dimens,
            Set<AbstractContentDefinition> content
    ) {
        return new ComponentDefinition(z, staticVal(dimens), null, content);
    }

    public static ComponentDefinition component(
            int z,
            ProviderAtTime<FloatBox> dimensProvider,
            Set<AbstractContentDefinition> content
    ) {
        return new ComponentDefinition(z, null, dimensProvider, content);
    }

    public ComponentDefinition withContent(AbstractContentDefinition... content) {
        CONTENT.addAll(Arrays.stream(content).toList());

        return this;
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
