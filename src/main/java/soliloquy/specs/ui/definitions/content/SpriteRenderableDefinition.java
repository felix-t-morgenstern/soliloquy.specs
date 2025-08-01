package soliloquy.specs.ui.definitions.content;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.ui.definitions.colorshifting.ShiftDefinition;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

import java.awt.*;
import java.util.Map;

public class SpriteRenderableDefinition extends AbstractImageAssetRenderableDefinition {
    public final String SPRITE_ID;

    private SpriteRenderableDefinition(String spriteId,
                                       AbstractProviderDefinition<FloatBox> dimensionsProvider,
                                       int z) {
        super(dimensionsProvider, z);
        this.SPRITE_ID = spriteId;
    }

    public static SpriteRenderableDefinition sprite(String spriteId,
                                                    AbstractProviderDefinition<FloatBox> dimensionsProvider,
                                                    int z) {
        return new SpriteRenderableDefinition(spriteId, dimensionsProvider, z);
    }

    public SpriteRenderableDefinition withBorder(AbstractProviderDefinition<Float> thicknessProvider, AbstractProviderDefinition<Color> colorProvider) {
        borderThicknessProvider = thicknessProvider;
        borderColorProvider = colorProvider;

        return this;
    }

    public SpriteRenderableDefinition withColorShifts(ShiftDefinition... shiftDefinitions) {
        this.colorShifts = shiftDefinitions;

        return this;
    }

    public SpriteRenderableDefinition onPress(Map<Integer, String> onPressIds) {
        this.onPressIds = onPressIds;

        return this;
    }

    public SpriteRenderableDefinition onRelease(Map<Integer, String> onReleaseIds) {
        this.onReleaseIds = onReleaseIds;

        return this;
    }

    public SpriteRenderableDefinition onMouseOver(String onMouseOverId) {
        this.onMouseOverId = onMouseOverId;

        return this;
    }

    public SpriteRenderableDefinition onMouseLeave(String onMouseLeaveId) {
        this.onMouseLeaveId = onMouseLeaveId;

        return this;
    }
}
