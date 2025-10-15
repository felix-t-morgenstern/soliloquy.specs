package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;

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

    public AbstractProviderDefinition<Float> textureTileWidthProviderDef;
    public AbstractProviderDefinition<Float> textureTileHeightProviderDef;
    public ProviderAtTime<Float> textureTileWidthProvider;
    public ProviderAtTime<Float> textureTileHeightProvider;

    public Map<Integer, String> onPressIds;
    public Map<Integer, String> onReleaseIds;
    public String onMouseOverId;
    public String onMouseLeaveId;

    private RectangleRenderableDefinition(ProviderAtTime<FloatBox> dimensionsProvider,
                                          AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
                                          int z) {
        super(z);
        DIMENS_PROVIDER = dimensionsProvider;
        DIMENS_PROVIDER_DEF = dimensionsProviderDef;
    }

    public static RectangleRenderableDefinition rectangle(
            ProviderAtTime<FloatBox> dimensionsProvider,
            int z
    ) {
        return new RectangleRenderableDefinition(dimensionsProvider, null, z);
    }

    public static RectangleRenderableDefinition rectangle(
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            int z
    ) {
        return new RectangleRenderableDefinition(null, dimensionsProviderDef, z);
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

    public RectangleRenderableDefinition withTexture(int textureId) {
        textureIdProviderDef = staticVal(textureId);
        textureTileWidthProviderDef = textureTileHeightProviderDef = staticVal(1f);

        return this;
    }

    public RectangleRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProvider,
            AbstractProviderDefinition<Float> tileWidthProvider,
            AbstractProviderDefinition<Float> tileHeightProvider) {
        this.textureIdProviderDef = textureIdProvider;
        textureTileWidthProviderDef = tileWidthProvider;
        textureTileHeightProviderDef = tileHeightProvider;

        return this;
    }

    public RectangleRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProvider,
            float tileWidthProvider,
            float tileHeightProvider) {
        return this.withTexture(
                textureIdProvider,
                staticVal(tileWidthProvider),
                staticVal(tileHeightProvider)
        );
    }

    public RectangleRenderableDefinition withTexture(
            ProviderAtTime<Integer> textureIdProvider,
            float tileWidth,
            float tileHeight) {
        this.textureIdProvider = textureIdProvider;
        textureTileWidthProviderDef = staticVal(tileWidth);
        textureTileHeightProviderDef = staticVal(tileHeight);

        return this;
    }

    public RectangleRenderableDefinition withTexture(
            ProviderAtTime<Integer> textureIdProvider,
            ProviderAtTime<Float> tileWidthProvider,
            ProviderAtTime<Float> tileHeightProvider
    ) {
        this.textureIdProvider = textureIdProvider;
        this.textureTileWidthProvider = tileWidthProvider;
        this.textureTileHeightProvider = tileHeightProvider;

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
