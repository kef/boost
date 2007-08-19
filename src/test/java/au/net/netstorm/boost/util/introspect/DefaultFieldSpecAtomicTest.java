package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public class DefaultFieldSpecAtomicTest extends InteractionTestCase {
    FieldSpec f1 = new DefaultFieldSpec("name", String.class);
    FieldSpec f2 = new DefaultFieldSpec("type", Class.class);
    FieldSpec[] fields = {f1, f2};
    // FIX 1914 Remove all declared atom checkers.
//    AtomTestChecker dataChecker = new DataAtomTestChecker(random);

    public void testData() {
        atom.checkAtom(DefaultFieldSpec.class, fields);
    }
}
