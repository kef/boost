package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultAsciiBytesAtomicTest extends InteractionTestCase {
    DataAtomTestChecker checker = new DataAtomTestChecker(random);
    FieldSpec f1 = new DefaultFieldSpec("value", byte[].class);
    FieldSpec[] fields = {f1};

    public void testData() {
        checker.checkAtom(DefaultAsciiBytes.class, fields);
    }
}