package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultAsciiBytesAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    AtomTestChecker checker;
    FieldSpec f1 = new DefaultFieldSpec("value", byte[].class);
    FieldSpec[] fields = {f1};

    public void testData() {
        checker.checkAtom(DefaultAsciiBytes.class, fields);
    }
}