package au.net.netstorm.boost.gunge.lifecycle;

import au.net.netstorm.boost.gunge.core.Test;
import au.net.netstorm.boost.gunge.marker.OverlaysWeb;
import au.net.netstorm.boost.spider.flavour.AllowOverrides;
import au.net.netstorm.boost.spider.register.Registry;
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
