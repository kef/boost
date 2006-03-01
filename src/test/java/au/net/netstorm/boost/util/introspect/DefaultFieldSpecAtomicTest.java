package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.fixture.DataTestUtil;
import au.net.netstorm.boost.util.fixture.DefaultDataTestUtil;
import junit.framework.TestCase;

public class DefaultFieldSpecAtomicTest extends TestCase {
    private final FieldSpec f1 = new DefaultFieldSpec("name", String.class);
    private final FieldSpec f2 = new DefaultFieldSpec("type", Class.class); // FIXME: SC042 Rename.
    private final FieldSpec[] fields = {f1, f2};
    private DataTestUtil data = new DefaultDataTestUtil();

    public void testData() {
        data.checkIsData(DefaultFieldSpec.class, fields);
    }
}
