package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.util.UUID;

public abstract class AbstractRenderableWithDimensionsDefinition
        extends AbstractRenderableWithMouseEventsDefinition {
    public ProviderAtTime<FloatBox> dimensProvider;
    public AbstractProviderDefinition<FloatBox> dimensProviderDef;

    protected AbstractRenderableWithDimensionsDefinition(
            AbstractProviderDefinition<FloatBox> dimensProviderDef,
            int z,
            UUID uuid
    ) {
        super(z, uuid);
        this.dimensProviderDef = dimensProviderDef;
    }

    protected AbstractRenderableWithDimensionsDefinition(
            ProviderAtTime<FloatBox> dimensProvider,
            int z,
            UUID uuid
    ) {
        super(z, uuid);
        this.dimensProvider = dimensProvider;
    }
}
