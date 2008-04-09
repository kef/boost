package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.spider.core.Destroyable;
import au.net.netstorm.boost.util.type.Marker;

public final class DestroyTest implements TestLifecycleBlock {
    Marker marker;
    Test test;

    public void execute() {
        if (marker.is(test, Destroyable.class)) ((Destroyable) test).destroy();
    }
}
