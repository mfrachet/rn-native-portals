package com.mfrachet.rn.views;


import com.facebook.react.uimanager.ThemedReactContext;
import com.mfrachet.rn.utils.PortalRegistry;

public class PortalOriginGroup extends PortalViewGroup {
    private String mDestination;
    private PortalDestinationGroup mLastDestination;
    private PortalRegistry mRegistry;

    public PortalOriginGroup(ThemedReactContext ctx, PortalRegistry registry) {
        super(ctx);
        mRegistry = registry;
    }

    // Buiness part
    public void restituteIfNeeded(String destinationName) {
        if (mLastDestination == null || mLastDestination.getLastOrigin() == null) {
            return;
        }
        
        if (destinationName == mLastDestination.getName()) {
            return;
        }

        if (getId() == mLastDestination.getLastOrigin().getId()) {
            mLastDestination.restitute();
        }
    }

    public void move() {
        PortalDestinationGroup realDestination = mRegistry.getDestination(mDestination);
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

    public void setLastDestination(PortalDestinationGroup lastDestination) {
        mLastDestination = lastDestination;
    }
}
