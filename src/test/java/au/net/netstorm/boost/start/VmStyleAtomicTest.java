package au.net.netstorm.boost.start;

import au.net.netstorm.boost.test.fixture.DefaultDataTestChecker;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;

public class VmStyleAtomicTest extends PrimordialTestCase {
    public static final VmStyle VM_STYLE_PINK_FLOYD = new VmStyle("Pink Floyd");
    public static final VmStyle VM_STYLE_ELO = new VmStyle("Electric Light Orchestra");
    public static final VmStyle VM_STYLE_YES = new VmStyle("YES");

    public void testIsDataObject() {
        new DefaultDataTestChecker().checkIsData(VmStyle.class, new DefaultFieldSpec[]{
            new DefaultFieldSpec("style", String.class)});
    }

    public void testNull() {
        try {
            new VmStyle(null);
        } catch (IllegalArgumentException e) {
            assertEquals("style parameter should not be null", e.getMessage());
        }
    }
}
