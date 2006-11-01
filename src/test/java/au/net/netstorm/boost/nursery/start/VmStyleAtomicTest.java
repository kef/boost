package au.net.netstorm.boost.nursery.start;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DefaultAtomTestChecker;
import au.net.netstorm.boost.test.atom.PrimordialTestCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public class VmStyleAtomicTest extends PrimordialTestCase {
    public static final VmStyle VM_STYLE_PINK_FLOYD = new VmStyle("Pink Floyd");
    public static final VmStyle VM_STYLE_ELO = new VmStyle("Electric Light Orchestra");
    public static final VmStyle VM_STYLE_YES = new VmStyle("YES");
    private final AtomTestChecker checker = new DefaultAtomTestChecker();
    private FieldSpec f1 = new DefaultFieldSpec("style", String.class);
    private final FieldSpec[] fields = {f1};

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
