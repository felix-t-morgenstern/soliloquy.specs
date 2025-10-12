package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.ui.definitions.colorshifting.ShiftDefinition;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;

public class AbstractImageAssetRenderableDefinition extends AbstractContentDefinition {
    public final AbstractProviderDefinition<FloatBox> DIMENSIONS_PROVIDER_DEF;

    public AbstractProviderDefinition<Float> borderThicknessProviderDef;
    public AbstractProviderDefinition<Color> borderColorProviderDef;
    public Map<Integer, String> onPressIds;
    public Map<Integer, String> onReleaseIds;
    public String onMouseOverId;
    public String onMouseLeaveId;
    public ShiftDefinition[] colorShiftDefs;

    protected AbstractImageAssetRenderableDefinition(
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            int z
    ) {
        super(z);
        DIMENSIONS_PROVIDER_DEF = dimensionsProviderDef;
    }
}
