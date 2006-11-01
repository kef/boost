package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import junit.framework.TestCase;

public class DefaultMethodSpecAtomicTest extends TestCase {
    private FieldSpec f1 = new DefaultFieldSpec("name", String.class);
    private FieldSpec f2 = new DefaultFieldSpec("params", Class[].class);
    private FieldSpec[] fields = {f1, f2};
    private AtomTestChecker checker = new DataAtomTestChecker();

    public void testIsDataObject() {
        checker.checkAtom(DefaultMethodSpec.class, fields);
    }

    public void testNull() {
        checkNull(null, new Class[]{String.class});
        checkNull("params", null);
    }

    private void checkNull(String name, Class[] params) {
        try {
            new DefaultMethodSpec(name, params);
        } catch (IllegalArgumentException e) { }
    }
}
