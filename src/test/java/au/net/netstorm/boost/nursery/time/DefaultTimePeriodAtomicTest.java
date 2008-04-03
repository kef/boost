package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.gunge.atom.AtomTestChecker;
import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.InjectableTest;
import au.net.netstorm.boost.gunge.marker.LazyFields;
import au.net.netstorm.boost.time.core.TimePoint;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultTimePeriodAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    AtomTestChecker checker;
    FieldSpec f1 = new DefaultFieldSpec("start", TimePoint.class);
    FieldSpec f2 = new DefaultFieldSpec("end", TimePoint.class);
    FieldSpec[] fields = {f1, f2};

    public void testData() {
        checker.checkAtom(DefaultTimePeriod.class, fields);
    }
}
