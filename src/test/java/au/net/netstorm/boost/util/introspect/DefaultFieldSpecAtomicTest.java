package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public class DefaultFieldSpecAtomicTest extends InteractionTestCase {
    FieldSpec f1 = new DefaultFieldSpec("name", String.class);
    FieldSpec f2 = new DefaultFieldSpec("type", Class.class);
    FieldSpec[] fields = {f1, f2};
    AtomTestChecker dataChecker = new DataAtomTestChecker(random);

    public void testData() {
        dataChecker.checkAtom(DefaultFieldSpec.class, fields);
    }
}
