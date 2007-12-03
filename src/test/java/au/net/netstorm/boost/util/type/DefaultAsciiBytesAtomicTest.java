package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultAsciiBytesAtomicTest extends InteractionTestCase implements InjectableTest {
    AtomTestChecker checker;
    FieldSpec f1 = new DefaultFieldSpec("value", byte[].class);
    FieldSpec[] fields = {f1};

    public void testData() {
        checker.checkAtom(DefaultAsciiBytes.class, fields);
    }
}