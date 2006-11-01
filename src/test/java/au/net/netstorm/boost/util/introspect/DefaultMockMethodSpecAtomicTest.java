package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.LooseDataAtomTestChecker;
import junit.framework.TestCase;

// FIX 525 Rename to method expectation or method mock.
// FIX 525 Since it is a method expectation move it into the automocking area.
public final class DefaultMockMethodSpecAtomicTest extends TestCase {
    private final AtomTestChecker checker = new LooseDataAtomTestChecker();
    private FieldSpec returnValue = new DefaultFieldSpec("returnValue", Object.class);
    private FieldSpec methodName = new DefaultFieldSpec("methodName", String.class);
    private FieldSpec parameters = new DefaultFieldSpec("parameters", Object[].class);
    // FIX 525 Complete this.
    private final FieldSpec[] fields = {returnValue, methodName, parameters};

    public void testAtom() {
        checker.checkAtom(DefaultMockMethodSpec.class, fields);
    }
}