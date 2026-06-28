package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static soliloquy.specs.ui.definitions.providers.StaticProviderDefinition.staticVal;

public class RectangleRenderableDefinition extends AbstractRenderableWithDimensionsDefinition {
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
    public String textureRelativeLoc;

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

    private RectangleRenderableDefinition(
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            int z,
            UUID uuid
    ) {
        super(dimensionsProviderDef, z, uuid);
    }

    private RectangleRenderableDefinition(
            ProviderAtTime<FloatBox> dimensionsProvider,
            int z,
            UUID uuid
    ) {
        super(dimensionsProvider, z, uuid);
    }

    /**
     * The no-arg method is intended for Component definitions, e.g. Button, where the dimensions
     * are stored on the Component level, and passed directly into this definition or its resulting
     * Renderable
     */
    public static RectangleRenderableDefinition rectangle() {
        return rectangle((FloatBox) null, 0);
    }

    public static RectangleRenderableDefinition rectangle(
            ProviderAtTime<FloatBox> dimensionsProvider,
            int z,
            UUID uuid
    ) {
        return new RectangleRenderableDefinition(dimensionsProvider, z, uuid);
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
        return new RectangleRenderableDefinition(dimensionsProviderDef, z, uuid);
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
                                                    AbstractProviderDefinition<Color> bottomRight,
                                                    AbstractProviderDefinition<Color> bottomLeft) {
        topLeftColorProviderDef = topLeft;
        topRightColorProviderDef = topRight;
        bottomRightColorProviderDef = bottomRight;
        bottomLeftColorProviderDef = bottomLeft;

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

    public RectangleRenderableDefinition withColors(Color topLeft,
                                                    Color topRight,
                                                    Color bottomLeft,
                                                    Color bottomRight) {
        topLeftColorProviderDef = staticVal(topLeft);
        topRightColorProviderDef = staticVal(topRight);
        bottomLeftColorProviderDef = staticVal(bottomLeft);
        bottomRightColorProviderDef = staticVal(bottomRight);

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
            String textureRelativeLoc
    ) {
        this.textureRelativeLoc = textureRelativeLoc;
        textureTilesPerWidthProviderDef = textureTilesPerHeightProviderDef = staticVal(1f);
        textureXOffsetProviderDef = textureYOffsetProviderDef = staticVal(0f);

        return this;
    }

    public RectangleRenderableDefinition withTextureTilingDefs(
            AbstractProviderDefinition<Float> textureTilesPerWidthProviderDef,
            AbstractProviderDefinition<Float> textureTilesPerHeightProviderDef) {
        this.textureTilesPerWidthProviderDef = textureTilesPerWidthProviderDef;
        this.textureTilesPerHeightProviderDef = textureTilesPerHeightProviderDef;

        return this;
    }

    public RectangleRenderableDefinition withTextureTiling(
            ProviderAtTime<Float> textureTilesPerWidthProvider,
            ProviderAtTime<Float> textureTilesPerHeightProvider) {
        this.textureTilesPerWidthProvider = textureTilesPerWidthProvider;
        this.textureTilesPerHeightProvider = textureTilesPerHeightProvider;

        return this;
    }

    public RectangleRenderableDefinition withTextureTiling(float tilesPerWidth,
                                                           float tilesPerHeight) {
        return this.withTextureTilingDefs(
                staticVal(tilesPerWidth),
                staticVal(tilesPerHeight)
        );
    }

    public RectangleRenderableDefinition withTextureTilingOffsetDefs(
            AbstractProviderDefinition<Float> textureXOffsetProviderDef,
            AbstractProviderDefinition<Float> textureYOffsetProviderDef
    ) {
        this.textureXOffsetProviderDef = textureXOffsetProviderDef;
        this.textureYOffsetProviderDef = textureYOffsetProviderDef;

        return this;
    }

    public RectangleRenderableDefinition withTextureTilingOffsets(
            ProviderAtTime<Float> textureXOffsetProvider,
            ProviderAtTime<Float> textureYOffsetProvider
    ) {
        this.textureXOffsetProvider = textureXOffsetProvider;
        this.textureYOffsetProvider = textureYOffsetProvider;

        return this;
    }

    public RectangleRenderableDefinition withTextureTilingOffsets(
            float textureXOffset,
            float textureYOffset
    ) {
        this.textureXOffsetProviderDef = staticVal(textureXOffset);
        this.textureYOffsetProviderDef = staticVal(textureYOffset);

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
