package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.io.graphics.renderables.colorshifting.ColorShift;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class FiniteAnimationRenderableDefinition extends AbstractContentDefinition {
    public final String ANIMATION_ID;

    public AbstractProviderDefinition<Float> borderThicknessProvider;
    public AbstractProviderDefinition<Color> borderColorProvider;
    public Map<Integer, String> onPressIds;
    public Map<Integer, String> onReleaseIds;
    public String onMouseOverId;
    public String onMouseLeaveId;
    public List<AbstractProviderDefinition<ColorShift>> colorShiftProviders;
    public int startTimestampOffset;

    private FiniteAnimationRenderableDefinition(String animationId, int z) {
        super(z);
        ANIMATION_ID = animationId;
    }

    public static FiniteAnimationRenderableDefinition finiteAnimation(String animationId, int z) {
        return new FiniteAnimationRenderableDefinition(animationId, z);
    }

    public FiniteAnimationRenderableDefinition withBorder(AbstractProviderDefinition<Float> thicknessProvider, AbstractProviderDefinition<Color> colorProvider) {
        borderThicknessProvider = thicknessProvider;
        borderColorProvider = colorProvider;

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

    public FiniteAnimationRenderableDefinition colorShifts(List<AbstractProviderDefinition<ColorShift>> colorShiftProviders) {
        this.colorShiftProviders = colorShiftProviders;

        return this;
    }

    public FiniteAnimationRenderableDefinition withStartTimestampOffset(int startTimestampOffset) {
        this.startTimestampOffset = startTimestampOffset;

        return this;
    }
}
