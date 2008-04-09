package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.sniper.automock.TestFieldInjector;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;

public final class InjectSubject implements TestLifecycleBlock {
    Marker marker;
    TestFieldInjector fieldInjector;
    Test test;

    public void execute() {
        if (marker.is(test, InjectableSubject.class)) fieldInjector.injectSubject(test);
    }
}
