package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultStartEndAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    AtomTestChecker checker;
    FieldSpec f1 = new DefaultFieldSpec("start", TimeSpec.class);
    FieldSpec f2 = new DefaultFieldSpec("end", TimeSpec.class);
    FieldSpec[] fields = {f1, f2};

    public void testData() {
        checker.checkAtom(DefaultStartEnd.class, fields);
    }
}
