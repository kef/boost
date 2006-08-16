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
    private static final Class NOT_PRIMORDIAL_CLASS = NotPrimordialData.class;
    private DataTestChecker dataChecker = new DefaultDataTestChecker();
    private AssertThrows asserter = new DefaultAssertThrows();

    public void testPrimordial() {
        FieldSpec[] fields = {};
        try {
            dataChecker.checkIsData(NOT_PRIMORDIAL_CLASS, fields);
        } catch (AssertionFailedError e) {
            // FIX SC600 Do the assertion utilities make this simpler.
            String message = e.getMessage();
            assertEquals("NotPrimordialData is not a subclass of Primordial", message);
        }
    }

    // FIX SC600 Remove this or the one above.  Looks smaller than the one above.
    // FIX SC600 Would use this however the asserter catches AssertionFailedException.
//    public void testPrimordial2() {
//        final FieldSpec[] fields = { };
//        Block block = new Block() {
//            public void execute() {
//                dataChecker.checkIsData(NOT_PRIMORDIAL_CLASS, fields);
//            }
//        };
//        asserter.assertThrows(AssertionFailedError.class, "NotPrimordialData is not a subclass of Primordial", block);
//    }

    public void testBasic() {
        FieldSpec f1 = new DefaultFieldSpec("frog", String.class);
        FieldSpec[] fields = {f1};
        dataChecker.checkIsData(BasicData.class, fields);
    }
}
