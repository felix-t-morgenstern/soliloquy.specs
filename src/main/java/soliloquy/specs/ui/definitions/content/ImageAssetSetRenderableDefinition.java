package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.io.graphics.renderables.colorshifting.ColorShift;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class ImageAssetSetRenderableDefinition extends AbstractContentDefinition {
    public final String IMAGE_ASSET_SET_ID;
    public final Map<String, String> DISPLAY_PARAMS;

    public AbstractProviderDefinition<Float> borderThicknessProvider;
    public AbstractProviderDefinition<Color> borderColorProvider;
    public Map<Integer, String> onPressIds;
    public Map<Integer, String> onReleaseIds;
    public String onMouseOverId;
    public String onMouseLeaveId;
    public List<AbstractProviderDefinition<ColorShift>> colorShiftProviders;

    private ImageAssetSetRenderableDefinition(String imageAssetSetId,
                                              Map<String, String> displayParams, int z) {
        super(z);
        IMAGE_ASSET_SET_ID = imageAssetSetId;
        DISPLAY_PARAMS = displayParams;
    }

    public static ImageAssetSetRenderableDefinition imageAssetSet(String imageAssetSetId,
                                                                  Map<String, String> displayParams,
                                                                  int z) {
        return new ImageAssetSetRenderableDefinition(imageAssetSetId, displayParams, z);
    }

    public ImageAssetSetRenderableDefinition withBorder(
            AbstractProviderDefinition<Float> thicknessProvider,
            AbstractProviderDefinition<Color> colorProvider) {
        borderThicknessProvider = thicknessProvider;
        borderColorProvider = colorProvider;

        return this;
    }

    public ImageAssetSetRenderableDefinition onPress(Map<Integer, String> onPressIds) {
        this.onPressIds = onPressIds;

        return this;
    }

    public ImageAssetSetRenderableDefinition onRelease(Map<Integer, String> onReleaseIds) {
        this.onReleaseIds = onReleaseIds;

        return this;
    }

    public ImageAssetSetRenderableDefinition onMouseOver(String onMouseOverId) {
        this.onMouseOverId = onMouseOverId;

        return this;
    }

    public ImageAssetSetRenderableDefinition onMouseLeave(String onMouseLeaveId) {
        this.onMouseLeaveId = onMouseLeaveId;

        return this;
    }

    public ImageAssetSetRenderableDefinition colorShifts(
            List<AbstractProviderDefinition<ColorShift>> colorShiftProviders) {
        this.colorShiftProviders = colorShiftProviders;

        return this;
    }
}
