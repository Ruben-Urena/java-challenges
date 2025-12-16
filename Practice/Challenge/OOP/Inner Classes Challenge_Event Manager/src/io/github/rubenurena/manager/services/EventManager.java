package io.github.rubenurena.manager.services;
import io.github.rubenurena.manager.events.core.EventType;
import io.github.rubenurena.manager.services.Listener.Listenable;

import java.util.*;

public class EventManager {

    private static class EventBus{
        private Set<Subscription> subscriptions;

        private EventBus(){
            subscriptions = new HashSet<>();
        }


        private class Subscription{

        }


    }


}
