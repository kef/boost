package au.net.netstorm.boost.util.introspect;

import junit.framework.TestCase;
import au.net.netstorm.boost.test.atom.DefaultDataAtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;

public final class DefaultMethodSignatureAtomicTest extends TestCase {
    private final DataAtomTestChecker checker = new DefaultDataAtomTestChecker();
    // FIX SC525 Convert to Object instead of String.
    private FieldSpec returnValue = new DefaultFieldSpec("returnValue", String.class);
    // FIX SC525 Complete this.
    private final FieldSpec[] fields = {returnValue};

    public void testAtom() {
        checker.checkAtom(DefaultMethodSignature.class, fields);
    }
}