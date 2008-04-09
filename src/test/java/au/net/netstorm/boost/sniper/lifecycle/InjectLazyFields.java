package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.sniper.automock.TestFieldInjector;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.util.type.Marker;

public final class InjectLazyFields implements TestLifecycleBlock {
    TestFieldInjector fieldInjector;
    Marker marker;
    Test test;

    public void execute() {
        if (marker.is(test, LazyFields.class)) fieldInjector.inject(test);
    }
}
