package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.colorshifting.ColorShift;
import soliloquy.specs.ui.definitions.colorshifting.ShiftDefinition;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;

public class ImageAssetSetRenderableDefinition extends AbstractImageAssetRenderableDefinition {
    public final String IMAGE_ASSET_SET_ID;
    public final Map<String, String> DISPLAY_PARAMS;

    private ImageAssetSetRenderableDefinition(String imageAssetSetId,
                                              Map<String, String> displayParams,
                                              AbstractProviderDefinition<FloatBox> dimensionsProvider,
                                              int z) {
        super(dimensionsProvider, z);
        IMAGE_ASSET_SET_ID = imageAssetSetId;
        DISPLAY_PARAMS = displayParams;
    }

    public static ImageAssetSetRenderableDefinition imageAssetSet(String imageAssetSetId,
                                                                  Map<String, String> displayParams,
                                                                  AbstractProviderDefinition<FloatBox> dimensionsProvider,
                                                                  int z) {
        return new ImageAssetSetRenderableDefinition(imageAssetSetId, displayParams,
                dimensionsProvider, z);
    }

    public ImageAssetSetRenderableDefinition withBorder(
            AbstractProviderDefinition<Float> thicknessProviderDef,
            AbstractProviderDefinition<Color> colorProviderDef) {
        borderThicknessProviderDef = thicknessProviderDef;
        borderColorProviderDef = colorProviderDef;

        return this;
    }

    public ImageAssetSetRenderableDefinition withColorShifts(ShiftDefinition... shiftDefinitions) {
        this.colorShiftDefs = shiftDefinitions;

        return this;
    }

    public ImageAssetSetRenderableDefinition withColorShifts(ColorShift... shifts) {
        this.colorShifts = shifts;

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
}
