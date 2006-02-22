package au.net.netstorm.boost.util.introspect;

import junit.framework.TestCase;
import au.net.netstorm.boost.util.fixture.DefaulltDataTestUtil;

public class MethodSpecAtomicTest extends TestCase {

    // FIXME: SC509 Constants.
    public void testIsDataObject() {
        new DefaulltDataTestUtil().checkIsData(MethodSpec.class, new DefaultFieldSpec[]{
            new DefaultFieldSpec("name", String.class),
            new DefaultFieldSpec("params", Class[].class)});
    }
}
