package com.mfrachet.rn.views;

import android.view.View;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;

public class PortalViewGroup extends ReactViewGroup {

    public PortalViewGroup(ThemedReactContext ctx) {
        super(ctx);
    }

    public void moveTo(PortalViewGroup destination) {
        destination.removeAllViews();


        View sourceChild = getChildAt(0);
        while (sourceChild != null) {
            removeView(sourceChild);
            destination.addView(sourceChild);


            sourceChild = getChildAt(0);
        }
    }
}
