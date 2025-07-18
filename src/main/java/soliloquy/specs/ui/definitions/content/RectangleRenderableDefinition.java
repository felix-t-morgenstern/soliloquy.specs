package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;

import static soliloquy.specs.ui.definitions.providers.StaticProviderDefinition.staticVal;

public class RectangleRenderableDefinition extends AbstractContentDefinition {
    public final AbstractProviderDefinition<FloatBox> AREA_PROVIDER;

    public AbstractProviderDefinition<Color> topLeftColorProvider;
    public AbstractProviderDefinition<Color> topRightColorProvider;
    public AbstractProviderDefinition<Color> bottomLeftColorProvider;
    public AbstractProviderDefinition<Color> bottomRightColorProvider;

    public AbstractProviderDefinition<Integer> textureIdProvider;
    public AbstractProviderDefinition<Float> textureTileWidthProvider;
    public AbstractProviderDefinition<Float> textureTileHeightProvider;

    public Map<Integer, String> onPressIds;
    public Map<Integer, String> onReleaseIds;
    public String onMouseOverId;
    public String onMouseLeaveId;

    private RectangleRenderableDefinition(AbstractProviderDefinition<FloatBox> areaProvider,
                                          int z) {
        super(z);
        AREA_PROVIDER = areaProvider;
    }

    public static RectangleRenderableDefinition rectangle(
            AbstractProviderDefinition<FloatBox> areaProvider, int z) {
        return new RectangleRenderableDefinition(areaProvider, z);
    }

    public RectangleRenderableDefinition withColor(Color color) {
        topLeftColorProvider = topRightColorProvider =
                bottomLeftColorProvider = bottomRightColorProvider = staticVal(color);

        return this;
    }

    public RectangleRenderableDefinition withColors(AbstractProviderDefinition<Color> topLeft,
                                                    AbstractProviderDefinition<Color> topRight,
                                                    AbstractProviderDefinition<Color> bottomLeft,
                                                    AbstractProviderDefinition<Color> bottomRight) {
        topLeftColorProvider = topLeft;
        topRightColorProvider = topRight;
        bottomLeftColorProvider = bottomLeft;
        bottomRightColorProvider = bottomRight;

        return this;
    }

    public RectangleRenderableDefinition withTexture(int textureId) {
        textureIdProvider = staticVal(textureId);
        textureTileWidthProvider = textureTileHeightProvider = staticVal(1f);

        return this;
    }

    public RectangleRenderableDefinition withTexture(
            AbstractProviderDefinition<Integer> textureIdProvider,
            AbstractProviderDefinition<Float> tileWidthProvider,
            AbstractProviderDefinition<Float> tileHeightProvider) {
        this.textureIdProvider = textureIdProvider;
        textureTileWidthProvider = tileWidthProvider;
        textureTileHeightProvider = tileHeightProvider;

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
