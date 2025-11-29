package io.github.rubenurena.manager.app;

import io.github.rubenurena.manager.events.core.EventType;
import io.github.rubenurena.manager.services.EventManager;
import io.github.rubenurena.manager.services.Listener1;
import io.github.rubenurena.manager.services.Listener2;
import io.github.rubenurena.manager.services.Listener3;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        EventManager.SubscriptionsManager eventManager = new EventManager.SubscriptionsManager();
        eventManager.createSubscription(EventType.EVENT_TYPE_A, new Listener1());
        eventManager.createSubscription(EventType.EVENT_TYPE_A, new Listener2());
        eventManager.createSubscription(EventType.EVENT_TYPE_A, new Listener3());
        eventManager.createSubscription(EventType.EVENT_TYPE_B, new Listener3());
        eventManager.createSubscription(EventType.EVENT_TYPE_B, new Listener3());
        eventManager.printSubscriptionsList();

    }

}



