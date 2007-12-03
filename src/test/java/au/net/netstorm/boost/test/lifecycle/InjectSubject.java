package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.automock.TestFieldInjector;
import au.net.netstorm.boost.test.core.Test;
import au.net.netstorm.boost.test.marker.InjectableSubject;
import au.net.netstorm.boost.util.type.Marker;

public final class InjectSubject implements TestLifecycleBlock {
    Marker marker;
    TestFieldInjector fieldInjector;
    Test test;

    public void execute() {
        if (marker.is(test, InjectableSubject.class)) fieldInjector.injectSubject();
    }
}
