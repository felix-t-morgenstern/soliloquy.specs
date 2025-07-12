package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;

public class RasterizedLineSegmentRenderableDefinition
        extends AbstractLineSegmentRenderableDefinition {
    public short stipplePattern;
    public short stippleFactor;

    private RasterizedLineSegmentRenderableDefinition(
            AbstractProviderDefinition<Vertex> vertex1Provider,
            AbstractProviderDefinition<Vertex> vertex2Provider,
            AbstractProviderDefinition<Float> thicknessProvider,
            AbstractProviderDefinition<Color> colorProvider,
            int z) {
        super(vertex1Provider, vertex2Provider, thicknessProvider, colorProvider, z);
    }

    public static RasterizedLineSegmentRenderableDefinition rasterizedLineSegment(
            AbstractProviderDefinition<Vertex> vertex1Provider,
            AbstractProviderDefinition<Vertex> vertex2Provider,
            AbstractProviderDefinition<Float> thicknessProvider,
            AbstractProviderDefinition<Color> colorProvider,
            int z) {
        return new RasterizedLineSegmentRenderableDefinition(vertex1Provider, vertex2Provider,
                thicknessProvider, colorProvider, z);
    }

    public RasterizedLineSegmentRenderableDefinition withStipple(short pattern, short factor) {
        this.stipplePattern = pattern;
        this.stippleFactor = factor;

        return this;
    }
}
