package au.net.netstorm.boost.start;

import au.net.netstorm.boost.test.atom.DataTestChecker;
import au.net.netstorm.boost.test.fixture.DefaultDataTestChecker;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public class VmStyleAtomicTest extends PrimordialTestCase {
    public static final VmStyle VM_STYLE_PINK_FLOYD = new VmStyle("Pink Floyd");
    public static final VmStyle VM_STYLE_ELO = new VmStyle("Electric Light Orchestra");
    public static final VmStyle VM_STYLE_YES = new VmStyle("YES");
    private final DataTestChecker dataChecker = new DefaultDataTestChecker();
    private FieldSpec f1 = new DefaultFieldSpec("style", String.class);
    private final FieldSpec[] fields = {f1};

    public void testIsDataObject() {
        dataChecker.checkIsData(VmStyle.class, fields);
    }

    public void testNull() {
        try {
            new VmStyle(null);
        } catch (IllegalArgumentException e) {
            assertEquals("style parameter should not be null", e.getMessage());
        }
    }
}
