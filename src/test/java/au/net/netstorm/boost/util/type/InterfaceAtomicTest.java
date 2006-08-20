package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.fixture.OldDataAtomTestChecker;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import junit.framework.TestCase;

public class InterfaceAtomicTest extends TestCase {
    private static final Class NOT_AN_INTERFACE = Object.class;

    public void testIsDataObject() {
        DefaultFieldSpec[] fields = {new DefaultFieldSpec("type", Class.class)};
        new OldDataAtomTestChecker().checkAtom(Interface.class, fields);
    }

    public void testTypeIsNotInterface() {
        try {
            new Interface(NOT_AN_INTERFACE);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
