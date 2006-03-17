package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.fixture.DefaultDataTestChecker;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import junit.framework.TestCase;

public class InterfaceAtomicTest extends TestCase {
    private static final Class NOT_AN_INTERFACE = Object.class;

    public void testIsDataObject() {
        // FIXME: SC506 Tidy this up.
        new DefaultDataTestChecker().checkIsData(Interface.class, new DefaultFieldSpec[]{
            new DefaultFieldSpec("type", Class.class)});
    }

    // FIXME: SC506 This is not called as we are no longer wired into Primordial.
    // FIXME: SC523 Replace with normal test method.
    public void failIfTypeIsNotInterface() throws IllegalArgumentException {
        new Interface(NOT_AN_INTERFACE);
    }
}
