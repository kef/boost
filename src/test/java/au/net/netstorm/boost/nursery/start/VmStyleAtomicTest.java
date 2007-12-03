package au.net.netstorm.boost.nursery.start;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public class VmStyleAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    public static final VmStyle VM_STYLE_PINK_FLOYD = new VmStyle("Pink Floyd");
    public static final VmStyle VM_STYLE_ELO = new VmStyle("Electric Light Orchestra");
    public static final VmStyle VM_STYLE_YES = new VmStyle("YES");
    FieldSpec f1 = new DefaultFieldSpec("style", String.class);
    FieldSpec[] fields = {f1};
    AtomTestChecker checker;

    public void testIsDataObject() {
        checker.checkAtom(VmStyle.class, fields);
    }

    public void testNull() {
        try {
            new VmStyle(null);
        } catch (IllegalArgumentException e) {
            assertEquals("style parameter should not be null", e.getMessage());
        }
    }
}
