package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.keyboard.KeyBindingDefinition;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.util.*;

import static java.util.UUID.randomUUID;
import static soliloquy.specs.ui.definitions.providers.StaticProviderDefinition.staticVal;

/**
 * <b>ComponentDefinition</b>
 * <p>
 * Every method described here relates to properties on
 * {@link soliloquy.specs.io.graphics.renderables.Component}
 */
public class ComponentDefinition extends AbstractContentDefinition {
    public final AbstractProviderDefinition<FloatBox> RENDERING_BOUNDARIES_PROVIDER_DEF;
    public final ProviderAtTime<FloatBox> RENDERING_BOUNDARIES_PROVIDER;
    public final Set<AbstractContentDefinition> CONTENT;

    public KeyBindingDefinition[] bindings;
    public Boolean blocksLowerBindings;
    public Integer keyBindingPriority;
    public AbstractProviderDefinition<FloatBox> dimensionsProviderDef;
    public ProviderAtTime<FloatBox> dimensionsProvider;
    public String prerenderHookId;
    public String addHookId;
    public Map<String, Object> data;

    private ComponentDefinition(
            int z,
            AbstractProviderDefinition<FloatBox> renderingBoundariesProviderDef,
            ProviderAtTime<FloatBox> renderingBoundariesProvider,
            Set<AbstractContentDefinition> content,
            UUID uuid
    ) {
        super(z, uuid);
        RENDERING_BOUNDARIES_PROVIDER_DEF = renderingBoundariesProviderDef;
        RENDERING_BOUNDARIES_PROVIDER = renderingBoundariesProvider;
        CONTENT = content;
    }

    public static ComponentDefinition component(int z) {
        return component(z, new HashSet<>());
    }

    public static ComponentDefinition component(int z, UUID uuid) {
        return component(z, new HashSet<>(), uuid);
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
            AbstractProviderDefinition<FloatBox> renderingBoundariesProviderDef,
            UUID uuid
    ) {
        return new ComponentDefinition(z, renderingBoundariesProviderDef, null, new HashSet<>(),
                uuid);
    }

    public static ComponentDefinition component(
            int z,
            AbstractProviderDefinition<FloatBox> renderingBoundariesProviderDef
    ) {
        return component(z, renderingBoundariesProviderDef, randomUUID());
    }

    public static ComponentDefinition component(
            int z,
            ProviderAtTime<FloatBox> renderingBoundariesProvider,
            UUID uuid
    ) {
        return new ComponentDefinition(z, null, renderingBoundariesProvider, new HashSet<>(), uuid);
    }

    public static ComponentDefinition component(
            int z,
            ProviderAtTime<FloatBox> renderingBoundariesProvider
    ) {
        return component(z, renderingBoundariesProvider, randomUUID());
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

    public ComponentDefinition withDimensions(ProviderAtTime<FloatBox> dimensionsProvider) {
        this.dimensionsProvider = dimensionsProvider;

        return this;
    }

    public ComponentDefinition withDimensions(
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef) {
        this.dimensionsProviderDef = dimensionsProviderDef;

        return this;
    }

    public ComponentDefinition withDimensions(FloatBox dimensions) {
        this.dimensionsProviderDef = staticVal(dimensions);

        return this;
    }

    public ComponentDefinition withAddHook(String addHookId) {
        this.addHookId = addHookId;

        return this;
    }

    public ComponentDefinition withPrerenderHook(String prerenderHookId) {
        this.prerenderHookId = prerenderHookId;

        return this;
    }

    public ComponentDefinition withData(Map<String, Object> data) {
        this.data = data;

        return this;
    }
}
