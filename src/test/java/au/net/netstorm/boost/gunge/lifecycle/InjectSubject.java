package au.net.netstorm.boost.gunge.lifecycle;

import au.net.netstorm.boost.gunge.automock.TestFieldInjector;
import au.net.netstorm.boost.gunge.core.Test;
import au.net.netstorm.boost.gunge.marker.InjectableSubject;
import au.net.netstorm.boost.util.type.Marker;

public final class InjectSubject implements TestLifecycleBlock {
    Marker marker;
    TestFieldInjector fieldInjector;
    Test test;

    public void execute() {
        if (marker.is(test, InjectableSubject.class)) fieldInjector.injectSubject(test);
    }
}
