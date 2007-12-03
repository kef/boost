package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.test.marker.LazyFields;

public class DefaultMethodSpecAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    FieldSpec f1 = new DefaultFieldSpec("name", String.class);
    FieldSpec f2 = new DefaultFieldSpec("params", Class[].class);
    FieldSpec[] fields = {f1, f2};
    AtomTestChecker checker;

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
