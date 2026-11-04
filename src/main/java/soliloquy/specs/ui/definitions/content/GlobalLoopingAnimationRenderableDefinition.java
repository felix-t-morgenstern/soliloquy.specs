package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.colorshifting.ColorShift;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ui.definitions.colorshifting.ShiftDefinition;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;

import static soliloquy.specs.ui.definitions.providers.StaticProviderDefinition.staticVal;

public class GlobalLoopingAnimationRenderableDefinition
        extends AbstractImageAssetRenderableDefinition {
    private GlobalLoopingAnimationRenderableDefinition(
            String globalLoopingAnimationId,
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            int z
    ) {
        super(globalLoopingAnimationId, dimensionsProviderDef, z);
    }

    private GlobalLoopingAnimationRenderableDefinition(
            String globalLoopingAnimationId,
            ProviderAtTime<FloatBox> dimensionsProvider,
            int z
    ) {
        super(globalLoopingAnimationId, dimensionsProvider, z);
    }

    public static GlobalLoopingAnimationRenderableDefinition globalLooping(
            String globalLoopingAnimationId,
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef,
            int z
    ) {
        return new GlobalLoopingAnimationRenderableDefinition(globalLoopingAnimationId,
                dimensionsProviderDef, z);
    }

    public static GlobalLoopingAnimationRenderableDefinition globalLooping(
            String globalLoopingAnimationId,
            ProviderAtTime<FloatBox> dimensionsProvider,
            int z
    ) {
        return new GlobalLoopingAnimationRenderableDefinition(globalLoopingAnimationId,
                dimensionsProvider, z);
    }

    public static GlobalLoopingAnimationRenderableDefinition globalLooping(
            String globalLoopingAnimationId,
            FloatBox dimensions,
            int z
    ) {
        return new GlobalLoopingAnimationRenderableDefinition(globalLoopingAnimationId,
                staticVal(dimensions), z);
    }

    public static GlobalLoopingAnimationRenderableDefinition globalLooping(
            String globalLoopingAnimationId,
            AbstractProviderDefinition<FloatBox> dimensionsProviderDef
    ) {
        return new GlobalLoopingAnimationRenderableDefinition(globalLoopingAnimationId,
                dimensionsProviderDef, 0);
    }

    public static GlobalLoopingAnimationRenderableDefinition globalLooping(
            String globalLoopingAnimationId,
            ProviderAtTime<FloatBox> dimensionsProvider
    ) {
        return new GlobalLoopingAnimationRenderableDefinition(globalLoopingAnimationId,
                dimensionsProvider, 0);
    }

    public static GlobalLoopingAnimationRenderableDefinition globalLooping(
            String globalLoopingAnimationId,
            FloatBox dimensions
    ) {
        return new GlobalLoopingAnimationRenderableDefinition(globalLoopingAnimationId,
                staticVal(dimensions), 0);
    }

    public GlobalLoopingAnimationRenderableDefinition withBorder(
            AbstractProviderDefinition<Float> thicknessProviderDef,
            AbstractProviderDefinition<Color> colorProviderDef
    ) {
        borderThicknessProviderDef = thicknessProviderDef;
        borderColorProviderDef = colorProviderDef;

        return this;
    }

    public GlobalLoopingAnimationRenderableDefinition withColorShifts(
            ShiftDefinition... shiftDefinitions
    ) {
        this.colorShiftDefs = shiftDefinitions;

        return this;
    }

    public GlobalLoopingAnimationRenderableDefinition withColorShifts(ColorShift... shifts) {
        this.colorShifts = shifts;

        return this;
    }

    public GlobalLoopingAnimationRenderableDefinition onPress(Map<Integer, String> onPressIds) {
        this.onPressIds = onPressIds;

        return this;
    }

    public GlobalLoopingAnimationRenderableDefinition onRelease(Map<Integer, String> onReleaseIds) {
        this.onReleaseIds = onReleaseIds;

        return this;
    }

    public GlobalLoopingAnimationRenderableDefinition onWheelScroll(String onWheelScrollId) {
        this.onWheelScrollId = onWheelScrollId;

        return this;
    }

    public GlobalLoopingAnimationRenderableDefinition onMouseOver(String onMouseOverId) {
        this.onMouseOverId = onMouseOverId;

        return this;
    }

    public GlobalLoopingAnimationRenderableDefinition onMouseLeave(String onMouseLeaveId) {
        this.onMouseLeaveId = onMouseLeaveId;

        return this;
    }
}
