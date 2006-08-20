package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.atom.DefaultDataAtomTestChecker;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.TestCase;

public class InterfaceAtomicTest extends TestCase {
    private static final Class NOT_AN_INTERFACE = Object.class;

    public void testIsDataObject() {
        FieldSpec f1 = new DefaultFieldSpec("type", Class.class);
        FieldSpec[] fields = {f1};
        DataAtomTestChecker defaultDataAtomTestChecker = new DefaultDataAtomTestChecker();
        defaultDataAtomTestChecker.checkAtom(Interface.class, fields);
    }

    public void testTypeIsNotInterface() {
        try {
            new Interface(NOT_AN_INTERFACE);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
