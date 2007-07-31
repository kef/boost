package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.LooseDataAtomTestChecker;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultMockMethodSpecAtomicTest extends InteractionTestCase {
    AtomTestChecker checker = new LooseDataAtomTestChecker(random);
    FieldSpec returnValue = new DefaultFieldSpec("returnValue", Object.class);
    FieldSpec methodName = new DefaultFieldSpec("methodName", String.class);
    FieldSpec parameters = new DefaultFieldSpec("parameters", Object[].class);
    FieldSpec[] fields = {returnValue, methodName, parameters};

    public void testAtom() {
        checker.checkAtom(DefaultMockMethodSpec.class, fields);
    }
}