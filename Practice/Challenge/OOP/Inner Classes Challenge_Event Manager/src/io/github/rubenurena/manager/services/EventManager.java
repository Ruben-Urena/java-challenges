package io.github.rubenurena.manager.services;

import io.github.rubenurena.manager.events.core.EventType;

import java.util.*;

public class EventManager {
    //to manage a simple sub and multiple sub, SubscriptionsManager should exist
    public static class SubscriptionsManager{
        private final Set<String> listenersType ;
        private final Set<String> eventType ;
        private final ArrayList<Subscription<? extends EventType, ? extends Listenable>> subscriptions;

        public SubscriptionsManager(){
            listenersType =  new HashSet<>();
            eventType =  new HashSet<>();
            subscriptions = new ArrayList<>();
        }


        //create a sub with class Subscription, and also use the method isSubAllow
        public <K extends EventType,V extends Listenable> void createSubscription(K k, V v){
            if (isSubAllow(v)) {
                listenersType.add(v.getClass().getSimpleName());
                new Subscription<>(k,v);
            }

        }




        //if the listener is already in a EventType List
        public <V extends Listenable> boolean isSubAllow(V v){
            for(var a : listenersType){
                if(a.trim().equals(v.getClass().getSimpleName().trim())){
                    return false;
                }
            }
            return true;
        }




        //take the eventType from a subscription's instance and hold in a hashSet
        private Set <EventType> organizeSubscriptionList1(){
            Set <EventType> eventTypes = new HashSet<>();
            subscriptions.forEach( (a)->{
                eventTypes.add(a.k);
            } );
            return eventTypes;
        }
        
        //take the hashSetEventTypeFromSubscription and create ArrayList for each value.
        private ArrayList<ArrayList<String>> organizeSubscriptionList2(){
            ArrayList<ArrayList<String>> subs = new ArrayList<>();
            var hashSett = organizeSubscriptionList1();
            hashSett.forEach(  (s)->{
                subs.add(new ArrayList<>(List.of(s.name())));

            });
            return subs;
        }

        public ArrayList<ArrayList<String>> organizeSubscriptionList3(){
            var eventTypeList = organizeSubscriptionList2();
            subscriptions.forEach( (a)->{
                eventTypeList.forEach( (aa)->{
                    if (aa.getFirst().equals(a.k.name())){
                        aa.add(a.v.getClass().getSimpleName());

                    }
                });
            } );

            return eventTypeList;
        }


        public void printSubscriptionsList(){
            var s = organizeSubscriptionList3();
            s.forEach( (external)->{
                System.out.println("{");
                external.forEach(System.out::println);
                System.out.println("}");
            });
        }






        //this is a single sub that take EventType and a Listener
        private class Subscription<K extends EventType,V extends Listenable>{
            private final K k;
            private final V v;
            private Subscription(K k, V v){
                this.k = k;
                this.v = v;
                subscriptions.add(this);
            }

            private K getK() {
                return k;
            }

            private V getV() {
                return v;
            }
        }
    }
}
