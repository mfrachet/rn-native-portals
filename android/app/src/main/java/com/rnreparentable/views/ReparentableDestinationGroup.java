package com.rnreparentable.views;

import com.facebook.react.uimanager.ThemedReactContext;
import com.rnreparentable.utils.ReparentableRegistry;


public class ReparentableDestinationGroup extends ReparentableViewGroup {
    private String mName;
    private ReparentableOriginGroup mLastOrigin;
    private ReparentableRegistry mRegistry;

    public ReparentableDestinationGroup(ThemedReactContext ctx, ReparentableRegistry registry) {
        super(ctx);
        mRegistry = registry;
    }

    //Business part
    private void moveIfNeeded() {
        ReparentableOriginGroup potentialOrigin = mRegistry.getOrigin(mName);
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

    public void prepareNextRestitution(ReparentableOriginGroup origin) {
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

    public ReparentableOriginGroup getLastOrigin() {
        return mLastOrigin;
    }
}
