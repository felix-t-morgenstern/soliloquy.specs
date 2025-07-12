package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;

public class AbstractLineSegmentRenderableDefinition extends AbstractContentDefinition {
    public final AbstractProviderDefinition<Vertex> VERTEX_1_PROVIDER;
    public final AbstractProviderDefinition<Vertex> VERTEX_2_PROVIDER;
    public final AbstractProviderDefinition<Float> THICKNESS_PROVIDER;
    public final AbstractProviderDefinition<Color> COLOR_PROVIDER;

    protected AbstractLineSegmentRenderableDefinition(
            AbstractProviderDefinition<Vertex> vertex1Provider,
            AbstractProviderDefinition<Vertex> vertex2Provider,
            AbstractProviderDefinition<Float> thicknessProvider,
            AbstractProviderDefinition<Color> colorProvider,
            int z) {
        super(z);
        VERTEX_1_PROVIDER = vertex1Provider;
        VERTEX_2_PROVIDER = vertex2Provider;
        THICKNESS_PROVIDER = thicknessProvider;
        COLOR_PROVIDER = colorProvider;
    }
}
