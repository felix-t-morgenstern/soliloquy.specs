package soliloquy.specs.ui;

import soliloquy.specs.io.graphics.renderables.Component;
import soliloquy.specs.io.graphics.renderables.RenderableWithMouseEvents;
import soliloquy.specs.io.input.mouse.MouseEventHandler;

import java.util.Objects;

/**
 * (This class exists primarily since arguments to UI events may expand over time, and
 * {@link soliloquy.specs.common.entities.Action}s should not need to remember an archaic and
 * nonsensical ordering of input parameters just to avoid bricking older Actions.)
 */
public class EventInputs {
    public Long TIMESTAMP;

    public Integer mouseButton;
    public MouseEventHandler.EventType mouseEvent;
    public RenderableWithMouseEvents renderable;

    public Integer keyCodepoint;

    public Component component;

    private EventInputs(long timestamp) {
        this.TIMESTAMP = timestamp;
    }

    public static EventInputs eventInputs(long timestamp) {
        return new EventInputs(timestamp);
    }

    public EventInputs withTimestamp(long timestamp) {
        this.TIMESTAMP = timestamp;

        return this;
    }

    public EventInputs withMouseEvent(
            Integer mouseButton,
            MouseEventHandler.EventType mouseEvent,
            RenderableWithMouseEvents renderable,
            Component component
    ) {
        this.mouseButton = mouseButton;
        this.mouseEvent = mouseEvent;
        this.renderable = renderable;
        this.component = component;

        return this;
    }

    public EventInputs withKeyEvent(int keyCodepoint, Component component) {
        this.keyCodepoint = keyCodepoint;
        this.component = component;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof EventInputs e) {
            return Objects.equals(e.TIMESTAMP, TIMESTAMP) &&
                    Objects.equals(e.renderable, renderable) &&
                    Objects.equals(e.mouseEvent, mouseEvent) &&
                    Objects.equals(e.keyCodepoint, keyCodepoint);
        }
        else {
            return false;
        }
    }
}
