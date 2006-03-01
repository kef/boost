package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.fixture.DefaultDataTestUtil;
import junit.framework.TestCase;

public class CallSpecAtomicTest extends TestCase {
    private static final FieldSpec FIELD_SPEC_METHOD_NAME = new DefaultFieldSpec("methodName", String.class);
    private static final FieldSpec FIELD_SPEC_ARG_TYPES = new DefaultFieldSpec("argTypes", Class[].class);
    private static final FieldSpec FIELD_SPEC_ARGS = new DefaultFieldSpec("args", Object[].class);
    private static final FieldSpec[] TYPES = {FIELD_SPEC_METHOD_NAME, FIELD_SPEC_ARG_TYPES, FIELD_SPEC_ARGS};

    public void testCallSpec() {
        // FIXME: SC042 To field ... all of these.
        new DefaultDataTestUtil().checkIsData(CallSpec.class, TYPES);
    }
}
