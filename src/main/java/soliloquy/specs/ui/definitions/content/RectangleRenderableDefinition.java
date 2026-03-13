package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static soliloquy.specs.ui.definitions.providers.StaticProviderDefinition.staticVal;

public class RectangleRenderableDefinition extends AbstractContentDefinition {
    public final ProviderAtTime<FloatBox> DIMENS_PROVIDER;
    public final AbstractProviderDefinition<FloatBox> DIMENS_PROVIDER_DEF;

    public ProviderAtTime<Color> topLeftColorProvider;
    public ProviderAtTime<Color> topRightColorProvider;
    public ProviderAtTime<Color> bottomLeftColorProvider;
    public ProviderAtTime<Color> bottomRightColorProvider;
    public AbstractProviderDefinition<Color> topLeftColorProviderDef;
    public AbstractProviderDefinition<Color> topRightColorProviderDef;
    public AbstractProviderDefinition<Color> bottomLeftColorProviderDef;
    public AbstractProviderDefinition<Color> bottomRightColorProviderDef;

    public AbstractProviderDefinition<Integer> textureIdProviderDef;
    public ProviderAtTime<Integer> textureIdProvider;

    public AbstractProviderDefinition<Float> textureTilesPerWidthProviderDef;
    public ProviderAtTime<Float> textureTilesPerWidthProvider;

    public AbstractProviderDefinition<Float> textureXOffsetProviderDef;
    public ProviderAtTime<Float> textureXOffsetProvider;

    public AbstractProviderDefinition<Float> textureTilesPerHeightProviderDef;
    public ProviderAtTime<Float> textureTilesPerHeightProvider;

    public AbstractProviderDefinition<Float> textureYOffsetProviderDef;
    public ProviderAtTime<Float> textureYOffsetProvider;

    public Map<Integer, String> onPressIds;
    public Map<Integer, String> onReleaseIds;
    public String onMouseOverId;
    public String onMouseLeaveId;

    private RectangleRenderableDefinition(ProviderAtTime<FloatBox> dimensionsProvider,
                                          AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
                                          int z,
                                          UUID uuid) {
        super(z, uuid);
        DIMENS_PROVIDER = dimensionsProvider;
        DIMENS_PROVIDER_DEF = dimensionsProviderDef;
    }

    public static RectangleRenderableDefinition rectangle(
            ProviderAtTime<FloatBox> dimensionsProvider,
            int z,
            UUID uuid
    ) {
        return new RectangleRenderableDefinition(dimensionsProvider, null, z, uuid);
    }

    public static RectangleRenderableDefinition rectangle(
            ProviderAtTime<FloatBox> dimensionsProvider,
            int z
    ) {
        return rectangle(dimensionsProvider, z, randomUUID());
    }

    public static RectangleRenderableDefinition rectangle(
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            int z,
            UUID uuid
    ) {
        return new RectangleRenderableDefinition(null, dimensionsProviderDef, z, uuid);
    }

    public static RectangleRenderableDefinition rectangle(
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            int z
    ) {
        return rectangle(dimensionsProviderDef, z, randomUUID());
    }

    public static RectangleRenderableDefinition rectangle(
            FloatBox dimensions,
            int z
    ) {
        return rectangle(staticVal(dimensions), z);
    }

    public RectangleRenderableDefinition withColor(Color color) {
        topLeftColorProviderDef = topRightColorProviderDef =
                bottomLeftColorProviderDef = bottomRightColorProviderDef = staticVal(color);

        return this;
    }

    public RectangleRenderableDefinition withColors(AbstractProviderDefinition<Color> topLeft,
                                                    AbstractProviderDefinition<Color> topRight,
                                                    AbstractProviderDefinition<Color> bottomLeft,
                                                    AbstractProviderDefinition<Color> bottomRight) {
        topLeftColorProviderDef = topLeft;
        topRightColorProviderDef = topRight;
        bottomLeftColorProviderDef = bottomLeft;
        bottomRightColorProviderDef = bottomRight;

        return this;
    }

    public RectangleRenderableDefinition withColor(ProviderAtTime<Color> color) {
        topLeftColorProvider = topRightColorProvider =
                bottomLeftColorProvider = bottomRightColorProvider = color;

        return this;
    }

    public RectangleRenderableDefinition withColors(ProviderAtTime<Color> topLeft,
                                                    ProviderAtTime<Color> topRight,
                                                    ProviderAtTime<Color> bottomLeft,
                                                    ProviderAtTime<Color> bottomRight) {
        topLeftColorProvider = topLeft;
        topRightColorProvider = topRight;
        bottomLeftColorProvider = bottomLeft;
        bottomRightColorProvider = bottomRight;

        return this;
    }

    public RectangleRenderableDefinition withTexture(ProviderAtTime<Integer> textureIdProvider) {
        this.textureIdProvider = textureIdProvider;
        textureTilesPerWidthProviderDef = textureTilesPerHeightProviderDef = staticVal(1f);
        textureXOffsetProviderDef = textureYOffsetProviderDef = staticVal(0f);

        return this;
    }

    public RectangleRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProviderDef
    ) {
        this.textureIdProviderDef = textureIdProviderDef;
        textureTilesPerWidthProviderDef = textureTilesPerHeightProviderDef = staticVal(1f);
        textureXOffsetProviderDef = textureYOffsetProviderDef = staticVal(0f);

        return this;
    }

    public RectangleRenderableDefinition withTexture(int textureId) {
        return withTexture(staticVal(textureId));
    }

    public RectangleRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProviderDef,
            AbstractProviderDefinition<Float> textureTilesPerWidthProviderDef,
            AbstractProviderDefinition<Float> textureXOffsetProviderDef,
            AbstractProviderDefinition<Float> textureTilesPerHeightProviderDef,
            AbstractProviderDefinition<Float> textureYOffsetProviderDef) {
        this.textureIdProviderDef = textureIdProviderDef;
        this.textureTilesPerWidthProviderDef = textureTilesPerWidthProviderDef;
        this.textureTilesPerHeightProviderDef = textureTilesPerHeightProviderDef;
        this.textureXOffsetProviderDef = textureXOffsetProviderDef;
        this.textureYOffsetProviderDef = textureYOffsetProviderDef;

        return this;
    }

    public RectangleRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProviderDef,
            AbstractProviderDefinition<Float> textureTilesPerWidthProviderDef,
            AbstractProviderDefinition<Float> textureTilesPerHeightProviderDef) {
        this.textureIdProviderDef = textureIdProviderDef;
        this.textureTilesPerWidthProviderDef = textureTilesPerWidthProviderDef;
        this.textureTilesPerHeightProviderDef = textureTilesPerHeightProviderDef;

        return this;
    }

    public RectangleRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProvider,
            float tilesPerWidth,
            float tilesPerHeight) {
        return this.withTexture(
                textureIdProvider,
                staticVal(tilesPerWidth),
                staticVal(tilesPerHeight)
        );
    }

    public RectangleRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProvider,
            float tilesPerWidth,
            float xOffset,
            float tilesPerHeight,
            float yOffset) {
        return this.withTexture(
                textureIdProvider,
                staticVal(tilesPerWidth),
                staticVal(xOffset),
                staticVal(tilesPerHeight),
                staticVal(yOffset)
        );
    }

    public RectangleRenderableDefinition withTexture(
            ProviderAtTime<Integer> textureIdProvider,
            float tileWidth,
            float tileHeight) {
        this.textureIdProvider = textureIdProvider;
        textureTilesPerWidthProviderDef = staticVal(tileWidth);
        textureTilesPerHeightProviderDef = staticVal(tileHeight);

        return this;
    }

    public RectangleRenderableDefinition withTexture(
            ProviderAtTime<Integer> textureIdProvider,
            float tilesPerWidth,
            float xOffset,
            float tilesPerHeight,
            float yOffset) {
        this.textureIdProvider = textureIdProvider;
        textureTilesPerWidthProviderDef = staticVal(tilesPerWidth);
        textureXOffsetProviderDef = staticVal(xOffset);
        textureTilesPerHeightProviderDef = staticVal(tilesPerHeight);
        textureYOffsetProviderDef = staticVal(yOffset);

        return this;
    }

    public RectangleRenderableDefinition withTexture(
            ProviderAtTime<Integer> textureIdProvider,
            ProviderAtTime<Float> tilesPerWidthProvider,
            ProviderAtTime<Float> textureXOffsetProvider,
            ProviderAtTime<Float> tilesPerHeightProvider,
            ProviderAtTime<Float> textureYOffsetProvider
    ) {
        this.textureIdProvider = textureIdProvider;
        this.textureTilesPerWidthProvider = tilesPerWidthProvider;
        this.textureXOffsetProvider = textureXOffsetProvider;
        this.textureTilesPerHeightProvider = tilesPerHeightProvider;
        this.textureYOffsetProvider = textureYOffsetProvider;

        return this;
    }

    public RectangleRenderableDefinition withTexture(
            ProviderAtTime<Integer> textureIdProvider,
            ProviderAtTime<Float> tileWidthProvider,
            ProviderAtTime<Float> tileHeightProvider
    ) {
        this.textureIdProvider = textureIdProvider;
        this.textureTilesPerWidthProvider = tileWidthProvider;
        this.textureTilesPerHeightProvider = tileHeightProvider;

        return this;
    }

    public RectangleRenderableDefinition onPress(Map<Integer, String> onPressIds) {
        this.onPressIds = onPressIds;

        return this;
    }

    public RectangleRenderableDefinition onRelease(Map<Integer, String> onReleaseIds) {
        this.onReleaseIds = onReleaseIds;

        return this;
    }

    public RectangleRenderableDefinition onMouseOver(String onMouseOverId) {
        this.onMouseOverId = onMouseOverId;

        return this;
    }

    public RectangleRenderableDefinition onMouseLeave(String onMouseLeaveId) {
        this.onMouseLeaveId = onMouseLeaveId;

        return this;
    }
}
