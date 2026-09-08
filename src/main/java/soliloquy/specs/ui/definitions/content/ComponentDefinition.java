package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.Renderable;
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
    public final Set<AbstractContentDefinition> CONTENT;
    public final Set<Renderable> PREREAD_CONTENT;

    public KeyBindingDefinition[] bindings;
    public Boolean blocksLowerBindings;
    public Integer keyBindingPriority;
    public AbstractProviderDefinition<FloatBox> renderingBoundariesProviderDef;
    public ProviderAtTime<FloatBox> renderingBoundariesProvider;
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
            Set<Renderable> prereadContent,
            UUID uuid
    ) {
        super(z, uuid);
        this.renderingBoundariesProviderDef = renderingBoundariesProviderDef;
        this.renderingBoundariesProvider = renderingBoundariesProvider;
        CONTENT = new HashSet<>();
        if (content != null) {
            CONTENT.addAll(content);
        }
        PREREAD_CONTENT = new HashSet<>();
        if (prereadContent != null) {
            PREREAD_CONTENT.addAll(prereadContent);
        }
    }

    public static ComponentDefinition component(int z) {
        return component(z, (UUID) null);
    }

    public static ComponentDefinition component(int z, UUID uuid) {
        return component(z, (Set<AbstractContentDefinition>) null, uuid);
    }

    public static ComponentDefinition component(
            int z,
            Set<AbstractContentDefinition> content,
            UUID uuid
    ) {
        return new ComponentDefinition(z, null, null, content, null, uuid);
    }

    public static ComponentDefinition component(
            int z,
            UUID uuid,
            Set<Renderable> prereadContent
    ) {
        return new ComponentDefinition(z, null, null, null, prereadContent, uuid);
    }

    public static ComponentDefinition component(
            int z,
            Set<AbstractContentDefinition> content
    ) {
        return component(z, content, randomUUID());
    }

    public static ComponentDefinition component(
            Set<Renderable> prereadContent,
            int z
    ) {
        return component(z, randomUUID(), prereadContent);
    }

    public static ComponentDefinition component(
            int z,
            AbstractProviderDefinition<FloatBox> renderingBoundariesProviderDef,
            UUID uuid
    ) {
        return new ComponentDefinition(z, renderingBoundariesProviderDef, null, null,
                null, uuid);
    }

    public static ComponentDefinition component(
            int z,
            AbstractProviderDefinition<FloatBox> renderingBoundariesProviderDef
    ) {
        return component(z, renderingBoundariesProviderDef, randomUUID());
    }

    public static ComponentDefinition component(
            int z,
            FloatBox renderingBoundaries
    ) {
        return component(z, staticVal(renderingBoundaries));
    }

    public static ComponentDefinition component(
            int z,
            ProviderAtTime<FloatBox> renderingBoundariesProvider,
            UUID uuid
    ) {
        return new ComponentDefinition(z, null, renderingBoundariesProvider, null,
                null, uuid);
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
        return new ComponentDefinition(z, dimensProviderDef, null, content, null, uuid);
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
        return new ComponentDefinition(z, staticVal(dimens), null, content, null, uuid);
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
        return new ComponentDefinition(z, null, dimensProvider, content, null, uuid);
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

    public ComponentDefinition withPrereadContent(Renderable... prereadContent) {
        PREREAD_CONTENT.addAll(Arrays.stream(prereadContent).toList());

        return this;
    }

    public ComponentDefinition withPrereadContent(Collection<Renderable> prereadContent) {
        PREREAD_CONTENT.addAll(prereadContent);

        return this;
    }

    public ComponentDefinition withKeyBindings(boolean blocksLowerBindings,
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
        if (this.data == null) {
            this.data = data;
        }
        else {
            this.data.putAll(data);
        }

        return this;
    }
}
