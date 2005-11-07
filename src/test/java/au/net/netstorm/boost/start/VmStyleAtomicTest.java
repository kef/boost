package au.net.netstorm.boost.start;

import au.net.netstorm.boost.primordial.PrimordialTestCase;
import au.net.netstorm.boost.util.fixture.DataTestUtil;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;

public class VmStyleAtomicTest extends PrimordialTestCase {
    private static final VmStyle EXPECTED_FRONT_END = new VmStyle("FrontEnd");
    private static final VmStyle EXPECTED_BACK_END = new VmStyle("BackEnd");

    public void testIsDataObject() {
        DataTestUtil.checkIsDataObject(VmStyle.class, new DefaultFieldSpec[]{
            new DefaultFieldSpec("style", String.class)});
    }

    // FIXME: SC506 Change these.  Provide a couple of basic defaults.
    public void testVmConstants() {
        assertEquals(EXPECTED_FRONT_END, VmStyle.FRONT_END);
        assertEquals(EXPECTED_BACK_END, VmStyle.BACK_END);
    }
}
