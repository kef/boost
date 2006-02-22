package au.net.netstorm.boost.util.introspect;

import junit.framework.TestCase;
import au.net.netstorm.boost.util.fixture.DataTestUtil;

public class MethodSpecAtomicTest extends TestCase {

    // FIXME: SC509 Constants.
    public void testIsDataObject() {
        new DataTestUtil().checkIsDataObject(MethodSpec.class, new DefaultFieldSpec[]{
            new DefaultFieldSpec("name", String.class),
            new DefaultFieldSpec("params", Class[].class)});
    }
}
