package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public class DefaultMethodSpecAtomicTest extends InteractionTestCase {
    FieldSpec f1 = new DefaultFieldSpec("name", String.class);
    FieldSpec f2 = new DefaultFieldSpec("params", Class[].class);
    FieldSpec[] fields = {f1, f2};
    AtomTestChecker checker = new DataAtomTestChecker(specifics);

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
