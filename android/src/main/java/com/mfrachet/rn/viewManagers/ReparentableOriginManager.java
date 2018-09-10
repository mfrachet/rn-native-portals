package com.mfrachet.rn.viewManagers;


import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.mfrachet.rn.utils.ReparentableRegistry;
import com.mfrachet.rn.views.ReparentableOriginGroup;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ReparentableOriginManager extends ViewGroupManager<ReparentableOriginGroup> {
    public static final String REACT_CLASS = "RCTPortalOrigin";
    private ReparentableRegistry mRegistry;

    public ReparentableOriginManager(ReparentableRegistry registry) {
        mRegistry = registry;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public ReparentableOriginGroup createViewInstance(ThemedReactContext context) {
        return new ReparentableOriginGroup(context, mRegistry);
    }

    @ReactProp(name = "destination")
    public void setDestination(ReparentableOriginGroup origin, String destination) {
        origin.setDestination(destination);
    }
}
