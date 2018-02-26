package com.rnreparentable.viewManagers;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.rnreparentable.utils.ReparentableRegistry;
import com.rnreparentable.views.ReparentableOriginGroup;


public class ReparentableOriginManager extends ViewGroupManager<ReparentableOriginGroup> {
    public static final String REACT_CLASS = "RCTReparentableOrigin";
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
