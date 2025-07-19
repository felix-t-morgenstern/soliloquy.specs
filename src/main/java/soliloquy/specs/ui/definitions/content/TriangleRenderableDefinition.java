package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;

import static soliloquy.specs.ui.definitions.providers.StaticProviderDefinition.staticVal;

public class TriangleRenderableDefinition extends AbstractContentDefinition {
    public final AbstractProviderDefinition<Vertex> VERTEX_1_PROVIDER;
    public final AbstractProviderDefinition<Vertex> VERTEX_2_PROVIDER;
    public final AbstractProviderDefinition<Vertex> VERTEX_3_PROVIDER;

    public AbstractProviderDefinition<Color> vertex1ColorProvider;
    public AbstractProviderDefinition<Color> vertex2ColorProvider;
    public AbstractProviderDefinition<Color> vertex3ColorProvider;

    public AbstractProviderDefinition<Integer> textureIdProvider;
    public AbstractProviderDefinition<Float> textureTileWidthProvider;
    public AbstractProviderDefinition<Float> textureTileHeightProvider;

    public Map<Integer, String> onPressIds;
    public Map<Integer, String> onReleaseIds;
    public String onMouseOverId;
    public String onMouseLeaveId;

    private TriangleRenderableDefinition(AbstractProviderDefinition<Vertex> vertex1Provider,
                                         AbstractProviderDefinition<Vertex> vertex2Provider,
                                         AbstractProviderDefinition<Vertex> vertex3Provider,
                                         int z) {
        super(z);
        VERTEX_1_PROVIDER = vertex1Provider;
        VERTEX_2_PROVIDER = vertex2Provider;
        VERTEX_3_PROVIDER = vertex3Provider;
    }

    public static TriangleRenderableDefinition triangle(
            AbstractProviderDefinition<Vertex> vertex1Provider,
            AbstractProviderDefinition<Vertex> vertex2Provider,
            AbstractProviderDefinition<Vertex> vertex3Provider,
            int z) {
        return new TriangleRenderableDefinition(vertex1Provider, vertex2Provider, vertex3Provider,
                z);
    }

    public TriangleRenderableDefinition withColor(Color color) {
        vertex1ColorProvider = vertex2ColorProvider = vertex3ColorProvider = staticVal(color);

        return this;
    }

    public TriangleRenderableDefinition withColors(
            AbstractProviderDefinition<Color> vertex1ColorProvider,
            AbstractProviderDefinition<Color> vertex2ColorProvider,
            AbstractProviderDefinition<Color> vertex3ColorProvider) {
        this.vertex1ColorProvider = vertex1ColorProvider;
        this.vertex2ColorProvider = vertex2ColorProvider;
        this.vertex3ColorProvider = vertex3ColorProvider;

        return this;
    }

    public TriangleRenderableDefinition withTexture(int textureId) {
        textureIdProvider = staticVal(textureId);
        textureTileWidthProvider = textureTileHeightProvider = staticVal(1f);

        return this;
    }

    public TriangleRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProvider,
            AbstractProviderDefinition<Float> tileWidthProvider,
            AbstractProviderDefinition<Float> tileHeightProvider) {
        this.textureIdProvider = textureIdProvider;
        textureTileWidthProvider = tileWidthProvider;
        textureTileHeightProvider = tileHeightProvider;

        return this;
    }

    public TriangleRenderableDefinition onPress(Map<Integer, String> onPressIds) {
        this.onPressIds = onPressIds;

        return this;
    }

    public TriangleRenderableDefinition onRelease(Map<Integer, String> onReleaseIds) {
        this.onReleaseIds = onReleaseIds;

        return this;
    }

    public TriangleRenderableDefinition onMouseOver(String onMouseOverId) {
        this.onMouseOverId = onMouseOverId;

        return this;
    }

    public TriangleRenderableDefinition onMouseLeave(String onMouseLeaveId) {
        this.onMouseLeaveId = onMouseLeaveId;

        return this;
    }
}
