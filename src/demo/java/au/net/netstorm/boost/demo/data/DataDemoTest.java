package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.test.atom.DataTestChecker;
import au.net.netstorm.boost.test.atom.DefaultDataTestChecker;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public final class DataDemoTest extends TestCase {
    private DataTestChecker dataChecker = new DefaultDataTestChecker();
    private static final FieldSpec[] NO_FIELDS = {};
    private static final FieldSpec STRING_PROPERTY = new DefaultFieldSpec("guitar", String.class);
    private static final FieldSpec[] SINGLE_STRING_PROPERTY = { STRING_PROPERTY };

    public void testBasic() {
        FieldSpec f1 = new DefaultFieldSpec("frog", String.class);
        FieldSpec[] fields = {f1};
        dataChecker.checkIsData(BasicData.class, fields);
    }

    public void testNotPrimordial() {
        try {
            dataChecker.checkIsData(NotPrimordialData.class, NO_FIELDS);
            barf();
        } catch (AssertionFailedError e) {
            checkMessage(e, "NotPrimordialData is not a subclass of Primordial");
        }
    }

    public void testConstructorParameterCountMismatch() {
        try {
            dataChecker.checkIsData(ConstructorParameterCountMismatchData.class, SINGLE_STRING_PROPERTY);
            barf();
        } catch (AssertionFailedError e) {
            checkMessage(e, "Constructor must have 1 argument(s).  Instead it appears to have 0 arguments(s).");
        }
    }

    // FIX SC600 Test only a single constructor.

    public void testConstructorParameterMismatch() {
        try {
            dataChecker.checkIsData(ConstructorParameterMismatchData.class, SINGLE_STRING_PROPERTY);
            barf();
        } catch (AssertionFailedError e) {
            checkMessage(e, "For constructor parameter 0 we expected:<class java.lang.String> but was:<class java.lang.Integer>");
        }
    }

    public void testFieldNonExistent() {
// FIX SC600 BREADCRUMB COMPLETE.
//        dataChecker.checkIsData(FieldNonExistentData.class, SINGLE_STRING_PROPERTY);
    }

    private void checkMessage(AssertionFailedError e, String expected) {
        String message = e.getMessage();
        assertEquals(expected, message);
    }

    private void barf() {
        throw new RuntimeException("Test failed, however we throw a this exception to distinguish this test failing versus the data test checker failing");
    }


}
