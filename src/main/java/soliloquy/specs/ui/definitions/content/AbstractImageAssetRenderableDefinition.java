package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.colorshifting.ColorShift;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.colorshifting.ShiftDefinition;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public abstract class AbstractImageAssetRenderableDefinition
        extends AbstractRenderableWithDimensionsDefinition {
    public final String ASSET_ID;

    public AbstractProviderDefinition<Float> borderThicknessProviderDef;
    public AbstractProviderDefinition<Color> borderColorProviderDef;
    public ShiftDefinition[] colorShiftDefs;
    public ColorShift[] colorShifts;

    protected AbstractImageAssetRenderableDefinition(
            String assetId,
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            int z,
            UUID uuid
    ) {
        super(dimensionsProviderDef, z, uuid);
        ASSET_ID = assetId;
    }

    protected AbstractImageAssetRenderableDefinition(
            String assetId,
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            int z
    ) {
        super(dimensionsProviderDef, z, randomUUID());
        ASSET_ID = assetId;
    }

    protected AbstractImageAssetRenderableDefinition(
            String assetId,
            ProviderAtTime<FloatBox> dimensionsProvider,
            int z,
            UUID uuid
    ) {
        super(dimensionsProvider, z, uuid);
        ASSET_ID = assetId;
    }

    protected AbstractImageAssetRenderableDefinition(
            String assetId,
            ProviderAtTime<FloatBox> dimensionsProvider,
            int z
    ) {
        super(dimensionsProvider, z, randomUUID());
        ASSET_ID = assetId;
    }

    public abstract AbstractImageAssetRenderableDefinition withBorder(
            AbstractProviderDefinition<Float> thicknessProviderDef,
            AbstractProviderDefinition<Color> colorProviderDef
    );

    public abstract AbstractImageAssetRenderableDefinition withColorShifts(
            ShiftDefinition... shiftDefinitions
    );

    public abstract AbstractImageAssetRenderableDefinition withColorShifts(
            ColorShift... shifts
    );

    public abstract AbstractImageAssetRenderableDefinition onPress(Map<Integer, String> onPressIds);

    public abstract AbstractImageAssetRenderableDefinition onRelease(
            Map<Integer, String> onReleaseIds);

    public abstract AbstractImageAssetRenderableDefinition onMouseOver(String onMouseOverId);

    public abstract AbstractImageAssetRenderableDefinition onMouseLeave(String onMouseLeaveId);
}
