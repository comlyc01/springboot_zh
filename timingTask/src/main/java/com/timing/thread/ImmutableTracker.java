package com.timing.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ImmutableTracker {

    private static Map<String, Immutable> locMap = new ConcurrentHashMap<String, Immutable>();

    public static void updateLocation(String veh, Immutable newlmmutable) {
        locMap.put(veh, newlmmutable);
    }


    public static void main(String[] args) {
        Immutable immutable = new Immutable(0.123, 1.767);
        updateLocation("vh", immutable);
    }

}
