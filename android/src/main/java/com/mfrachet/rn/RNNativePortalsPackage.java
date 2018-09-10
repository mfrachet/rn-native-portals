
package com.mfrachet.rn;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.mfrachet.rn.utils.ReparentableRegistry;
import com.mfrachet.rn.viewManagers.ReparentableDestinationManager;
import com.mfrachet.rn.viewManagers.ReparentableOriginManager;
import com.mfrachet.rn.views.ReparentableDestinationGroup;
import com.mfrachet.rn.views.ReparentableOriginGroup;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RNNativePortalsPackage implements ReactPackage {
    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        ReparentableRegistry registry =
                new ReparentableRegistry(new HashMap<String, ReparentableOriginGroup>(), new HashMap<String, ReparentableDestinationGroup>());
        return Arrays.<ViewManager>asList(
                new ReparentableDestinationManager(registry),
                new ReparentableOriginManager(registry)
        );
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}