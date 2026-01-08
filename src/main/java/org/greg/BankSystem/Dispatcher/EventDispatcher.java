package org.greg.BankSystem.Dispatcher;

import org.greg.BankSystem.Contracts.DomainEvent;
import org.greg.BankSystem.Listeners.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDispatcher {
    private final Map<Class<? extends DomainEvent>,
            List<EventListener<? extends DomainEvent>>> listeners = new HashMap<>();

    public void register(Class<? extends DomainEvent> eventType, EventListener listener) {
        listeners
                .computeIfAbsent(eventType, k -> new ArrayList<>())
                .add(listener);
    }

    @SuppressWarnings("unchecked")
    public void dispatch(DomainEvent event) {
        List<EventListener<? extends DomainEvent>> eventListeners =
                listeners.getOrDefault(event.getClass(), List.of());
        for (EventListener listener : eventListeners) {
            listener.onEvent(event);
        }
    }
}
