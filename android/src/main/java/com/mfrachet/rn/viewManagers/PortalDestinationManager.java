package com.mfrachet.rn.viewManagers;


import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.mfrachet.rn.utils.PortalRegistry;
import com.mfrachet.rn.views.PortalDestinationGroup;
import com.facebook.react.uimanager.annotations.ReactProp;

public class PortalDestinationManager extends ViewGroupManager<PortalDestinationGroup> {
    public static final String REACT_CLASS = "RCTPortalDestination";
    private PortalRegistry mRegistry;

    public PortalDestinationManager(PortalRegistry registry) {
        mRegistry = registry;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public PortalDestinationGroup createViewInstance(ThemedReactContext context) {
        return new PortalDestinationGroup(context, mRegistry);
    }

    @ReactProp(name = "name")
    public void setName(PortalDestinationGroup destination, String name) {
        destination.setName(name);
    }
}
