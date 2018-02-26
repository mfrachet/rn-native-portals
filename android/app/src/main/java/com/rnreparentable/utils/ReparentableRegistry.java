package com.rnreparentable.utils;


import com.rnreparentable.views.ReparentableDestinationGroup;
import com.rnreparentable.views.ReparentableOriginGroup;

import java.util.Map;


public class ReparentableRegistry {
    private Map<String, ReparentableOriginGroup> mOrigins;
    private Map<String, ReparentableDestinationGroup> mDestinations;

    public ReparentableRegistry(Map<String, ReparentableOriginGroup> origins, Map<String, ReparentableDestinationGroup> destinations) {
        mOrigins = origins;
        mDestinations = destinations;
    }

    // Destination
    public void putDestination(ReparentableDestinationGroup destination) {
        mDestinations.put(destination.getName(), destination);
    }

    public ReparentableDestinationGroup getDestination(String name) {
        return mDestinations.get(name);
    }

    // Origins
    public void putOrigin(ReparentableOriginGroup origin) {
        mOrigins.put(origin.getDestination(), origin);
    }

    public ReparentableOriginGroup getOrigin(String name) {
        return mOrigins.get(name);
    }

    public void remove(ReparentableOriginGroup origin) {
        mOrigins.remove(origin);
    }
}
