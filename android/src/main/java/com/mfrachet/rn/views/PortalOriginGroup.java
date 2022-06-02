package com.mfrachet.rn.views;
import android.view.View;
import android.view.ViewGroup;
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
        if (destinationName != null || mLastDestination == null || mLastDestination.getLastOrigin() == null) {
            return;
        }

        if (getId() == mLastDestination.getLastOrigin().getId()) {
            mLastDestination.restitute();
        }
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        PortalDestinationGroup realDestination = mRegistry.getDestination(mDestination);
        if (realDestination != null) {
            realDestination.addView(child, index, params);
        } else {
            super.addView(child, index, params);
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
