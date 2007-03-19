package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.LooseDataAtomTestChecker;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultMockMethodSpecAtomicTest extends BoooostCase {
    private AtomTestChecker checker = new LooseDataAtomTestChecker();
    private FieldSpec returnValue = new DefaultFieldSpec("returnValue", Object.class);
    private FieldSpec methodName = new DefaultFieldSpec("methodName", String.class);
    private FieldSpec parameters = new DefaultFieldSpec("parameters", Object[].class);
    private FieldSpec[] fields = {returnValue, methodName, parameters};

    public void testAtom() {
        checker.checkAtom(DefaultMockMethodSpec.class, fields);
    }
}