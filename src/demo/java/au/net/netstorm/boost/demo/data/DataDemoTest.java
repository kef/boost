package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.test.fixture.DataTestChecker;
import au.net.netstorm.boost.test.fixture.DefaultDataTestChecker;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

// FIX SC600 Wire into build.
public final class DataDemoTest extends TestCase {
    private DataTestChecker dataChecker = new DefaultDataTestChecker();
    private static final Class NOT_PRIMORDIAL_CLASS = NotPrimordialData.class;

    public void testPrimordial() {
        FieldSpec[] fields = { };
        try {
            dataChecker.checkIsData(NOT_PRIMORDIAL_CLASS, fields);
        } catch (AssertionFailedError e) {
            // FIX SC600 Do the assertion utilities make this simpler.
            String message = e.getMessage();
            assertEquals("NotPrimordialData is not a subclass of Primordial", message);
        }
    }

    public void testBasic() {
        FieldSpec f1 = new DefaultFieldSpec("frog", String.class);
        FieldSpec[] fields = { f1 };
        dataChecker.checkIsData(BasicData.class, fields);
    }
}
