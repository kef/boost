package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.util.type.Marker;

public final class InjectTest implements TestLifecycleBlock {
    Injector injector;
    Marker marker;
    Test test;

    public void execute() {
        if (marker.is(test, InjectableTest.class)) injector.inject(test);
    }
}
