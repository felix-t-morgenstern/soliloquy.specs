package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static soliloquy.specs.ui.definitions.providers.StaticProviderDefinition.staticVal;

public class TriangleRenderableDefinition extends AbstractContentDefinition {
    public final AbstractProviderDefinition<Vertex> VERTEX_1_PROVIDER_DEF;
    public final AbstractProviderDefinition<Vertex> VERTEX_2_PROVIDER_DEF;
    public final AbstractProviderDefinition<Vertex> VERTEX_3_PROVIDER_DEF;

    public final ProviderAtTime<Vertex> VERTEX_1_PROVIDER;
    public final ProviderAtTime<Vertex> VERTEX_2_PROVIDER;
    public final ProviderAtTime<Vertex> VERTEX_3_PROVIDER;

    public AbstractProviderDefinition<Color> vertex1ColorProviderDef;
    public AbstractProviderDefinition<Color> vertex2ColorProviderDef;
    public AbstractProviderDefinition<Color> vertex3ColorProviderDef;

    public ProviderAtTime<Color> vertex1ColorProvider;
    public ProviderAtTime<Color> vertex2ColorProvider;
    public ProviderAtTime<Color> vertex3ColorProvider;

    public AbstractProviderDefinition<Integer> textureIdProvider;
    public AbstractProviderDefinition<Float> textureTileWidthProvider;
    public AbstractProviderDefinition<Float> textureTileHeightProvider;

    public Map<Integer, String> onPressIds;
    public Map<Integer, String> onReleaseIds;
    public String onMouseOverId;
    public String onMouseLeaveId;

    private TriangleRenderableDefinition(AbstractProviderDefinition<Vertex> vertex1ProviderDef,
                                         AbstractProviderDefinition<Vertex> vertex2ProviderDef,
                                         AbstractProviderDefinition<Vertex> vertex3ProviderDef,
                                         int z,
                                         UUID uuid) {
        super(z, uuid);

        VERTEX_1_PROVIDER_DEF = vertex1ProviderDef;
        VERTEX_2_PROVIDER_DEF = vertex2ProviderDef;
        VERTEX_3_PROVIDER_DEF = vertex3ProviderDef;

        VERTEX_1_PROVIDER = null;
        VERTEX_2_PROVIDER = null;
        VERTEX_3_PROVIDER = null;
    }

    private TriangleRenderableDefinition(ProviderAtTime<Vertex> vertex1Provider,
                                         ProviderAtTime<Vertex> vertex2Provider,
                                         ProviderAtTime<Vertex> vertex3Provider,
                                         int z,
                                         UUID uuid) {
        super(z, uuid);

        VERTEX_1_PROVIDER_DEF = null;
        VERTEX_2_PROVIDER_DEF = null;
        VERTEX_3_PROVIDER_DEF = null;

        VERTEX_1_PROVIDER = vertex1Provider;
        VERTEX_2_PROVIDER = vertex2Provider;
        VERTEX_3_PROVIDER = vertex3Provider;
    }

    public static TriangleRenderableDefinition triangle(
            AbstractProviderDefinition<Vertex> vertex1ProviderDef,
            AbstractProviderDefinition<Vertex> vertex2ProviderDef,
            AbstractProviderDefinition<Vertex> vertex3ProviderDef,
            int z,
            UUID uuid) {
        return new TriangleRenderableDefinition(vertex1ProviderDef, vertex2ProviderDef,
                vertex3ProviderDef,
                z, uuid);
    }

    public static TriangleRenderableDefinition triangle(
            AbstractProviderDefinition<Vertex> vertex1ProviderDef,
            AbstractProviderDefinition<Vertex> vertex2ProviderDef,
            AbstractProviderDefinition<Vertex> vertex3ProviderDef,
            int z) {
        return triangle(vertex1ProviderDef, vertex2ProviderDef, vertex3ProviderDef, z,
                randomUUID());
    }

    public static TriangleRenderableDefinition triangle(Vertex vertex1,
                                                        Vertex vertex2,
                                                        Vertex vertex3,
                                                        int z) {
        return triangle(staticVal(vertex1), staticVal(vertex2), staticVal(vertex3), z);
    }

    public static TriangleRenderableDefinition triangle(
            ProviderAtTime<Vertex> vertex1Provider,
            ProviderAtTime<Vertex> vertex2Provider,
            ProviderAtTime<Vertex> vertex3Provider,
            int z,
            UUID uuid) {
        return new TriangleRenderableDefinition(vertex1Provider, vertex2Provider, vertex3Provider,
                z, uuid);
    }

    public static TriangleRenderableDefinition triangle(
            ProviderAtTime<Vertex> vertex1Provider,
            ProviderAtTime<Vertex> vertex2Provider,
            ProviderAtTime<Vertex> vertex3Provider,
            int z) {
        return triangle(vertex1Provider, vertex2Provider, vertex3Provider, z, randomUUID());
    }

    public TriangleRenderableDefinition withColor(Color color) {
        vertex1ColorProviderDef =
                vertex2ColorProviderDef =
                        vertex3ColorProviderDef = staticVal(color);

        return this;
    }

    public TriangleRenderableDefinition withColors(
            AbstractProviderDefinition<Color> vertex1ColorProviderDef,
            AbstractProviderDefinition<Color> vertex2ColorProviderDef,
            AbstractProviderDefinition<Color> vertex3ColorProviderDef) {
        this.vertex1ColorProviderDef = vertex1ColorProviderDef;
        this.vertex2ColorProviderDef = vertex2ColorProviderDef;
        this.vertex3ColorProviderDef = vertex3ColorProviderDef;

        return this;
    }

    public TriangleRenderableDefinition withColors(
            ProviderAtTime<Color> vertex1ColorProvider,
            ProviderAtTime<Color> vertex2ColorProvider,
            ProviderAtTime<Color> vertex3ColorProvider) {
        this.vertex1ColorProvider = vertex1ColorProvider;
        this.vertex2ColorProvider = vertex2ColorProvider;
        this.vertex3ColorProvider = vertex3ColorProvider;

        return this;
    }

    public TriangleRenderableDefinition withColor(ProviderAtTime<Color> color) {
        vertex1ColorProvider = vertex2ColorProvider = vertex3ColorProvider = color;

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
