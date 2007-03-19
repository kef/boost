package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.automock.BoooostCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public class DefaultInterfaceAtomicTest extends BoooostCase {
    private static final Class NOT_AN_INTERFACE = Object.class;

    // FIX 1715 Remove this.
    // FIX 1715 Assert it is Primordial.
    // FIX 1715 Test is().
    public void testIsDataObject() {
        FieldSpec f1 = new DefaultFieldSpec("type", Class.class);
        FieldSpec[] fields = {f1};
        AtomTestChecker checker = new DataAtomTestChecker();
        checker.checkAtom(DefaultInterface.class, fields);
    }

    // FIX 1715 Complete.
    public void testXxx() {
    }

    public void testTypeIsNotInterface() {
        try {
            new DefaultInterface(NOT_AN_INTERFACE);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
