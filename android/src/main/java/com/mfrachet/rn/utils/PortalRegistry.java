package com.mfrachet.rn.utils;


import com.mfrachet.rn.views.PortalDestinationGroup;
import com.mfrachet.rn.views.PortalOriginGroup;

import java.util.Map;


public class PortalRegistry {
    private Map<String, PortalOriginGroup> mOrigins;
    private Map<String, PortalDestinationGroup> mDestinations;

    public PortalRegistry(Map<String, PortalOriginGroup> origins, Map<String, PortalDestinationGroup> destinations) {
        mOrigins = origins;
        mDestinations = destinations;
    }

    // Destination
    public void putDestination(PortalDestinationGroup destination) {
        mDestinations.put(destination.getName(), destination);
    }

    public PortalDestinationGroup getDestination(String name) {
        return mDestinations.get(name);
    }

    // Origins
    public void putOrigin(PortalOriginGroup origin) {
        mOrigins.put(origin.getDestination(), origin);
    }

    public PortalOriginGroup getOrigin(String name) {
        return mOrigins.get(name);
    }

    public void remove(PortalOriginGroup origin) {
        mOrigins.remove(origin);
    }
}
