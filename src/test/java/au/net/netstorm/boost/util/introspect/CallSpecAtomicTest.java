package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.fixture.DataTestUtil;
import au.net.netstorm.boost.util.fixture.DefaultDataTestUtil;
import junit.framework.TestCase;

public class CallSpecAtomicTest extends TestCase {
    private final FieldSpec f1 = new DefaultFieldSpec("methodName", String.class);
    private final FieldSpec f2 = new DefaultFieldSpec("argTypes", Class[].class);
    private final FieldSpec f3 = new DefaultFieldSpec("args", Object[].class);
    private final FieldSpec[] fields = {f1, f2, f3};
    private DataTestUtil dataUtil = new DefaultDataTestUtil();

    public void testData() {
        dataUtil.checkIsData(CallSpec.class, fields);
    }
}
