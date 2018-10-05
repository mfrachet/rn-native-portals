
package com.mfrachet.rn;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.mfrachet.rn.utils.PortalRegistry;
import com.mfrachet.rn.viewManagers.PortalDestinationManager;
import com.mfrachet.rn.viewManagers.PortalOriginManager;
import com.mfrachet.rn.views.PortalDestinationGroup;
import com.mfrachet.rn.views.PortalOriginGroup;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RNNativePortalsPackage implements ReactPackage {
    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        PortalRegistry registry =
                new PortalRegistry(new HashMap<String, PortalOriginGroup>(), new HashMap<String, PortalDestinationGroup>());
        return Arrays.<ViewManager>asList(
                new PortalDestinationManager(registry),
                new PortalOriginManager(registry)
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