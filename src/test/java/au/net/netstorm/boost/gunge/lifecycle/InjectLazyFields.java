package au.net.netstorm.boost.gunge.lifecycle;

import au.net.netstorm.boost.gunge.automock.TestFieldInjector;
import au.net.netstorm.boost.gunge.core.Test;
import au.net.netstorm.boost.gunge.marker.LazyFields;
import au.net.netstorm.boost.util.type.Marker;

public final class InjectLazyFields implements TestLifecycleBlock {
    TestFieldInjector fieldInjector;
    Marker marker;
    Test test;

    public void execute() {
        if (marker.is(test, LazyFields.class)) fieldInjector.inject(test);
    }
}
