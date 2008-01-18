package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.automock.TestFieldInjector;
import au.net.netstorm.boost.test.core.Test;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.Marker;

public final class InjectLazyFields implements TestLifecycleBlock {
    TestFieldInjector fieldInjector;
    Marker marker;
    Test test;

    public void execute() {
        if (marker.is(test, LazyFields.class)) fieldInjector.inject(test);
    }
}
