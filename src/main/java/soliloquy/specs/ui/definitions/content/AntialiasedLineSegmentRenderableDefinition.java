package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;

public class AntialiasedLineSegmentRenderableDefinition
        extends AbstractLineSegmentRenderableDefinition {
    public final AbstractProviderDefinition<Float> THICKNESS_GRADIENT_PERCENT_PROVIDER;
    public final AbstractProviderDefinition<Float> LENGTH_GRADIENT_PERCENT_PROVIDER;

    private AntialiasedLineSegmentRenderableDefinition(
            AbstractProviderDefinition<Vertex> vertex1Provider,
            AbstractProviderDefinition<Vertex> vertex2Provider,
            AbstractProviderDefinition<Float> thicknessProvider,
            AbstractProviderDefinition<Color> colorProvider,
            AbstractProviderDefinition<Float> thicknessGradientPercentProvider,
            AbstractProviderDefinition<Float> lengthGradientPercentProvider,
            int z) {
        super(vertex1Provider, vertex2Provider, thicknessProvider, colorProvider, z);
        THICKNESS_GRADIENT_PERCENT_PROVIDER = thicknessGradientPercentProvider;
        LENGTH_GRADIENT_PERCENT_PROVIDER = lengthGradientPercentProvider;
    }

    public static AntialiasedLineSegmentRenderableDefinition antialiasedLine(
            AbstractProviderDefinition<Vertex> vertex1Provider,
            AbstractProviderDefinition<Vertex> vertex2Provider,
            AbstractProviderDefinition<Float> thicknessProvider,
            AbstractProviderDefinition<Color> colorProvider,
            AbstractProviderDefinition<Float> thicknessGradientPercentProvider,
            AbstractProviderDefinition<Float> lengthGradientPercentProvider,
            int z
    ) {
        return new AntialiasedLineSegmentRenderableDefinition(vertex1Provider, vertex2Provider,
                thicknessProvider, colorProvider, thicknessGradientPercentProvider,
                lengthGradientPercentProvider, z);
    }
}
