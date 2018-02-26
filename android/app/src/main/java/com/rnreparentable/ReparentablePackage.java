package com.rnreparentable;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.rnreparentable.utils.ReparentableRegistry;
import com.rnreparentable.viewManagers.ReparentableDestinationManager;
import com.rnreparentable.viewManagers.ReparentableOriginManager;
import com.rnreparentable.views.ReparentableDestinationGroup;
import com.rnreparentable.views.ReparentableOriginGroup;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ReparentablePackage implements ReactPackage {

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        ReparentableRegistry registry =
                new ReparentableRegistry(new HashMap<String, ReparentableOriginGroup>(), new HashMap<String, ReparentableDestinationGroup>());
        return Arrays.<ViewManager>asList(
                new ReparentableDestinationManager(registry),
                new ReparentableOriginManager(registry)
        );
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}