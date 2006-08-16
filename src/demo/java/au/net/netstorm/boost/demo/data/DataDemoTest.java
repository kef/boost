package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.test.atom.DataTestChecker;
import au.net.netstorm.boost.test.atom.DefaultDataTestChecker;
import au.net.netstorm.boost.test.reflect.checker.AssertThrows;
import au.net.netstorm.boost.test.reflect.checker.DefaultAssertThrows;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

// FIX SC600 The duplication section reads "prod".  Change this to "all".
// FIX SC600 This guy currently does not appear in the test reports.
// FIX SC600 Wire into build.

public final class DataDemoTest extends TestCase {
    private DataTestChecker dataChecker = new DefaultDataTestChecker();
    private AssertThrows asserter = new DefaultAssertThrows();
    private static final FieldSpec[] NO_FIELDS = {};

    public void testBasic() {
        FieldSpec f1 = new DefaultFieldSpec("frog", String.class);
        FieldSpec[] fields = {f1};
        dataChecker.checkIsData(BasicData.class, fields);
    }

    public void testNotPrimordial() {
        try {
            dataChecker.checkIsData(NotPrimordialData.class, NO_FIELDS);
        } catch (AssertionFailedError e) {
            checkMessage(e, "NotPrimordialData is not a subclass of Primordial");
        }
    }

    public void testConstructorCountMismatch() {
        try {
            FieldSpec field = new DefaultFieldSpec("fieldName", String.class);
            FieldSpec[] fields = {field};
            dataChecker.checkIsData(ConstructorCountMismatchData.class, fields);
        } catch (AssertionFailedError e) {
            checkMessage(e, "Constructor must have 1 argument(s).  Instead it appears to have 0 arguments(s).");
        }
    }

    private void checkMessage(AssertionFailedError e, String expected) {
        String message = e.getMessage();
        assertEquals(expected, message);
    }
}
