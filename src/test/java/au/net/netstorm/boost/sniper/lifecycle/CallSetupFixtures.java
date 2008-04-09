package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.util.type.Marker;

public final class CallSetupFixtures implements TestLifecycleBlock {
    Marker marker;
    Test test;

    public void execute() {
        if (marker.is(test, HasFixtures.class)) ((HasFixtures) test).setUpFixtures();
    }
}
