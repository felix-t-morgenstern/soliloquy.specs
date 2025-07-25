package soliloquy.specs.ui;

import soliloquy.specs.io.graphics.renderables.RenderableWithMouseEvents;

import java.util.Objects;

/**
 * (This class exists primarily since arguments to UI events may expand over time, and
 * {@link soliloquy.specs.common.entities.Action}s should not need to remember an archaic and
 * nonsensical ordering of input parameters just to avoid bricking older Actions.)
 */
public class EventInputs {
    public Long timestamp;
    public Component component;
    public RenderableWithMouseEvents renderable;

    private EventInputs(long timestamp, RenderableWithMouseEvents renderable) {
    }

    public static EventInputs inputs(long timestamp, RenderableWithMouseEvents renderable) {
        return new EventInputs(timestamp, renderable);
    }

    public EventInputs timestamp(long timestamp) {
        this.timestamp = timestamp;

        return this;
    }

    public EventInputs component(Component component) {
        this.component = component;

        return this;
    }

    public EventInputs renderable(RenderableWithMouseEvents renderable) {
        this.renderable = renderable;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof EventInputs e) {
            return Objects.equals(e.timestamp, timestamp) &&
                    Objects.equals(e.component, component) &&
                    Objects.equals(e.renderable, renderable);
        }
        else {
            return false;
        }
    }
}
