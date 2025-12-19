package io.github.rubenurena.manager.services;
import io.github.rubenurena.manager.events.core.EventType;
import io.github.rubenurena.manager.services.Listener.Listenable;
import io.github.rubenurena.manager.events.core.*;


import java.util.*;


    /**
    * This class manages publishers and is the only entry point for creating
    * and removing subscriptions, which are implemented as a private inner class.
    */
public class EventManager {
    private final EventBus eventBus;

    public EventManager(){
        eventBus = new EventBus();
    }


    public void publish(Event event ){
        eventBus.dispatch(event);
    }


    public void createSubscription(EventType eventType, Listenable listener){
        this.eventBus.new Subscription(eventType,listener);
    }
    private void removeSub(EventType _eventType, Listenable _listener){
        eventBus.getSubscriptions().removeIf((a)-> a.eventType.equals(_eventType)
                && a.listener.equals(_listener));
    }



    /**
     * Sends events to all registered subscribers.
     * This class does not decide when subscribers are added or removed.
     */
    private static class EventBus{

        private final Set<Subscription> subscriptions;


        private EventBus(){
            subscriptions = new HashSet<>();
        }

        public Set<Subscription> getSubscriptions() {
            return subscriptions;
        }


        private void dispatch(Event event){
            var list = routing(event);
            list.forEach( (a)->a.listener.apply());
        }
        private ArrayList<Subscription> routing(Event event){
            ArrayList<Subscription> arrayList = new ArrayList<>();

            subscriptions.forEach( (s)-> {
                if(s.eventType.equals(event.getEventType())){
                    arrayList.add(s);
                }
            });
            return arrayList;
        }


        // Subscribes a listener to an event type
        //do not store multiple subscription
        private class Subscription{
            private final EventType eventType;
            private final Listenable listener;

            private Subscription(EventType eventType, Listenable listener){
                this.eventType = eventType;
                this.listener = listener;
                subscriptions.add(this);
            }

            private EventType getEventType() {
                return eventType;
            }

            private Listenable getListener() {
                return listener;
            }

            //Override equals method to compare Listener variable.
            @Override
            public boolean equals(Object obj) {
                if (this.hashCode() != obj.hashCode()) return false;
                if (this == obj) return true;
                if (!(obj instanceof Subscription s)) return false;
                return this.listener.equals(s.listener);
            }

            //Override hashCode method to compare eventType variable.
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
