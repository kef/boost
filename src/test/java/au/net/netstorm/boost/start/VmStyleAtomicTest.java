package au.net.netstorm.boost.start;

import au.net.netstorm.boost.primordial.PrimordialTestCase;
import au.net.netstorm.boost.util.fixture.DefaultDataTestUtil;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;

public class VmStyleAtomicTest extends PrimordialTestCase {
    public static final VmStyle VM_STYLE_PINK_FLOYD = new VmStyle("Pink Floyd");
    public static final VmStyle VM_STYLE_ELO = new VmStyle("Electric Light Orchestra");
    public static final VmStyle VM_STYLE_YES = new VmStyle("YES");

    public void testIsDataObject() {
        new DefaultDataTestUtil().checkIsData(VmStyle.class, new DefaultFieldSpec[]{
            new DefaultFieldSpec("style", String.class)});
    }
}
