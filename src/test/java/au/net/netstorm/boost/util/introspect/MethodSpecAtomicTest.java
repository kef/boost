package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.atom.DefaultDataAtomTestChecker;
import junit.framework.TestCase;

public class MethodSpecAtomicTest extends TestCase {
    // FIX SC509 Constants.
    public void testIsDataObject() {
        FieldSpec f1 = new DefaultFieldSpec("name", String.class);
        FieldSpec f2 = new DefaultFieldSpec("params", Class[].class);
        FieldSpec[] fields = {f1, f2};
        new DefaultDataAtomTestChecker().checkAtom(MethodSpec.class, fields);
    }

    public void testNull() {
        try {
            new MethodSpec(null, new Class[]{String.class});
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
