package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;

public class DefaultFieldSpecAtomicTest extends InteractionTestCase implements InjectableTest {
    FieldSpec f1 = new DefaultFieldSpec("name", String.class);
    FieldSpec f2 = new DefaultFieldSpec("type", Class.class);
    FieldSpec[] fields = {f1, f2};
    AtomTestChecker checker;

    public void testData() {
        checker.checkAtom(DefaultFieldSpec.class, fields);
    }
}
