package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.fixture.DefaultDataTestChecker;
import junit.framework.TestCase;

public class MethodSpecAtomicTest extends TestCase {

    // FIXME: SC509 Constants.
    public void testIsDataObject() {
        new DefaultDataTestChecker().checkIsData(MethodSpec.class, new DefaultFieldSpec[]{
            new DefaultFieldSpec("name", String.class),
            new DefaultFieldSpec("params", Class[].class)});
    }
}
