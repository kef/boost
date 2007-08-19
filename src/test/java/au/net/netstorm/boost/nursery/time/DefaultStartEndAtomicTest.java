package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultStartEndAtomicTest extends InteractionTestCase {
    FieldSpec f1 = new DefaultFieldSpec("start", TimeSpec.class);
    FieldSpec f2 = new DefaultFieldSpec("end", TimeSpec.class);
    FieldSpec[] fields = {f1, f2};

    public void testData() {
        atom.checkAtom(DefaultStartEnd.class, fields);
    }
}
