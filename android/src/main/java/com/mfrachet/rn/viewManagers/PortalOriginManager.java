package com.mfrachet.rn.viewManagers;


import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.mfrachet.rn.utils.PortalRegistry;
import com.mfrachet.rn.views.PortalOriginGroup;
import com.facebook.react.uimanager.annotations.ReactProp;

public class PortalOriginManager extends ViewGroupManager<PortalOriginGroup> {
    public static final String REACT_CLASS = "RCTPortalOrigin";
    private PortalRegistry mRegistry;

    public PortalOriginManager(PortalRegistry registry) {
        mRegistry = registry;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public PortalOriginGroup createViewInstance(ThemedReactContext context) {
        return new PortalOriginGroup(context, mRegistry);
    }

    @ReactProp(name = "destination")
    public void setDestination(PortalOriginGroup origin, String destination) {
        origin.setDestination(destination);
    }
}
