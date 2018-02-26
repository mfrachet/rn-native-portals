package com.rnreparentable.views;


import com.facebook.react.uimanager.ThemedReactContext;
import com.rnreparentable.utils.ReparentableRegistry;

public class ReparentableOriginGroup extends ReparentableViewGroup {
    private String mDestination;
    private ReparentableDestinationGroup mLastDestination;
    private ReparentableRegistry mRegistry;

    public ReparentableOriginGroup(ThemedReactContext ctx, ReparentableRegistry registry) {
        super(ctx);
        mRegistry = registry;
    }

    // Buiness part
    public void restituteIfNeeded(String destinationName) {
        if (destinationName != null || mLastDestination == null || mLastDestination.getLastOrigin() == null) {
            return;
        }

        if (getId() == mLastDestination.getLastOrigin().getId()) {
            mLastDestination.restitute();
        }
    }

    public void move() {
        ReparentableDestinationGroup realDestination = mRegistry.getDestination(mDestination);
        if (realDestination != null) {
            realDestination.restitute();
            moveTo(realDestination);

            realDestination.prepareNextRestitution(this);
        }
    }


    // Accesseurs
    public String getDestination() {
        return mDestination;
    }

    public void setDestination(String newDestination) {
        // WillSet on iOS
        restituteIfNeeded(newDestination);
        mRegistry.remove(this);

        // DidSet on iOS
        mDestination = newDestination;
        mRegistry.putOrigin(this);
        move();
    }

    public void setLastDestination(ReparentableDestinationGroup lastDestination) {
        mLastDestination = lastDestination;
    }
}
