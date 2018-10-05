package com.mfrachet.rn.views;

import com.facebook.react.uimanager.ThemedReactContext;
import com.mfrachet.rn.utils.PortalRegistry;


public class PortalDestinationGroup extends PortalViewGroup {
    private String mName;
    private PortalOriginGroup mLastOrigin;
    private PortalRegistry mRegistry;

    public PortalDestinationGroup(ThemedReactContext ctx, PortalRegistry registry) {
        super(ctx);
        mRegistry = registry;
    }

    //Business part
    private void moveIfNeeded() {
        PortalOriginGroup potentialOrigin = mRegistry.getOrigin(mName);
        if (potentialOrigin != null) {
            potentialOrigin.moveTo(this);
            prepareNextRestitution(potentialOrigin);
        }
    }

    public void restitute() {
        if (mLastOrigin != null) {
            moveTo(mLastOrigin);
            mLastOrigin.setLastDestination(null);
            mLastOrigin = null;
        }
    }

    public void prepareNextRestitution(PortalOriginGroup origin) {
        mLastOrigin = origin;
        origin.setLastDestination(this);
    }

    // Accesseurs
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        mRegistry.putDestination(this);
        moveIfNeeded();
    }

    public PortalOriginGroup getLastOrigin() {
        return mLastOrigin;
    }
}
