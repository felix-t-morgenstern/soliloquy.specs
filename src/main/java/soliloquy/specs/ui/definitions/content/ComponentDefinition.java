package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.keyboard.KeyBindingDefinition;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.util.*;

import static java.util.UUID.randomUUID;
import static soliloquy.specs.ui.definitions.providers.StaticProviderDefinition.staticVal;

public class ComponentDefinition extends AbstractContentDefinition {
    public final AbstractProviderDefinition<FloatBox> DIMENSIONS_PROVIDER_DEF;
    public final ProviderAtTime<FloatBox> DIMENSIONS_PROVIDER;
    public final Set<AbstractContentDefinition> CONTENT;

    public KeyBindingDefinition[] bindings;
    public Boolean blocksLowerBindings;
    public Integer keyBindingPriority;
    public Map<String, Object> data;

    private ComponentDefinition(
            int z,
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            ProviderAtTime<FloatBox> dimensionsProvider,
            Set<AbstractContentDefinition> content,
            UUID uuid
    ) {
        super(z, uuid);
        DIMENSIONS_PROVIDER_DEF = dimensionsProviderDef;
        DIMENSIONS_PROVIDER = dimensionsProvider;
        CONTENT = content;
    }

    public static ComponentDefinition component(int z) {
        return component(z, new HashSet<>());
    }

    public static ComponentDefinition component(
            int z,
            Set<AbstractContentDefinition> content,
            UUID uuid
    ) {
        return new ComponentDefinition(z, null, null, content, uuid);
    }

    public static ComponentDefinition component(
            int z,
            Set<AbstractContentDefinition> content
    ) {
        return component(z, content, randomUUID());
    }

    public static ComponentDefinition component(
            int z,
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            UUID uuid
    ) {
        return new ComponentDefinition(z, dimensionsProviderDef, null, new HashSet<>(), uuid);
    }

    public static ComponentDefinition component(
            int z,
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef
    ) {
        return component(z, dimensionsProviderDef, randomUUID());
    }

    public static ComponentDefinition component(
            int z,
            ProviderAtTime<FloatBox> dimensionsProvider,
            UUID uuid
    ) {
        return new ComponentDefinition(z, null, dimensionsProvider, new HashSet<>(), uuid);
    }

    public static ComponentDefinition component(
            int z,
            ProviderAtTime<FloatBox> dimensionsProvider
    ) {
        return component(z, dimensionsProvider, randomUUID());
    }

    public static ComponentDefinition component(
            int z,
            AbstractProviderDefinition<FloatBox> dimensProviderDef,
            Set<AbstractContentDefinition> content,
            UUID uuid
    ) {
        return new ComponentDefinition(z, dimensProviderDef, null, content, uuid);
    }

    public static ComponentDefinition component(
            int z,
            AbstractProviderDefinition<FloatBox> dimensProviderDef,
            Set<AbstractContentDefinition> content
    ) {
        return component(z, dimensProviderDef, content, randomUUID());
    }

    public static ComponentDefinition component(
            int z,
            FloatBox dimens,
            Set<AbstractContentDefinition> content,
            UUID uuid
    ) {
        return new ComponentDefinition(z, staticVal(dimens), null, content, uuid);
    }

    public static ComponentDefinition component(
            int z,
            FloatBox dimens,
            Set<AbstractContentDefinition> content
    ) {
        return component(z, dimens, content, randomUUID());
    }

    public static ComponentDefinition component(
            int z,
            ProviderAtTime<FloatBox> dimensProvider,
            Set<AbstractContentDefinition> content,
            UUID uuid
    ) {
        return new ComponentDefinition(z, null, dimensProvider, content, uuid);
    }

    public static ComponentDefinition component(
            int z,
            ProviderAtTime<FloatBox> dimensProvider,
            Set<AbstractContentDefinition> content
    ) {
        return component(z, dimensProvider, content, randomUUID());
    }

    public ComponentDefinition withContent(AbstractContentDefinition... content) {
        CONTENT.addAll(Arrays.stream(content).toList());

        return this;
    }

    public ComponentDefinition withContent(Collection<AbstractContentDefinition> content) {
        CONTENT.addAll(content);

        return this;
    }

    public ComponentDefinition withBindings(boolean blocksLowerBindings,
                                            int keyBindingPriority,
                                            KeyBindingDefinition... bindings) {
        this.bindings = bindings;
        this.blocksLowerBindings = blocksLowerBindings;
        this.keyBindingPriority = keyBindingPriority;

        return this;
    }

    public ComponentDefinition withData(Map<String, Object> data) {
        this.data = data;

        return this;
    }
}
