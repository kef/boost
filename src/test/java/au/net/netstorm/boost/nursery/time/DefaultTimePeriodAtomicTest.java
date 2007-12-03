package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.time.core.TimePoint;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultTimePeriodAtomicTest extends InteractionTestCase implements InjectableTest {
    AtomTestChecker checker;
    FieldSpec f1 = new DefaultFieldSpec("start", TimePoint.class);
    FieldSpec f2 = new DefaultFieldSpec("end", TimePoint.class);
    FieldSpec[] fields = {f1, f2};

    public void testData() {
        checker.checkAtom(DefaultTimePeriod.class, fields);
    }
}
