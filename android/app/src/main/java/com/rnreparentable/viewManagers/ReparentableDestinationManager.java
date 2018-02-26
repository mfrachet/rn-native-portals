package com.rnreparentable.viewManagers;


import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.rnreparentable.utils.ReparentableRegistry;
import com.rnreparentable.views.ReparentableDestinationGroup;

public class ReparentableDestinationManager extends ViewGroupManager<ReparentableDestinationGroup> {
    public static final String REACT_CLASS = "RCTReparentableDestination";
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
