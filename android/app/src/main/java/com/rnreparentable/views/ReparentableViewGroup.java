package com.rnreparentable.views;

import android.view.View;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;

public class ReparentableViewGroup extends ReactViewGroup {

    public ReparentableViewGroup(ThemedReactContext ctx) {
        super(ctx);
    }

    public void moveTo(ReparentableViewGroup destination) {
        destination.removeAllViews();


        View sourceChild = getChildAt(0);
        while (sourceChild != null) {
            removeView(sourceChild);
            destination.addView(sourceChild);


            sourceChild = getChildAt(0);
        }
    }
}
