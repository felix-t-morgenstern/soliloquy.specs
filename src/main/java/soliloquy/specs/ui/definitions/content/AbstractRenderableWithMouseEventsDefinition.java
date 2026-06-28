package soliloquy.specs.ui.definitions.content;

import java.util.Map;
import java.util.UUID;

public abstract class AbstractRenderableWithMouseEventsDefinition
        extends AbstractContentDefinition {
    public Map<Integer, String> onPressIds;
    public Map<Integer, String> onReleaseIds;
    public String onMouseOverId;
    public String onMouseLeaveId;

    protected AbstractRenderableWithMouseEventsDefinition(int z, UUID uuid) {
        super(z, uuid);
    }

    public abstract AbstractRenderableWithMouseEventsDefinition onPress(
            Map<Integer, String> onPressIds
    );

    public abstract AbstractRenderableWithMouseEventsDefinition onRelease(
            Map<Integer, String> onReleaseIds
    );

    public abstract AbstractRenderableWithMouseEventsDefinition onMouseOver(
            String onMouseOverId
    );

    public abstract AbstractRenderableWithMouseEventsDefinition onMouseLeave(
            String onMouseLeaveId
    );
}
