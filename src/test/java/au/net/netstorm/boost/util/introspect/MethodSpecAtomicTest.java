package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.fixture.DefaultDataTestChecker;
import junit.framework.TestCase;

public class MethodSpecAtomicTest extends TestCase {

    // FIX SC509 Constants.
    public void testIsDataObject() {
        new DefaultDataTestChecker().checkIsData(MethodSpec.class, new DefaultFieldSpec[]{
            new DefaultFieldSpec("name", String.class),
            new DefaultFieldSpec("params", Class[].class)});
    }

    public void testNull() {
        try {
            new MethodSpec(null, new Class[] {String.class});
        } catch (IllegalArgumentException e) {
            assertEquals("name parameter should not be null", e.getMessage());
        }
        try {
            new MethodSpec("params", null);
        } catch (IllegalArgumentException e) {
            assertEquals("params parameter should not be null", e.getMessage());
        }
    }
}
