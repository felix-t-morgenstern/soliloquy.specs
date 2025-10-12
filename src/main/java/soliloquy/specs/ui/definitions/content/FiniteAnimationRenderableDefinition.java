package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.ui.definitions.colorshifting.ShiftDefinition;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;

public class FiniteAnimationRenderableDefinition extends AbstractImageAssetRenderableDefinition {
    public final String ANIMATION_ID;

    public int startTimestampOffset;

    private FiniteAnimationRenderableDefinition(String animationId,
                                                AbstractProviderDefinition<FloatBox> dimensionsProvider,
                                                int z) {
        super(dimensionsProvider, z);
        ANIMATION_ID = animationId;
    }

    public static FiniteAnimationRenderableDefinition finiteAnimation(String animationId,
                                                                      AbstractProviderDefinition<FloatBox> dimensionsProvider,
                                                                      int z) {
        return new FiniteAnimationRenderableDefinition(animationId, dimensionsProvider, z);
    }

    public FiniteAnimationRenderableDefinition withBorder(
            AbstractProviderDefinition<Float> thicknessProviderDef,
            AbstractProviderDefinition<Color> colorProviderDef) {
        borderThicknessProviderDef = thicknessProviderDef;
        borderColorProviderDef = colorProviderDef;

        return this;
    }

    public FiniteAnimationRenderableDefinition onPress(Map<Integer, String> onPressIds) {
        this.onPressIds = onPressIds;

        return this;
    }

    public FiniteAnimationRenderableDefinition onRelease(Map<Integer, String> onReleaseIds) {
        this.onReleaseIds = onReleaseIds;

        return this;
    }

    public FiniteAnimationRenderableDefinition onMouseOver(String onMouseOverId) {
        this.onMouseOverId = onMouseOverId;

        return this;
    }

    public FiniteAnimationRenderableDefinition onMouseLeave(String onMouseLeaveId) {
        this.onMouseLeaveId = onMouseLeaveId;

        return this;
    }

    public FiniteAnimationRenderableDefinition withColorShifts(
            ShiftDefinition... shiftDefinitions) {
        this.colorShiftDefs = shiftDefinitions;

        return this;
    }

    public FiniteAnimationRenderableDefinition withStartTimestampOffset(int startTimestampOffset) {
        this.startTimestampOffset = startTimestampOffset;

        return this;
    }
}
