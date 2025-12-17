package io.github.rubenurena.manager.services;
import io.github.rubenurena.manager.events.core.EventType;
import io.github.rubenurena.manager.services.Listener.AreaIsFullListener;
import io.github.rubenurena.manager.services.Listener.Listenable;
import io.github.rubenurena.manager.services.Listener.MiniDepartmentIsFullListener;

import java.util.*;

public class EventManager {
    
    private static class EventBus{
        private final Set<Subscription> subscriptions;

        private EventBus(){
            subscriptions = new HashSet<>();
        }

        private void removeSub(Subscription subscription){
            subscriptions.remove(subscription);
        }

        private void removeSub(EventType _eventType, Listenable _listener){
            for (var s : subscriptions){
                if (s.eventType.equals(_eventType) && s.listener.equals(_listener)){
                    removeSub(s);
                }
            }
        }



        private class Subscription{
            private final EventType eventType;
            private final Listenable listener;

            private Subscription(EventType eventType, Listenable listener){
                this.eventType = eventType;
                this.listener = listener;
                subscriptions.add(this);
            }

            public EventType getEventType() {
                return eventType;
            }

            public Listenable getListener() {
                return listener;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (!(obj instanceof Subscription s)) return false;
                return this.listener.equals(s.listener);
            }

            @Override
            public int hashCode() {
                return eventType.hashCode();
            }

            @Override
            public String toString() {
                return "Subscription{" +
                        "eventType=" + eventType +
                        ", listener=" + listener +
                        '}';
            }
        }


    }


}
