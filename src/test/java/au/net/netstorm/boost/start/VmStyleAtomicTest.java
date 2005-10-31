package au.net.netstorm.boost.start;

import au.net.netstorm.boost.primordial.PrimordialTestCase;
import au.net.netstorm.boost.util.fixture.DataTestUtil;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;

public class VmStyleAtomicTest extends PrimordialTestCase {
    private static final VmStyle EXPECTED_WEB_SERVICE = new VmStyle("WebService");
    private static final VmStyle EXPECTED_TASK_PROCESSOR = new VmStyle("TaskProcessor");
    private static final VmStyle EXPECTED_RENDERER = new VmStyle("Renderer");

    public void testIsDataObject() {
        DataTestUtil.checkIsDataObject(VmStyle.class, new DefaultFieldSpec[]{
            new DefaultFieldSpec("style", String.class)});
    }

    // FIXME: SC506 Change these.  Provide a couple of basic defaults.
    public void testVmConstants() {
        assertEquals(EXPECTED_WEB_SERVICE, VmStyle.WEB_SERVICE);
        assertEquals(EXPECTED_TASK_PROCESSOR, VmStyle.TASK_PROCESSOR);
        assertEquals(EXPECTED_RENDERER, VmStyle.RENDERER);
    }
}
