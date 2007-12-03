package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.spider.flavour.AllowOverrides;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.test.core.Test;
import au.net.netstorm.boost.test.marker.OverlaysWeb;
import au.net.netstorm.boost.util.type.Marker;

public final class CallOverlaysWeb implements TestLifecycleBlock {
    Registry registry;
    AllowOverrides overrides;
    Marker marker;
    Test test;

    public void execute() {
        overlay();
    }

    private void overlay() {
        if (marker.is(test, OverlaysWeb.class)) overlayWeb();
    }

    private void overlayWeb() {
        overrides.withOverride(new Runnable() {
            public void run() {
                ((OverlaysWeb) test).overlay(registry);
            }
        });
    }
}
