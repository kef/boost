package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.atom.DefaultDataAtomTestChecker;
import junit.framework.TestCase;

public class MethodSpecAtomicTest extends TestCase {
    private FieldSpec f1 = new DefaultFieldSpec("name", String.class);
    private FieldSpec f2 = new DefaultFieldSpec("params", Class[].class);
    private FieldSpec[] fields = {f1, f2};
    private DataAtomTestChecker checker = new DefaultDataAtomTestChecker();

    public void testIsDataObject() {
        checker.checkAtom(MethodSpec.class, fields);
    }

    // FIX SC600 Remove dupe.
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
