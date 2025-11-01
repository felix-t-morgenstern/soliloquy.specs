package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.colorshifting.ColorShift;
import soliloquy.specs.ui.definitions.colorshifting.ShiftDefinition;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class AbstractImageAssetRenderableDefinition extends AbstractContentDefinition {
    public final AbstractProviderDefinition<FloatBox> DIMENSIONS_PROVIDER_DEF;

    public AbstractProviderDefinition<Float> borderThicknessProviderDef;
    public AbstractProviderDefinition<Color> borderColorProviderDef;
    public Map<Integer, String> onPressIds;
    public Map<Integer, String> onReleaseIds;
    public String onMouseOverId;
    public String onMouseLeaveId;
    public ShiftDefinition[] colorShiftDefs;
    public ColorShift[] colorShifts;

    protected AbstractImageAssetRenderableDefinition(
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            int z,
            UUID uuid
    ) {
        super(z, uuid);
        DIMENSIONS_PROVIDER_DEF = dimensionsProviderDef;
    }

    protected AbstractImageAssetRenderableDefinition(
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            int z
    ) {
        super(z, randomUUID());
        DIMENSIONS_PROVIDER_DEF = dimensionsProviderDef;
    }
}
