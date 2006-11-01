package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.atom.MutableNullableDataAtomTestChecker;
import junit.framework.TestCase;

public final class DefaultMethodSignatureAtomicTest extends TestCase {
    private final DataAtomTestChecker checker = new MutableNullableDataAtomTestChecker();
    private FieldSpec returnValue = new DefaultFieldSpec("returnValue", Object.class);
    // FIX 525 Complete this.
    private final FieldSpec[] fields = {returnValue};

    public void testAtom() {
        checker.checkAtom(DefaultMethodSignature.class, fields);
    }
}