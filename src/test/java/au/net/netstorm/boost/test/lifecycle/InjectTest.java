package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.test.core.Test;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.util.type.Marker;

public final class InjectTest implements TestLifecycleBlock {
    Injector injector;
    Marker marker;
    Test test;

    public void execute() {
        if (marker.is(test, InjectableTest.class)) injector.inject(test);
    }
}
