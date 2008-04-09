package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.sniper.automock.TestFieldInjector;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class InjectLazyFields implements TestLifecycleBlock {
    TestFieldInjector fieldInjector;
    Marker marker;
    Test test;

    public void execute() {
        if (marker.is(test, LazyFields.class)) fieldInjector.inject(test);
    }
}
