package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.time.core.TimePoint;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultTimePeriodAtomicTest extends InteractionTestCase {
    FieldSpec f1 = new DefaultFieldSpec("start", TimePoint.class);
    FieldSpec f2 = new DefaultFieldSpec("end", TimePoint.class);
    FieldSpec[] fields = {f1, f2};

    public void testData() {
        atom.checkAtom(DefaultTimePeriod.class, fields);
    }
}
