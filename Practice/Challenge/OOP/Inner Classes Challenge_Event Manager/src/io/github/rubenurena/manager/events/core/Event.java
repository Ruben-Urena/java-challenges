package io.github.rubenurena.manager.events.core;
import io.github.rubenurena.manager.events.payload.Payload;
import io.github.rubenurena.manager.services.Listener.Listenable;

public abstract class Event {
    private final Payload payload;
    private final EventType eventType;

    protected Event(Payload payload, EventType eventType) {
        this.payload = payload;
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Payload getPayload() {
        return payload;
    }
}
