package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.spider.core.Destroyable;

public final class DestroyTest implements TestLifecycleBlock {
    Marker marker;
    Test test;

    public void execute() {
        if (marker.is(test, Destroyable.class)) ((Destroyable) test).destroy();
    }
}
