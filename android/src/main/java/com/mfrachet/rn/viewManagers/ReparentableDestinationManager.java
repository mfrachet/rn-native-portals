package com.mfrachet.rn.viewManagers;


import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.mfrachet.rn.utils.ReparentableRegistry;
import com.mfrachet.rn.views.ReparentableDestinationGroup;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ReparentableDestinationManager extends ViewGroupManager<ReparentableDestinationGroup> {
    public static final String REACT_CLASS = "RCTPortalDestination";
    private ReparentableRegistry mRegistry;

    public ReparentableDestinationManager(ReparentableRegistry registry) {
        mRegistry = registry;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public ReparentableDestinationGroup createViewInstance(ThemedReactContext context) {
        return new ReparentableDestinationGroup(context, mRegistry);
    }

    @ReactProp(name = "name")
    public void setName(ReparentableDestinationGroup destination, String name) {
        destination.setName(name);
    }
}
