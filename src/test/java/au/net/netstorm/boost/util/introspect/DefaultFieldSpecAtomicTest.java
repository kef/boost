package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.test.marker.LazyFields;

public class DefaultFieldSpecAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    FieldSpec f1 = new DefaultFieldSpec("name", String.class);
    FieldSpec f2 = new DefaultFieldSpec("type", Class.class);
    FieldSpec[] fields = {f1, f2};
    AtomTestChecker checker;

    public void testData() {
        checker.checkAtom(DefaultFieldSpec.class, fields);
    }
}
