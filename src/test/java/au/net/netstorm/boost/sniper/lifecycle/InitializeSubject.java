package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.sniper.automock.TestFieldInjector;
import au.net.netstorm.boost.sniper.core.Test;

public final class InitializeSubject implements TestLifecycleBlock {
    TestFieldInjector injector;
    Marker marker;
    Test test;

    public void execute() {
        if (marker.is(test, InjectSubject.class)) injector.initSubject(test);
    }
}
